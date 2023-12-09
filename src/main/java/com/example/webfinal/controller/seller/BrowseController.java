package com.example.webfinal.controller.seller;

import com.example.webfinal.mapper.seller.SellerBrowseMapper;
import com.example.webfinal.pojo.Record;
import com.example.webfinal.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class BrowseController {
    @Autowired
    private SellerBrowseMapper mapper;

    @GetMapping("/getBrowse")
    public Result getBrowse(@RequestParam Integer sellerId,@RequestParam(required = false) String userName,@RequestParam(required = false)String goodName,@RequestParam(required = false) String startTime,@RequestParam(required = false)String endTime){
        log.info(String.valueOf(sellerId));
        List<Record> data = mapper.getBrowse(sellerId);
        log.info(data.toString());
        if (!Objects.equals(userName, "")){
            data = data.stream().filter(item-> Objects.equals(item.getBuyerName(), userName)).toList();
        }
        if (!Objects.equals(goodName, "")){
            data = data.stream().filter(item-> Objects.equals(item.getBuyerName(), goodName)).toList();
        }
        if (!Objects.equals(startTime,"")){
            LocalDateTime time = LocalDateTime.parse(startTime);
            data = data.stream().filter(item->item.getTime().isAfter(time)).toList();
        }
        if (!Objects.equals(endTime,"")){
            LocalDateTime time = LocalDateTime.parse(endTime);
            data = data.stream().filter(item->item.getTime().isBefore(time)).toList();
        }
        return Result.success("获取数据成功",data);
    }

}
