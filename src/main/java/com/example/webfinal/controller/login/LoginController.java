package com.example.webfinal.controller.login;

import com.example.webfinal.mapper.buyer.BuyerLoginMapper;
import com.example.webfinal.mapper.seller.SellerLoginMapper;
import com.example.webfinal.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private BuyerLoginMapper buyerLogin;
    @Autowired
    private SellerLoginMapper sellerLogin;
    @PostMapping("/register")
    public Result register(@ModelAttribute LoginUser user){
        //买家登录
        if (Objects.equals(user.getOccupation(), "buyer")) {
            //log.info("登录：{}", buyer );
            if (buyerLogin.check(user.getUsername()) > 0) {
                return Result.error("该用户名已存在");
            } else {
                Buyer buyer = new Buyer();
                buyer.setUsername(user.getUsername());
                buyer.setPassword(user.getPassword());
                buyerLogin.register(buyer);
                return Result.success("注册成功");
            }
        }
        //卖家登录
        else {
            if (sellerLogin.check(user.getUsername()) > 0) {
                return Result.error("该用户名已存在");
            } else {
                Seller seller = new Seller();
                seller.setUsername(user.getUsername());
                seller.setPassword(user.getPassword());
                sellerLogin.register(seller);
                return Result.success("注册成功");
            }
        }
    }
    @PostMapping("/login")
    public Result login(@ModelAttribute LoginUser user){
        //买家登录
        if (Objects.equals(user.getOccupation(),"buyer")) {
            Buyer buyer = new Buyer();
            buyer.setPassword(user.getPassword());
            buyer.setUsername(user.getUsername());
            List<Integer> res = buyerLogin.login(buyer);
            if (!res.isEmpty()) {
                GetId data = new GetId();
                data.setId(res.get(0));
                return Result.success("登录成功",data);
            }
            else return Result.error("登陆失败");
        }
        //卖家登录
        else {
            Seller seller = new Seller();
            seller.setUsername(user.getUsername());
            seller.setPassword(user.getPassword());
            List<Integer> res = sellerLogin.login(seller);
            if (!res.isEmpty()){
                GetId data = new GetId();
                data.setId(res.get(0));
                return Result.success("登录成功",data);
            }
            else return Result.error("登录失败");
        }
    }

}
