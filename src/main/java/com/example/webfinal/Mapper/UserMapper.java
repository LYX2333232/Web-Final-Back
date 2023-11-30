package com.example.webfinal.Mapper;

import com.example.webfinal.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper()
public interface UserMapper {
    @Select("select * from names;")
    public List<User> list();
}
