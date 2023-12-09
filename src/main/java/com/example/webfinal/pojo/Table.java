package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private Integer id;
    private String name;
    private String image;
    private Float price;
    private Integer sold;
    private String orderIds;
}
