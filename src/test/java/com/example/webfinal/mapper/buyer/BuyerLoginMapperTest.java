package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Buyer;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerLoginMapperTest {

    @Autowired
    private BuyerLoginMapper loginMapper;
    @Test
    void check() {
        System.out.println(loginMapper.check("lyx"));
    }
    @Test
    void register(){
        Buyer buyer = new Buyer();
        buyer.setUsername("cky");
        buyer.setPassword("password");
        System.out.println(loginMapper.register(buyer));
    }
}