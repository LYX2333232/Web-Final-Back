package com.example.webfinal.controller;

import com.example.webfinal.pojo.Emp;
import com.example.webfinal.service.EmpSerivce;
import com.example.webfinal.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;
@RestController
public class EmpController {
    @Autowired
    private  EmpSerivce empSerivce;

    @RequestMapping("/listEmp")
    public List<Emp> list() throws Exception{
        return empSerivce.listEmp();
    }

    @RequestMapping("/1")
    public String get(){
        return "1";
    }
}
