package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Buyer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyerLoginMapper {
    //判断是否有该用户名
    @Select("select count(*) from buyers where username=#{username}")
    public int check(String username);

    //注册新用户
    @Insert("insert into buyers (username,password,nickname) values (#{username},#{password},#{username})")
    public void register(Buyer buyer);

    //登录
    @Select("select id from buyers where username=#{username} and password=#{password} ")
    public List<Integer> login(Buyer buyer);
}
