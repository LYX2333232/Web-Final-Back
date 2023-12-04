package com.example.webfinal.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Buyer {
    private Integer id;
    private String username;
    private Integer age;
    private Integer gender;
    private String password;
    private String nickname;
}
