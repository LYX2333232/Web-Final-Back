package com.example.webfinal.mapper.seller;

import com.example.webfinal.pojo.Buyer;
import com.example.webfinal.pojo.Order;
import com.example.webfinal.pojo.Record;
import com.example.webfinal.pojo.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SellerBuyRecordsMapper {
    @Select("select * from goods where seller_id=#{sellerId}")
    List<Table> getRecords(Integer sellerId);

    @Select("select * from goods where id=#{id}")
    Table getRecord(Integer id);

    @Select("select * from orders where id=#{id}")
    Order getOrder(Integer id);
}
