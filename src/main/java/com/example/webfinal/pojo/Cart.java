package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Integer id;
    private Integer buyerId;
    private Integer goodId;
    private Integer number;
    private String name;
    private String image;
    private Integer price;
}
