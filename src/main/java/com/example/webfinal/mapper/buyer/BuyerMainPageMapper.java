package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Good;
import com.example.webfinal.pojo.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyerMainPageMapper {
    @Select("select id from goods")
    List<Integer> getAllIds();//获取所有的id值供选择
    List<Good> getGoods(List<Integer> ids);

    @Select("select * from goods where id=#{id}")
    Good getDetail(Integer id);//获取商品详情

    @Insert("insert into buy_Records (buyer_id,good_id,time) values (#{buyerId},#{goodId},#{time})")
    Integer buy(Record record);//购买商品

    @Insert("insert into cart (buyer_id, good_id) VALUES (#{buyerId},#{goodId})")
    Integer addToCart(Record record);//加入购物车

    @Insert("insert into browse_Records (buyer_id, good_id, time) VALUES (#{buyerId},#{goodId},#{time})")
    Integer browse(Record record);//记录浏览信息
}
