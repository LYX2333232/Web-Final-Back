package com.example.webfinal.controller.seller;

import com.example.webfinal.mapper.seller.SellerListMapper;
import com.example.webfinal.pojo.Good;
import com.example.webfinal.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class ListController {
    @Autowired
    private SellerListMapper mapper;

    @GetMapping("/getGoodList")
    public Result getGoodsList(@RequestParam Integer buyerId,@RequestParam(required = false) String name,@RequestParam(required = false) Float minPrice,@RequestParam(required = false) Float maxPrice){
        List<Good> data = mapper.getGoodsList(buyerId);
        log.info(name);
        if (!Objects.equals(name, "")){
            data = data.stream().filter(item-> Objects.equals(item.getName(), name)).toList();
        }
        if (minPrice != null){
            data = data.stream().filter(item-> item.getPrice()>=minPrice).toList();
        }
        if (maxPrice != null){
            data = data.stream().filter(item->item.getPrice()<=maxPrice).toList();
        }
        return Result.success("获取成功",data);
    }

    @PostMapping("/addGood")
    public Result addGood(@ModelAttribute Good good){
        if (mapper.addGood(good) >0){
            return Result.success("添加成功");
        }
        else return Result.error("添加失败");
    }

    @DeleteMapping("/deleteGood")
    public Result deleteGood(@RequestParam Integer id){
        if (mapper.deleteGood(id) > 0){
            return Result.success("删除成功");
        }
        else return Result.error("删除失败");
    }
}
