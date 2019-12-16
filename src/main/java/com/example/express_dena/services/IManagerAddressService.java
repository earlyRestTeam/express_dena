package com.example.express_dena.services;

import com.example.express_dena.pojo.Address;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface IManagerAddressService {
    /**
     * 查询地址
     * @param indexpage
     * @param province
     * @param city
     * @param street
     * @param area
     * @param status
     * @return
     */
   PageInfo selectAddress(Integer indexpage, String province, String city, String street, String area, Byte status);

    /**
     * 添加新地址
     * @param address
     * @return
     */
   boolean addAddress(Address address);

    /**
     * 批量删除地址
     * @param ids
     * @return
     */
   boolean deleteAddress(Integer[] ids);

    /**
     * 修改地址状态
     * @param  address;
     * @return
     */
   boolean update(Address address);

    /**
     * 修改地址
     * @param address
     * @return
     */
   boolean updateAddress(Address address);

    /**
     * 删除地址
     * @param address
     * @return
     */
   boolean deleteOne(Address address);

    /**
     * 插入前查询是否已存在该地址
     * @param province
     * @param city
     * @param street
     * @param area
     * @return
     */
   boolean selectExist( String province, String city, String street, String area);
}
