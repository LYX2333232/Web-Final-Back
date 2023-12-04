package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerMainPageMapper;
import com.example.webfinal.pojo.Good;
import com.example.webfinal.pojo.Record;
import com.example.webfinal.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class MainPageController {
    @Autowired
    private BuyerMainPageMapper mapper;

    @GetMapping("/getGoods")
    public Result getGoods(){
        List<Integer> ids = mapper.getAllIds();
        //如果大于8，则随机获取8个商品
        if (ids.size()>6){
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
    public Result buy(@RequestParam Integer goodId,@RequestParam Integer buyerId){

        LocalDateTime time = LocalDateTime.now();
        Record record = new Record(null,goodId,buyerId,time);
        if (mapper.buy(record)>0){
            return Result.success("购买成功");
        }
        else return Result.error("购买失败");
    }

    @PostMapping("/addToCart")
    public Result addToCart(@RequestParam Integer goodId,@RequestParam Integer buyerId){
        Record record = new Record(null,goodId,buyerId,null);
        if(mapper.addToCart(record)>0){
            return Result.success("添加成功");
        }
        else return Result.error("添加失败");
    }

    @PostMapping("/postBrowse")
    public Result postBrowse(@RequestParam Integer goodId,@RequestParam Integer buyerId){
        Record record = new Record(null,goodId,buyerId,LocalDateTime.now());
        if (mapper.browse(record)>0){
            return Result.success("记录成功");
        }
        else return Result.error("记录失败");
    }
}
