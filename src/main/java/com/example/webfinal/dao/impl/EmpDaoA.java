package com.example.webfinal.dao.impl;

import com.example.webfinal.dao.EmpDao;
import com.example.webfinal.pojo.Emp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = new ArrayList<>();
        for(int i = 0;i<3;i++)
        {
            String name = "lyx";
            String phone = "12345678910";
            Integer age = i+10;
            Emp e = new Emp(name,phone,age);
            empList.add(e);
        }
        return empList;
    }
}
