package com.example.webfinal;

import com.example.webfinal.Mapper.UserMapper;
import com.example.webfinal.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebFinalApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect(){
        System.out.println(1);
        List<User> userList = userMapper.list();
        userList.forEach(System.out::println);
    }

}
