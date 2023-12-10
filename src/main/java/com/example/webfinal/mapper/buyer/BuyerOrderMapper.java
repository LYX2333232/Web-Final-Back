package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyerOrderMapper {
    @Select("select * from orders where id=#{id}")
    Order getOrder(Integer id);

    @Select("select * from orders where buyerId=#{buyerId}")
    List<Order> getOrders(Integer buyerId);

    @Insert("insert into orders (buyerId, goodId, name, phone, email,time,number) VALUES (#{buyerId},#{goodId},#{name},#{phone},#{email},#{time},#{number})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer newOrder(Order order);
}
