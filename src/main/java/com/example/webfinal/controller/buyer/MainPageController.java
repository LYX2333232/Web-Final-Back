package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerMainPageMapper;
import com.example.webfinal.pojo.Good;
import com.example.webfinal.pojo.Order;
import com.example.webfinal.pojo.Record;
import com.example.webfinal.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RestController
public class MainPageController {
    @Autowired
    private BuyerMainPageMapper mapper;

    @GetMapping("/getGoods")
    public Result getGoods(){
        List<Integer> ids = mapper.getAllIds();
        //如果大于8，则随机获取8个商品
        if (ids.size()>8){
            Collections.shuffle(ids);//重新随机排序以获得随机的8个商品
            ids = ids.subList(0,8);
            ids.sort(Comparator.naturalOrder());//按从小到大的顺序排序
        }
        List<Good> records = mapper.getGoods(ids);
        return Result.success("获取数据成功",records);
    }

    @GetMapping("/getDetail")
    public Result getDetail(Integer id){
        Good list = mapper.getDetail(id);
        if (list == null){
            return Result.error("不存在该数据！");
        }
        else return Result.success("获取数据成功",list);
    }

    @PostMapping("/buy")
    public Result buy(@RequestBody Order order){
        log.info(String.valueOf(order));
        if (mapper.buy(order)>0){
            mapper.addOrder(order);
            mapper.updateGoodInfo(order.getGoodId(),order.getId());
            //发送邮件！！
            return Result.success("购买成功",order);
        }
        else return Result.error("购买失败");
    }

    @PostMapping("/addToCart")
    public Result addToCart(@RequestBody Record record){
        log.info(String.valueOf(record));
        if (!mapper.check(record).isEmpty()){
            if(mapper.addNumber(record)>0){
                return Result.success("添加成功");
            }
            else return Result.error("添加失败");
        }else {
            if (mapper.addToCart(record) > 0) {
                return Result.success("添加成功");
            } else return Result.error("添加失败");
        }
    }

    @PostMapping("/postBrowse")
    public Result postBrowse(@RequestBody Record record){
        log.info(String.valueOf(record));
        if (mapper.browse(record)>0){
            return Result.success("记录成功");
        }
        else return Result.error("记录失败");
    }
}
