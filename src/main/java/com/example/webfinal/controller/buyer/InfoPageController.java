package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerInfoPageMapper;
import com.example.webfinal.pojo.Buyer;
import com.example.webfinal.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class InfoPageController {
    @Autowired
    private BuyerInfoPageMapper mapper;

    @GetMapping("/getBuyerInfo")
    public Result getInfo(@RequestParam Integer id){
        Buyer buyer = mapper.getInfo(id);
        if (buyer == null){
            return Result.error("获取数据失败");
        }
        else
            return Result.success("获取成功",buyer);
    }

    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody Buyer buyer){
        log.info(String.valueOf(buyer));
        if (mapper.updateInfo(buyer) > 0){
            return Result.success("修改成功");
        }
        else return Result.error("修改失败");
    }
}
