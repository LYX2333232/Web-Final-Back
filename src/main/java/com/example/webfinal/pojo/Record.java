package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Integer id;
    private Integer buyerId;
    private String buyerName;
    private Integer goodId;
    private String goodName;
    private String time;
}
