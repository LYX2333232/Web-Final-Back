package com.example.webfinal.pojo;

public class Emp {

    private String name;
    private String phone;
    private Integer age;

    public Emp() {

    }

    public  Emp(String n,String p,Integer a){
        name = n;
        phone = p;
        age = a;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
