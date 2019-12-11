package com.example.express_dena.services;

import com.example.express_dena.pojo.Address;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;

public interface IManagerAddresService {
    /**
     * 查询地址
     * @param province
     * @param city
     * @param street
     * @param area
     * @param createTime
     * @param status
     * @return
     */
   Page selectAddress(String province, String city, String street, String area, Date createTime, Byte status);

    /**
     * 添加新地址
     * @param address
     * @return
     */
   boolean addAddress(Address address);

    /**
     * 批量删除地址
     * @param addressList
     * @return
     */
   boolean deleteAddress(List<Address> addressList);

    /**
     * 批量修改地址状态
     * @param  addressList;
     * @return
     */
   boolean update(List<Address> addressList);
}
