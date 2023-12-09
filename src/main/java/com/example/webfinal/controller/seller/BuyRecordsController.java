package com.example.webfinal.controller.seller;

import com.example.webfinal.mapper.seller.SellerBuyRecordsMapper;
import com.example.webfinal.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class BuyRecordsController {
    @Autowired
    private SellerBuyRecordsMapper mapper;

    @GetMapping("/getTable")
    public Result getTable(@RequestParam Integer sellerId,@RequestParam(required = false) String name,@RequestParam(required = false) Float minPrice,@RequestParam(required = false) Float maxPrice,@RequestParam(required = false) Integer minSold,@RequestParam(required = false) Integer maxSold){
        List<Table> data = mapper.getRecords(sellerId);
        if (!Objects.equals(name, "")){
            data = data.stream().filter(item-> Objects.equals(item.getName(), name)).toList();
        }
        if (minPrice != null){
            data = data.stream().filter(item->item.getPrice()>=minPrice).toList();
        }
        if (maxPrice != null){
            data = data.stream().filter(item->item.getPrice()<=maxPrice).toList();
        }
        if (minSold != null){
            data = data.stream().filter(item->item.getSold()>=minSold).toList();
        }
        if (maxSold != null){
            data = data.stream().filter(item->item.getSold()<=maxSold).toList();
        }
        return Result.success("获取数据成功",data);
    }

    @GetMapping("/getTableDetail")
    public Result getTableDetail(@RequestParam Integer id){
        Table table = mapper.getRecord(id);
        TableDetail detail = new TableDetail(table.getId(),table.getName(),table.getImage(),table.getPrice(), table.getSold(), new ArrayList<>());
        String[] orders = table.getOrderIds().split(",");
        for (String str : orders){
            Order order = mapper.getOrder(Integer.parseInt(str));
            detail.addBuyer(order);
        }
        return Result.success("获取成功",detail);
    }
}
