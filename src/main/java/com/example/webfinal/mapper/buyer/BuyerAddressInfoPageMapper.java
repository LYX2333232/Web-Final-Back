package com.example.webfinal.mapper.buyer;

import com.example.webfinal.pojo.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuyerAddressInfoPageMapper {
    @Select("select * from address where id=#{id}")
    List<Address> getAddressInfo(Integer id);

    @Insert("insert into address (buyer_id, name, phone, address) VALUES (#{buyerId},#{name},#{phone},#{address})")
    Integer newAddress(Address a);

    @Update("update address set name=#{name},phone=#{phone},address=#{address} where id=#{id}")
    Integer updateAddress(Address a);

    @Delete("delete from address where id=#{id}")
    Integer deleteAddress(Integer id);
}
