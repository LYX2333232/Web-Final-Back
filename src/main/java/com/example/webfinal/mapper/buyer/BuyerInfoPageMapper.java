package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Buyer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BuyerInfoPageMapper {
    @Select("select * from buyers where id=#{id}")
    Buyer getInfo(Integer id);

    @Update("update buyers set age=#{age},nickname=#{nickname},gender=#{gender} where id=#{id}")
    Integer updateInfo(Buyer buyer);
}
