package com.example.webfinal.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Integer id;
    private Integer buyerId;
    private List<Integer> goods;
    private String name;
    private String phone;
    private String address;
}