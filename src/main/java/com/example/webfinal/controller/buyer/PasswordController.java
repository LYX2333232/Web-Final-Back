package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerPasswordMapper;
import com.example.webfinal.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    @Autowired
    private BuyerPasswordMapper mapper;

    @PostMapping("/changePassword")
    public Result changePassword(@RequestParam Integer id, @RequestParam String oldPassword, @RequestParam String newPassword){
        //判断原密码是否输入正确
        if (mapper.check(id,oldPassword) != null){
            if (mapper.change(id,newPassword)>0){
                return Result.success("密码修改成功");
            }
            else return Result.error("密码修改失败");
        }
        else return Result.error("原密码有误");
    }
}
