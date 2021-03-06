package com.example.express_dena.services.impl;

import com.example.express_dena.asyn.Event;
import com.example.express_dena.asyn.EventProductor;
import com.example.express_dena.asyn.EventType;
import com.example.express_dena.mapper.*;
import com.example.express_dena.pojo.*;
import com.example.express_dena.services.AdminService;
import com.example.express_dena.util.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    HorsemanMapper horsemanMapper;
    @Autowired
    EventProductor eventProductor;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    WithdrawalsMapper withdrawalsMapper;
    @Autowired
    MessageMapper messageMapper;

    /**
     * 查询启用用户
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectUsers(Integer indexpage,String serchname) {

        if (indexpage == null){
            indexpage = 1;
        }

        UserExample example = new UserExample();
        if (serchname != null&&!serchname.equals("")&&!serchname.equals("null")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) 1);
        }else {
            example.or().andStatusEqualTo((byte) 1);
        }

        PageHelper.startPage(indexpage,10);
        List<User> users = userMapper.selectByExample(example);
        PageInfo info = new PageInfo(users,5);
        return info;
    }

    /**
     * 查询冻结用户
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectUsersStop(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 1;
        }

        UserExample example = new UserExample();
        if (serchname != null&&!serchname.equals("")&&!serchname.equals("null")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) -1);
        }else {
            example.or().andStatusEqualTo((byte) -1);
        }

        PageHelper.startPage(indexpage,10);
        List<User> users = userMapper.selectByExample(example);
        PageInfo info = new PageInfo(users,5);
        return info;
    }

    /**
     * 冻结用户
     * @param userid
     * @return
     */
    @Override
    public boolean updateUserForzen(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        user.setStatus((byte) -1);
        return userMapper.updateByPrimaryKey(user)>0;
    }

    /**
     * 启用用户
     * @param userid
     * @return
     */
    @Override
    public boolean updateUserStart(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        user.setStatus((byte) 1);
        return userMapper.updateByPrimaryKey(user)>0;
    }

    /**
     * 查询启用骑手
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectHorseman(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 1;
        }

        HorsemanExample example = new HorsemanExample();
        if (serchname != null&&!serchname.equals("")&&!serchname.equals("null")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) 1);
        }else {
            example.or().andStatusEqualTo((byte) 1);
        }

        PageHelper.startPage(indexpage,10);
        List<Horseman> horsemen = horsemanMapper.selectByExample(example);
        PageInfo info = new PageInfo(horsemen,5);
        return info;
    }

    /**
     * 查询停用骑手
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectHorsemanStop(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 1;
        }

        HorsemanExample example = new HorsemanExample();
        if (serchname != null&&!serchname.equals("")&&!serchname.equals("null")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) -1);
        }else {
            example.or().andStatusEqualTo((byte) -1);
        }

        PageHelper.startPage(indexpage,10);
        List<Horseman> horsemen = horsemanMapper.selectByExample(example);
        PageInfo info = new PageInfo(horsemen,5);
        return info;
    }

    /**
     * 停用骑手
     * @param horsemanid
     * @return
     */
    @Override
    public boolean updateHorsemanForzen(Integer horsemanid) {
        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanid);
        horseman.setStatus((byte) -1);
        return horsemanMapper.updateByPrimaryKey(horseman)>0;
    }

    /**
     * 启用骑手(重新将审核状态变为待审核0)
     * @param horsemanid
     * @return
     */
    @Override
    public boolean updateHorsemanStart(Integer horsemanid) {
        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanid);
        horseman.setStatus((byte) 0);
        return horsemanMapper.updateByPrimaryKey(horseman)>0;
    }

    /**
     * 根据邮箱，电话，或者用户名查询所有待审核骑手（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectAllHorseman(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 1;
        }

        HorsemanExample example = new HorsemanExample();
        if (serchname != null&&!serchname.equals("")&&!serchname.equals("null")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) 0);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) 0);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) 0);
        }else {
            example.or().andStatusEqualTo((byte) 0);
        }

        PageHelper.startPage(indexpage,10);
        List<Horseman> horsemen = horsemanMapper.selectByExample(example);
        PageInfo info = new PageInfo(horsemen,5);
        return info;
    }

    @Override
    public boolean updateChecked_apply(Integer horsemanid, Byte status) {
        HorsemanExample horsemanExample = new HorsemanExample();
        String account;
        String password;
        String md5Password = null;
        //按id找到申请的记录
        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanid);
        if (status.equals(-1)||status==-1){
            horseman.setStatus(status);
            Event e = new Event();
            e.setEventType(EventType.SEND_MAIL);
            e.mapSet("key","checkfail");
            e.mapSet("mail",horseman.getEmail());
            eventProductor.pushEvent(e);
        }else if (status.equals(1)||status==1){

            do {
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //生成账号
                account =uuid.substring(0,8);
                //生成密码
                password = uuid.substring(10,18);
                md5Password=MD5Utils.StringInMd5(password);
                horsemanExample.createCriteria().andAccountEqualTo(account);
                //查询一次如果账号存在则重新生成
            }while ( !horsemanMapper.selectByExample(horsemanExample).isEmpty());
            //将账号密码设入
            horseman.setAccount(account);
            horseman.setPassword(md5Password);
            horseman.setStatus(status);
            horseman.setBalance(0.0f);
            horseman.setCreateTime(new Date());
            Event event = new Event();
            event.setEventType(EventType.SEND_MAIL);
            event.mapSet("key","sendaccount");
            event.mapSet("mail",horseman.getEmail());
            event.mapSet("account",account);
            event.mapSet("password",password);
            eventProductor.pushEvent(event);
        }
        return horsemanMapper.updateByPrimaryKey(horseman)>0;
    }

    /**
     * 根据订单id，骑手id，或者用户id查询有效评论（serchid为空则查全部）
     * @param indexpage
     * @param serchid
     * @return
     */
    @Override
    public PageInfo selectComment(Integer indexpage, Integer serchid) {
        if (indexpage == null){
            indexpage = 1;
        }

        CommentExample example = new CommentExample();
        if (serchid != null&&!serchid.equals(0)&&!serchid.equals("null")){
            example.or().andUserIdEqualTo(serchid).andStatusEqualTo((byte) 1);
            example.or().andIdEqualTo(serchid).andStatusEqualTo((byte) 1);
            example.or().andOrderIdEqualTo(serchid).andStatusEqualTo((byte) 1);
            example.or().andHorsemanIdEqualTo(serchid).andStatusEqualTo((byte) 1);
        }else {
            example.or().andStatusEqualTo((byte) 1);
        }
        PageHelper.startPage(indexpage,10);
        List<Comment> comments = commentMapper.selectByExample(example);
        PageInfo info = new PageInfo(comments,5);
        return info;
    }

    /**
     * 根据订单id，骑手id，或者用户id查询有效评论（serchid为空则查全部）
     * @param indexpage
     * @param serchid
     * @return
     */
    @Override
    public PageInfo selectCommentStop(Integer indexpage, Integer serchid) {
        if (indexpage == null){
            indexpage = 1;
        }

        CommentExample example = new CommentExample();
        if (serchid != null&&!serchid.equals(0)&&!serchid.equals("null")){
            example.or().andUserIdEqualTo(serchid).andStatusEqualTo((byte)0);
            example.or().andIdEqualTo(serchid).andStatusEqualTo((byte)0);
            example.or().andOrderIdEqualTo(serchid).andStatusEqualTo((byte)0);
            example.or().andHorsemanIdEqualTo(serchid).andStatusEqualTo((byte)0);
        }else {
            example.or().andStatusEqualTo((byte) 0);
        }
        PageHelper.startPage(indexpage,10);
        List<Comment> comments = commentMapper.selectByExample(example);
        PageInfo info = new PageInfo(comments,5);
        return info;
    }

    /**
     * 禁用评论
     * @param commentid
     * @return
     */
    @Override
    public boolean updateCommentForzen(Integer commentid) {
        Comment comment = commentMapper.selectByPrimaryKey(commentid);
        comment.setStatus((byte) 0);
        return commentMapper.updateByPrimaryKey(comment)>0;
    }

    /**
     * 启用评论
     * @param commentid
     * @return
     */
    @Override
    public boolean updateCommentStart(Integer commentid) {
        Comment comment = commentMapper.selectByPrimaryKey(commentid);
        comment.setStatus((byte) 1);
        return commentMapper.updateByPrimaryKey(comment)>0;
    }

    /**
     * 通过评论id查询详细评论内容
     * @param commentid
     * @return
     */
    @Override
    public Comment selectCommentbyid(Integer commentid) {
        return commentMapper.selectByPrimaryKey(commentid);
    }

    @Override
    public PageInfo selectDrawmoney(Integer indexpage, Integer status, Integer serchid) {
        if (indexpage == null){
            indexpage = 1;
        }

        WithdrawalsExample example = new WithdrawalsExample();
        if (serchid != null&&!serchid.equals(0)&&!serchid.equals("null")){
           example.or().andHorsemanidEqualTo(serchid).andTypeEqualTo(status);
           Float serchidf=Float.parseFloat(serchid.toString());
           example.or().andWithdrawalsBalanceEqualTo(serchidf).andTypeEqualTo(status);
        }else {
            example.or().andTypeEqualTo(status);
        }
        PageHelper.startPage(indexpage,10);
        List<Withdrawals> withdrawals = withdrawalsMapper.selectByExample(example);
        PageInfo info = new PageInfo(withdrawals,5);
        return info;
    }

    /**
     * 处理提现申请并且发送消息提醒
     * @param id
     * @return
     */
    @Override
    public boolean updateDrawmoney(Integer id,Float withdrawalsBalance) {
        Withdrawals withdrawals = withdrawalsMapper.selectByPrimaryKey(id);
        withdrawals.setType(1);
        Message message = new Message();
        message.setReceiverid(id);
        message.setStatus(1);
        message.setReceiverType(2);
        message.setSendTime(new Date(System.currentTimeMillis()));
        message.setContent("恭喜您的提现申请成功！您的提现金额"+withdrawalsBalance+"会在5分钟之内到账，请注意查收！");
        messageMapper.insert(message);
        return withdrawalsMapper.updateByPrimaryKey(withdrawals)>0;
    }

    /**
     * 根据用户类型和ID查找消息列表
     * @param indexpage
     * @param receiver_type
     * @param serchid
     * @return
     */
    @Override
    public PageInfo selectMessaage(Integer indexpage, Integer receiver_type, Integer serchid) {
        if (indexpage == null){
            indexpage = 1;
        }

        MessageExample example = new MessageExample();
        if (serchid != null&&!serchid.equals(0)&&!serchid.equals("null")){
            example.or().andReceiveridEqualTo(serchid).andReceiverTypeEqualTo(receiver_type);
        }else {
            example.or().andReceiverTypeEqualTo(receiver_type);
        }
        PageHelper.startPage(indexpage,10);
        List<Message> messages = messageMapper.selectByExample(example);
        PageInfo info = new PageInfo(messages,5);
        return info;
    }

    @Override
    public Admin loadByAccount(String account) {
        AdminExample example = new AdminExample();
        example.createCriteria().andAccountEqualTo(account);

        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins == null)
            return null;
        else if(admins.isEmpty())
            return null;
        else
            return admins.get(0);
    }

}
