package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerOrderMapper;
import com.example.webfinal.pojo.Order;
import com.example.webfinal.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private BuyerOrderMapper mapper;

    @GetMapping("/getOrderInfo")
    public Result getOrderInfo(@RequestParam Integer id){
        Order data = mapper.getOrder(id);
        return Result.success("获取数据成功",data);
    }
    @GetMapping("/getAllOrders")
    public Result getOrders(@RequestParam Integer buyerId){
        List<Order> data = mapper.getOrders(buyerId);
        return Result.success("获取数据成功",data);
    }

    @PostMapping("/newOrder")
    public Result newOrder(@RequestBody Order order){
        if (mapper.newOrder(order) > 0){
            return Result.success("添加成功",order);
        }
        else return Result.error("添加失败");
    }
}
