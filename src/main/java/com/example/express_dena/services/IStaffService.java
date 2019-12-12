package com.example.express_dena.services;

import com.example.express_dena.pojo.Horseman;

/**
 * @author 王志坚
 * @createTime 2019.12.12.10:31
 */
public interface IStaffService {
    Horseman loadStaffByAccount(String account);
}
