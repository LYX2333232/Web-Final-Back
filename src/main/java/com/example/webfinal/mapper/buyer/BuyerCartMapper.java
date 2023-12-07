package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BuyerCartMapper {
    @Select("select cart.id as id,cart.buyer_id as buyerId,cart.good_id as goodId,cart.number as number,goods.name as name,goods.image as image,goods.price as price from cart,goods where buyer_id=#{buyerId} and goods.id=cart.good_id")
    List<Cart> getCart(Integer buyerId);

    @Delete("delete from cart where id=#{id}")
    Integer deleteGood(Integer id);

    @Update("update cart set number=#{number} where id=#{id}")
    Integer changeNumber(Integer id,Integer number);
}
