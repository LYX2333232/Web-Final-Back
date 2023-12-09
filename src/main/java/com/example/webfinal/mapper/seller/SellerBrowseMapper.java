package com.example.webfinal.mapper.seller;

import com.example.webfinal.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SellerBrowseMapper {
    @Select("select browse_Records.id as id,browse_Records.buyer_id as buyer_id,buyers.username as buyer_name,browse_Records.good_id as good_id,goods.name as good_name,browse_Records.time as time from browse_Records,goods,buyers where goods.seller_id=#{sellerId} and browse_Records.good_id=goods.id and browse_Records.buyer_id=buyers.id")
    List<Record> getBrowse(Integer sellerId);
}
