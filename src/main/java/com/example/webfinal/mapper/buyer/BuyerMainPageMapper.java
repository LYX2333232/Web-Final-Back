package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Cart;
import com.example.webfinal.pojo.Good;
import com.example.webfinal.pojo.Order;
import com.example.webfinal.pojo.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuyerMainPageMapper {
    @Select("select id from goods")
    List<Integer> getAllIds();//获取所有的id值供选择

    List<Good> getGoods(@Param("list") List<Integer> ids);

    @Select("select * from goods where id=#{id}")
    Good getDetail(Integer id);//获取商品详情

    @Insert("insert into buy_Records (buyer_id,good_id,time) values (#{buyerId},#{goodId},#{time})")
    Integer buy(Order order);//购买商品

    @Insert("insert into orders (buyerId, goodId, name, phone, email,time) value (#{buyerId},#{goodId},#{name},#{phone},#{email},#{time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void addOrder(Order order);

    void updateGoodInfo(Integer id,Integer orderId);

    @Select("select * from cart where buyer_id=#{buyerId} and good_id=#{goodId}")
    List<Cart> check(Record record);

    @Insert("insert into cart (buyer_id, good_id) VALUES (#{buyerId},#{goodId})")
    Integer addToCart(Record record);//加入购物车

    @Update("update cart set number = number+1 where good_id=#{goodId} and buyer_id=#{buyerId}")
    Integer addNumber(Record record);//添加数量

    @Update("update cart set number = number-1 where good_id=#{goodId} and buyer_id=#{buyerId}")
    Integer delNumber(Record record);//减少数量

    @Insert("insert into browse_Records (buyer_id, good_id, time) VALUES (#{buyerId},#{goodId},#{time})")
    Integer browse(Record record);//记录浏览信息
}
