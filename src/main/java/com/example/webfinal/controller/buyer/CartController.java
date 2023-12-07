package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerCartMapper;
import com.example.webfinal.pojo.Cart;
import com.example.webfinal.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private BuyerCartMapper mapper;

    @GetMapping("/getCartInfo")
    public Result getCartInfo(@RequestParam Integer buyerId){
        List<Cart> data = mapper.getCart(buyerId);
        return Result.success("获取数据成功",data);
    }

    @DeleteMapping("/deleteCartInfo")
    public Result deleteCartInfo(@RequestParam Integer id){
        if (mapper.deleteGood(id) >0){
            return Result.success("删除成功");
        }
        else return Result.error("删除失败");
    }

    @PostMapping("/changeNumber")
    public Result changeNumber(@RequestParam Integer id,@RequestParam Integer number){
        if (mapper.changeNumber(id, number)>0){
            return Result.success("修改成功");
        }
        else return Result.error("修改失败");
    }
}
