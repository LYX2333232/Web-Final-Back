package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyerOrderMapper {
    @Select("select * from orders where buyerId=#{buyerId}")
    List<Order> getOrders(Integer buyerId);

    @Insert("insert into orders (buyerId, goods, name, phone, address) VALUES (#{buyerId},#{goods},#{name},#{phone},#{address})")
    Integer newOrder(Order order);
}
