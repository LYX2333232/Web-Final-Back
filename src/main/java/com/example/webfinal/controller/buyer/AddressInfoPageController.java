package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerAddressInfoPageMapper;
import com.example.webfinal.pojo.Address;
import com.example.webfinal.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressInfoPageController {
    @Autowired
    private BuyerAddressInfoPageMapper mapper;

    @GetMapping("/getAddressInfo")
    public Result getAddressInfo(@RequestParam Integer id) {
        List<Address> data = mapper.getAddressInfo(id);
        return Result.success("获取信息成功", data);
    }

    @PostMapping("/newAddress")
    public Result newAddress(@ModelAttribute Address address) {
        if (mapper.newAddress(address) > 0) {
            return Result.success("新增成功");
        } else
            return Result.success("新增失败");
    }

    @PostMapping("/updateAddress")
    public Result updateAddress(@ModelAttribute Address address){
        if (mapper.updateAddress(address)>0){
            return Result.success("修改成功");
        }
        else return Result.error("修改失败");
    }

    @DeleteMapping("/deleteAddess")
    public Result deleteAddess(@RequestParam Integer id){
        if (mapper.deleteAddress(id) >0){
            return Result.success("删除成功");
        }
        else return Result.error("删除失败");
    }
}
