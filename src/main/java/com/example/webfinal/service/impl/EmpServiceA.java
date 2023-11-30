package com.example.webfinal.service.impl;

import com.example.webfinal.dao.EmpDao;
import com.example.webfinal.pojo.Emp;
import com.example.webfinal.service.EmpSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpSerivce {

    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        return empDao.listEmp();
    }
}
