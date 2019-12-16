package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.AddressMapper;
import com.example.express_dena.pojo.Address;
import com.example.express_dena.pojo.AddressExample;
import com.example.express_dena.services.IManagerAddressService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerAddressServiceimpl implements IManagerAddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public PageInfo selectAddress(Integer indexpage, String province, String city, String street, String area, Byte status) {
        indexpage = indexpage == null ? 1 : indexpage;
        province = province == null ? "" : province;
        city = city == null ? "" : city;
        area = area == null ? "" : area;
        street = street == null ? "" : street;
        status = status == null ? 0 : status;

        AddressExample example = new AddressExample();
        example.or().andProvinceLike(province+'%')
                .andCityLike(city+'%')
                .andAreaLike(area+'%')
                .andStreetLike(street+'%')
                .andStatusEqualTo(status);

        PageHelper.startPage(indexpage,10);
        List<Address> addresses = addressMapper.selectByExample(example);
        PageInfo info = new PageInfo(addresses,5);

        return info;
    }

    @Override
    public boolean addAddress(Address address) {
        return addressMapper.insertSelective(address)>0;
    }

    @Override
    public boolean deleteAddress(Integer[] ids) {
        for (int i=0; i<ids.length; i++){
            Address address = new Address();
            address.setId(ids[i]);
            if (! deleteOne(address)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean update(Address address) {
        int i = addressMapper.updateByPrimaryKeySelective(address);
        return i>0;
    }

    @Override
    public boolean updateAddress(Address address) {
        return addressMapper.updateByPrimaryKeySelective(address)>0;
    }

    @Override
    public boolean deleteOne(Address address) {
        return addressMapper.deleteByPrimaryKey(address.getId())>0;
    }

    @Override
    public boolean selectExist(String province, String city, String street, String area) {
        AddressExample example = new AddressExample();
        example.or().andProvinceEqualTo(province).andCityEqualTo(city).andStreetEqualTo(street).andAreaEqualTo(area);
        List<Address> addressList = addressMapper.selectByExample(example);

        if (addressList != null && addressList.size() > 0){
            return false;
        } else {
            return true;
        }
    }
}
