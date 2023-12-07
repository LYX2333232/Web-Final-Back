package com.example.webfinal.mapper.buyer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BuyerPasswordMapper {
    @Select("select password from buyers where id=#{id} and password=#{password}")
    String check(Integer id,String password);

    @Update("update buyers set password=#{password} where id=#{id}")
    Integer change(Integer id,String password);
}
