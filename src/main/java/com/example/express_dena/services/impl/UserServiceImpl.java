package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.HorsemanMapper;
import com.example.express_dena.mapper.UserMapper;
import com.example.express_dena.mapper.WithdrawalsMapper;
import com.example.express_dena.pojo.*;
import com.example.express_dena.services.CodeCenter;
import com.example.express_dena.services.UserService;
import com.example.express_dena.util.MD5Utils;
import com.example.express_dena.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    HorsemanMapper horsemanMapper;
    @Autowired
    WithdrawalsMapper withdrawalsMapper;
    @Autowired
    CodeCenter codeCenter;


    @Override
    public int insert() {

        User u   = new User();
        u.setUsername("hello");
        u.setAccount("123");
        String password = MD5Utils.StringInMd5("123");
        u.setPassword(password);


        return userMapper.insert(u);
    }

    @Override
    public Map<String, String> register(User user) {

        Map<String,String> res = new HashMap<>();

        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(user.getUsername());
        example.or().andEmailEqualTo(user.getEmail());

        List<User> users = userMapper.selectByExample(example);

        user.setAccount(user.getEmail());
        user.setAvatar("images/avatar.jpg");
        user.setPassword(MD5Utils.StringInMd5(user.getPassword()));
        user.setCreateTime(new Date());

        if(users !=  null && users.size() > 0){
            res.put(StaticPool.ERROR,"用户名已存在，或邮箱已被注册！");
        }else {
            int resId = userMapper.insert(user);
            user.setId(resId);
            res.put(StaticPool.SUCCESS,"success");
        }

        return res;
    }

    @Override
    public Map<String, String> updateUserInfo(User user) {

        Map<String,String> res = new HashMap<>();

        int id = user.getId();
        User user1 = userMapper.selectByPrimaryKey(id);
        user1.setUsername(user.getUsername());
        user1.setPhone(user.getPhone());
        user1.setAvatar(user.getAvatar());


        int ans = userMapper.updateByPrimaryKey(user1);
        if(ans > 0 )
            res.put(StaticPool.SUCCESS,"修改成功！");
        else
            res.put(StaticPool.ERROR,"修改失败！");
        return res;
    }

    @Override
    public Map<String, String> changePassword(int userid,String oldPassword, String newPassword) {
        Map<String,String> res = new HashMap<>();

        User user = userMapper.selectByPrimaryKey(userid);
        if(user == null)
            res.put(StaticPool.ERROR,"修改失败！此用户不存在！");
        else {
            if( user.getPassword().equals(MD5Utils.StringInMd5(oldPassword)) ){
                String password = MD5Utils.StringInMd5(newPassword);
                user.setPassword(password);
                userMapper.updateByPrimaryKey(user);
                res.put(StaticPool.SUCCESS,"修改成功！");
            }else {
                res.put(StaticPool.ERROR,"修改失败！旧密码错误！");
            }
        }
        return res;
    }

    @Override
    public Map<String, String> forgetPassword(String emailCode, String newPassword, String account, String code) {
        Map<String,String> res = new HashMap<>();

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(emailCode);

        List<User> users = userMapper.selectByExample(example);
        if( users == null ){
            res.put(StaticPool.ERROR,"修改失败！该email错误！");
            return res;
        }

        if( users.isEmpty() ){
            res.put(StaticPool.ERROR,"修改失败！该email错误！");
            return res;
        }

        //code 正确 此处为模拟
        if(code.equals(codeCenter.getCode(emailCode))){
            User u = users.get(0);
            String password = MD5Utils.StringInMd5(newPassword);
            u.setPassword(password);
            userMapper.updateByPrimaryKey(u);
            res.put(StaticPool.SUCCESS,"修改成功！");
        }else {
            res.put(StaticPool.ERROR,"修改失败！code错误！");
        }

        return res;
    }

    @Override
    public Map<String, String> applicationStaff(Horseman horseman) {

        Map<String,String> res = new HashMap<>();

        HorsemanExample example = new HorsemanExample();
        HorsemanExample.Criteria criteria = example.createCriteria();
        criteria.andIdCardEqualTo(horseman.getIdCard());


        List<Horseman> horsemens = horsemanMapper.selectByExample(example);

        if( horsemens != null && horsemens.size() > 0){
            res.put(StaticPool.ERROR,"修改失败！该身份证已被注册！");
        }else {
            horseman.setStatus(Byte.valueOf("0"));
            horsemanMapper.insert(horseman);
            res.put(StaticPool.SUCCESS,"申请成功！等待审核！");
        }

        return res;
    }

    /**
     * 充值
     * @param num
     * @return
     */
    @Override
    public Map<String, String> recharge(float num) {
        Map<String,String> res = new HashMap<>();



        return res;
    }

    /**
     * 提现操作
     * @param horsemanId
     * @param payNum
     * @param count
     * @return
     */
    @Override
    public Map<String, String> tixian(int horsemanId,String payNum, String count) {
        Map<String,String> res = new HashMap<>();
        float deCount = Float.valueOf(count);

        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanId);
        if(horseman == null){
            res.put(StaticPool.ERROR,"用户不存在!");
            return res;
        }
        Float balance = horseman.getBalance();
        if(balance < deCount){
            res.put(StaticPool.ERROR,"提现失败，提现金额 大于 余额!");
        }else {
            balance = balance - deCount;
            horseman.setBalance(balance);
            int flag1 = horsemanMapper.updateByPrimaryKey(horseman);
            if(flag1 > 0){
                Withdrawals withdrawals = new Withdrawals();
                withdrawals.setAccounts(horseman.getAccount());
                withdrawals.setHorsemanid(horsemanId);
                withdrawals.setType(2);
                withdrawals.setWithdrawalsBalance(deCount);
                int flag2 = withdrawalsMapper.insert(withdrawals);
                if(flag2 > 0){
                    res.put(StaticPool.SUCCESS,"申请成功提现成功！");
                }else {
                    res.put(StaticPool.ERROR,"提现失败，提现金额 大于 余额!");
                }
            }else {
                res.put(StaticPool.ERROR,"提现失败，提现金额 大于 余额!");
            }
        }
        return res;
    }

    /**
     * 评价 订单xxx
     * @param content
     * @param orderid
     * @return
     */
    @Override
    public Map<String, String> feedBack(String content, int orderid) {
        Map<String,String> res = new HashMap<>();
        return res;
    }

    @Override
    public Map<String, String> selectByIdAndName(String password, String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPasswordEqualTo(password);

        List<User> users = userMapper.selectByExample(example);

        System.out.println("users = " + users);

        return new HashMap<>();
    }

    @Override
    public User selectByUserName(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(userName);

        List<User> users = userMapper.selectByExample(example);
        if(users == null)
            return null;
        else if(users.isEmpty())
            return null;
        else
            return users.get(0);
    }

    @Override
    public User selectByUserId(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }


}
