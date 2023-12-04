package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private Integer id;
    private String name;
    private Float price;
    private String image;
    private Integer sold;
    private String desc;
}
