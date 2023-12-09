package com.example.webfinal.controller.buyer;

import com.example.webfinal.mapper.buyer.BuyerPasswordMapper;
import com.example.webfinal.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    @Autowired
    private BuyerPasswordMapper mapper;

    public static class Password{
        public Integer id;
        public String oldPassword;
        public String newPassword;
    }
    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody Password password){
        //判断原密码是否输入正确
        if (mapper.check(password.id,password.oldPassword) != null){
            if (mapper.change(password.id, password.newPassword)>0){
                return Result.success("密码修改成功");
            }
            else return Result.error("密码修改失败");
        }
        else return Result.error("原密码有误");
    }
}
