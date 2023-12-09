package com.example.webfinal.mapper.seller;

import com.example.webfinal.pojo.Good;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SellerListMapper {
    @Select("select * from goods where seller_id=#{id}")
    List<Good> getGoodsList(Integer id);

    @Insert("insert into goods (name, price, image, `desc`, seller_id) VALUES (#{name},#{price},#{image},#{desc},#{sellerId})")
    Integer addGood(Good good);

    @Delete("delete from goods where id=#{id}")
    Integer deleteGood(Integer id);
}
