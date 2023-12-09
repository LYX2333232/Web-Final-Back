package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TableDetail {
    private Integer id;
    private String name;
    private String image;
    private Float price;
    private Integer sold;
    private List<Order> orders;

    public void addBuyer(Order order){
        orders.add(order);
    }
}
