package com.example.webfinal.mapper.seller;

import com.example.webfinal.pojo.Seller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SellerLoginMapper {
    //判断是否有该用户名
    @Select("select count(*) from sellers where username=#{username}")
    int check(String username);

    //注册新用户
    @Insert("insert into sellers (username,password) values (#{username},#{password})")
    void register(Seller seller);

    //登录
    @Select("select id from sellers where username=#{username} and password=#{password} ")
    Integer login(Seller seller);
}
