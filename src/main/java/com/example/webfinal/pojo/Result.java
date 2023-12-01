package com.example.webfinal.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code; //响应码， 200成功
    private String msg;//响应信息
    private Object data;

    //成功
    public static Result success(String msg){return new Result(200,msg,null);}
    public static Result success(Object data) { return new Result(200,"success",data); }
    public static Result success(String msg,Object data) {return new Result(200,msg,data);}

    //失败
    public static Result error(String msg) { return new Result(400,msg,null);}
}
