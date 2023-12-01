package com.example.webfinal.service;

import com.example.webfinal.mapper.buyer.BuyerLoginMapper;
import com.example.webfinal.pojo.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface buyerLogin {

    public void register(Buyer buyer);

    public void login(Buyer buyer);
}
