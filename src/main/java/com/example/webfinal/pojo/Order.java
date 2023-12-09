package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer buyerId;
    private Integer goodId;
    private String name;
    private String phone;
    private String email;
    private String time;
}
