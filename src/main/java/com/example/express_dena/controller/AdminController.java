package com.example.express_dena.controller;


import com.example.express_dena.mapper.NoticeMapper;
import com.example.express_dena.pojo.Notice;
import com.example.express_dena.pojo.NoticeExample;
import com.example.express_dena.services.impl.AdminServiceimpl;
import com.example.express_dena.pojo.Advertising;
import com.example.express_dena.pojo.Comment;
import com.example.express_dena.services.impl.*;
import com.example.express_dena.util.StaticPool;
import com.example.express_dena.pojo.Address;
import com.github.pagehelper.PageInfo;
import com.example.express_dena.services.impl.AdminServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ManagerOrderServiceImpl orderService;

    @Autowired
    ManagerAddressServiceimpl addressServiceimpl;

    @Autowired
    AdminServiceimpl adminServiceimpl;
    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    ManagerAdvertsingServiceImpl advertsingService;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("type", StaticPool.ADMIN);
        return "/login";
    }
    @RequestMapping("404error")
    public String error404(){
        return "/admin/404";
    }

    @RequestMapping("_header")
    public String _header(){
        return "/admin/_header";
    }
    
    
    @RequestMapping("admin_add")
    public String admin_add(){
        return "/admin/admin-add";
    }

    @RequestMapping("admin_list")
    public String admin_list(){
        return "/admin/admin-list";
    }

    @RequestMapping("admin_password_edit")
    public String admin_password_edit(){
        return "/admin/admin-password-edit";
    }

    @RequestMapping("admin_permission")
    public String admin_permission(){
        return "/admin/admin-permission";
    }

    @RequestMapping("admin_role")
    public String admin_role(){
        return "/admin/admin-role";
    }

    @RequestMapping("admin_role_add")
    public String admin_role_add(){
        return "/admin/admin-role-add";
    }

    @RequestMapping("change_password")
    public String change_password(){
        return "/admin/change-password";
    }


    @RequestMapping("feedback_list")
    public String feedback_list(){
        return "/admin/feedback-list";
    }

    @RequestMapping("index")
    public String index(){
        return "/admin/index";
    }

    @RequestMapping("member_add")
    public String member_add(){
        return "/admin/member-add";
    }



    @RequestMapping("member_del")
    public String member_del(){
        return "/admin/member-del";
    }


    /**
     * 查询用户(状态为1正在使用的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("member_list")
    public String member_list(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectUsers(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        if (!"null".equals(serchname)){
            request.setAttribute("serchname",serchname);
        }
        return "/admin/member-list";
    }

    /**
     * 查询用户(状态为-1被冻结的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("member_list_stop")
    public String member_list_stop(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectUsersStop(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        if (!"null".equals(serchname)){
            request.setAttribute("serchname",serchname);
        }
        return "/admin/member-del";
    }

    /**
     * 冻结用户
     * @param userid
     * @return
     */
    @RequestMapping("member_list_frozenuser")
    public String member_list_frozenuser(Integer userid){
        adminServiceimpl.updateUserForzen(userid);
        return "redirect:/admin/member_list";
    }

    /**
     * 启用用户
     * @param userid
     * @return
     */
    @RequestMapping("member_list_startuser")
    public String member_list_startuser(Integer userid){
        adminServiceimpl.updateUserStart(userid);
        return "redirect:/admin/member_list_stop";
    }

    /**
     * 查询骑手(状态为1正在使用的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("horseman_list")
    public String horseman_list(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectHorseman(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        if (!"null".equals(serchname)){
            request.setAttribute("serchname",serchname);
        }
        return "/admin/horseman-list";
    }

    /**
     * 查询骑手(状态为-1被冻结的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("horseman_list_stop")
    public String horseman_list_stop(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectHorsemanStop(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        if (!"null".equals(serchname)){
            request.setAttribute("serchname",serchname);
        }
        return "/admin/horseman-del";
    }

    /**
     * 冻结骑手
     * @param horsemanid
     * @return
     */
    @RequestMapping("horseman_list_frozenuser")
    public String horseman_list_frozenuser(Integer horsemanid){
        adminServiceimpl.updateHorsemanForzen(horsemanid);
        return "redirect:/admin/horseman_list";
    }

    /**
     * 启用骑手(重新将审核状态变为待审核0)
     * @param horsemanid
     * @return
     */
    @RequestMapping("horseman_list_startuser")
    public String horseman_list_startuser(Integer horsemanid){
        adminServiceimpl.updateHorsemanStart(horsemanid);
        return "redirect:/admin/horseman_list_stop";
    }

    /**
     * 显示申请骑手待审核列表
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("article_list")
    public String article_list(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectAllHorseman(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        if (!"null".equals(serchname)){
            request.setAttribute("serchname",serchname);
        }

        return "/admin/article-list";
    }

    /**
     * 审核骑手的申请
     * @param horsemanid
     * @param status
     * @return
     */
    @RequestMapping("checked_apply")
    public String checked_apply(Integer horsemanid,Byte status){
        adminServiceimpl.updateChecked_apply(horsemanid,status);
        return "redirect:/admin/article_list";
    }
    /**
     * 批量审核骑手的申请
     * @param horsemanid
     * @param status
     * @return
     */
    @RequestMapping("checked_applymore")
    public String checked_applymore(Integer horsemanid[],Byte status){
        for (int i = 0; i <horsemanid.length ; i++) {
            adminServiceimpl.updateChecked_apply(horsemanid[i],status);
        }
        return "redirect:/admin/article_list";
    }

    /**
     * 放大身份证
     * @param request
     * @param url
     * @return
     */
    @RequestMapping("idcard_show")
    public String idcard_show(HttpServletRequest request,String url){
        request.setAttribute("url",url);
        return "/admin/idcard-show";
    }

    /**
     * 查询启用的评论列表
     * @param request
     * @param indexpage
     * @param serchid
     * @return
     */
    @RequestMapping("comment_list")
    public String comment_list(HttpServletRequest request,Integer indexpage,String serchid){
        Integer serchid1 = null;
        if (serchid!=null&&serchid.matches("^[0-9]*$")&&!serchid.equals("")){
            serchid1 = Integer.valueOf(serchid);
        }
        PageInfo pageInfo = adminServiceimpl.selectComment(indexpage, serchid1);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchid",serchid);
        return "/admin/comment-list";
    }

    /**
     * 查询禁用的评论列表
     * @param request
     * @param indexpage
     * @param serchid
     * @return
     */
    @RequestMapping("comment_list_stop")
    public String comment_list_stop(HttpServletRequest request,Integer indexpage,String serchid){
        Integer serchid1 = null;
        if (serchid!=null&&serchid.matches("^[0-9]*$")&&!serchid.equals("")){
            serchid1 = Integer.valueOf(serchid);
        }
        PageInfo pageInfo = adminServiceimpl.selectCommentStop(indexpage, serchid1);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchid",serchid);
        return "/admin/comment-del";
    }


    /**
     * 弹窗显示评论详情
     * @param request
     * @param commentid
     * @return
     */
    @RequestMapping("comment_show")
    public String comment_show(HttpServletRequest request,Integer commentid){
        Comment comment = adminServiceimpl.selectCommentbyid(commentid);
        request.setAttribute("comment",comment);
        return "/admin/comment-show";
    }

    /**
     * 冻结评论
     * @param commentid
     * @return
     */
    @RequestMapping("comment_list_frozencomment")
    public String comment_list_frozencomment(Integer commentid){
        adminServiceimpl.updateCommentForzen(commentid);
        return "redirect:/admin/comment_list";
    }

    /**
     * 启用评论
     * @param commentid
     * @return
     */
    @RequestMapping("comment_list_startcomment")
    public String comment_list_startcomment(Integer commentid){
        adminServiceimpl.updateCommentStart(commentid);
        return "redirect:/admin/comment_list_stop";
    }

    /**
     * 查询提现申请
     * @param indexpage
     * @param status
     * @param serchid
     * @return
     */
    @RequestMapping("drawmoney_list")
    public String drawmoney_list(HttpServletRequest request,Integer indexpage,Integer status,String serchid){
        Integer serchid1 = null;
        if (serchid!=null&&serchid.matches("^[0-9]*$")&&!serchid.equals("")){
             serchid1 = Integer.valueOf(serchid);
        }
        PageInfo pageInfo = adminServiceimpl.selectDrawmoney(indexpage, status, serchid1);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchid",serchid);
        if (status == 2){
            return "/admin/drawmoney-list";
        }
       return "/admin/drawmoney-ok";
    }


    /**
     * 处理提现申请并且发送消息提醒
     * @param id
     * @return
     */
    @RequestMapping("update_drawmoney")
    public String update_drawmoney(Integer id,Float withdrawalsBalance){
        boolean b = adminServiceimpl.updateDrawmoney(id,withdrawalsBalance);
        return "redirect:/admin/drawmoney_list?status=2";
    }

    /**
     * 批量处理提现申请并且发送消息提醒
     * @param id
     * @return
     */
    @RequestMapping("update_drawmoneymore")
    public String update_drawmoneymore(Integer id[],Float withdrawalsBalance[]){
        for (int i = 0; i <id.length ; i++) {
            adminServiceimpl.updateDrawmoney(id[i],withdrawalsBalance[i]);
        }
        return "redirect:/admin/drawmoney_list?status=2";
    }

    /**
     * 根据用户类型和ID查找消息列表
     * @param request
     * @param indexpage
     * @param receiverType
     * @param serchid
     * @return
     */
    @RequestMapping("message_list")
    public String message_list(HttpServletRequest request,Integer indexpage,Integer receiverType,String serchid){
        Integer serchid1 = null;
        if (serchid!=null&&serchid.matches("^[0-9]*$")&&!serchid.equals("")){
            serchid1 = Integer.valueOf(serchid);
        }
        PageInfo pageInfo = adminServiceimpl.selectMessaage(indexpage, receiverType, serchid1);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchid",serchid);
        if (receiverType == 1){
            return "/admin/messageuser-list";
        }
        return "/admin/messagehorseman-list";
    }


    @RequestMapping("picture_add")
    public String picture_add(){
        return "/admin/picture-add";
    }

    @RequestMapping("notice_add")
    public String notice_add(){
        return "/admin/notice-add";
    }

    @RequestMapping("/update")
    public String updateNotice(Model model,@RequestParam Integer id){
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        Notice notice1 = noticeMapper.selectByPrimaryKey(id);
        model.addAttribute("id",id);
        model.addAttribute("notices",notice1);
        return "/admin/notice-update";
    }

//    @RequestMapping("notice_update")
//    public String notice_add(){
//        return "/admin/notice-add";
//    }

//    @RequestMapping("notice_update")
//    public String notice_update(@RequestParam re){
//        return "/admin/update";
//    }

    @RequestMapping("picture_list")
    public String picture_list(){
        return "forward:/admin/notice/index";
    }

    @RequestMapping("picture_show")
    public String picture_show(){
        return "/admin/picture-show";
    }

    @RequestMapping("record_browse")
    public String record_browse(){
        return "/admin/record-browse";
    }

    @RequestMapping("record_download")
    public String record_download(){
        return "/admin/record-download";
    }

    @RequestMapping("record_share")
    public String record_share(){
        return "/admin/record-share";
    }

    @RequestMapping("user_add")
    public String user_add(){
        return "/admin/user-add";
    }

    @RequestMapping("user_list")
    public String user_list(){
        return "/admin/user-list";
    }

    @RequestMapping("user_password_edit")
    public String user_password_edit(){
        return "/admin/user-password-edit";
    }



    @RequestMapping("user_show")
    public String user_show(){
        return "/admin/user-show";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "/admin/welcome";
    }

    @RequestMapping("address_list")
    public String address_list(Integer indexpage, HttpServletRequest request, String province, String city, String street, String area, Byte status){
        PageInfo info = addressServiceimpl.selectAddress(indexpage,province,city,street,area,status);
        request.setAttribute("province",province);
        request.setAttribute("city",city);
        request.setAttribute("street",street);
        request.setAttribute("area",area);
        request.setAttribute("status",status);
        request.setAttribute("pages",info);
        return "/admin/address-list";
    }

    @RequestMapping("address_list_status")
    public String address_list_status(Integer id, Byte status){
        status = (byte) ((status+1)%2);
        Address address = new Address();
        address.setId(id);
        address.setStatus(status);
        boolean b = addressServiceimpl.update(address);
        if (b = false)
            return "redirect:/admin/address_list?updatestatus=false";
        else
            return "redirect:/admin/address_list?updatestatus=ture";
    }

    @RequestMapping("address_add")
    public String address_add(String result){
        return "/admin/address-add";
    }

    @RequestMapping("address_add_submit")
    public String address_add_submit(String province, String city, String area, String street){
        boolean result = addressServiceimpl.selectExist(province,city, street, area);
        if (result == true) {
            Address address = new Address();
            address.setProvince(province);
            address.setCity(city);
            address.setArea(area);
            address.setStreet(street);
            address.setStatus((byte) 0);
            address.setCreateTime(new Date());
            addressServiceimpl.addAddress(address);
            return "redirect:/admin/address_list";
        } else {
            return "redirect:/admin/address_add?result=flase";
        }
    }

    @RequestMapping("address_update")
    public String address_update(HttpServletRequest request, Integer id,
                                 String province, String city, String area, String street) {
        request.setAttribute("id",id);
        request.setAttribute("province", province);
        request.setAttribute("city", city);
        request.setAttribute("area", area);
        request.setAttribute("street", street);

        return "/admin/address-update";
    }

    @RequestMapping("address_update_submit")
    public String address_update_sumit(Integer id, String newprovince,
                                       String newcity, String newarea, String newstreet) {
        Address address = new Address();
        address.setId(id);
        if (newprovince != null) {
            address.setProvince(newprovince);
        }
        if (newcity != null){
            address.setCity(newcity);
        }
        if (newarea != null) {
            address.setArea(newarea);
        }
        if (newstreet != null) {
            address.setStreet(newstreet);
        }
        addressServiceimpl.updateAddress(address);

        return "redirect:/admin/address_list";
    }

    @RequestMapping("address_delone")
    public String address_delone(Integer id){
        Address address = new Address();
        address.setId(id);
        addressServiceimpl.deleteOne(address);
        return "redirect:/admin/address_list";
    }

    @RequestMapping("address_del")
    public String address_del(Integer[] ids){
        addressServiceimpl.deleteAddress(ids);
        return "redirect:/admin/address_list";
    }

    @RequestMapping("advertsing_list")
    public String advertsing_list(Integer indexpage, HttpServletRequest request,String constituency, String title, Byte status){
        PageInfo info = advertsingService.selectAdversing(indexpage,constituency,title,status);
        request.setAttribute("constituency",constituency);
        request.setAttribute("title",title);
        request.setAttribute("status",status);
        request.setAttribute("pages",info);
        return "/admin/advertsing-list";
    }

    @RequestMapping("advertsing_list_status")
    public String advertsing_list_status(Integer id, Byte status){
        status = (byte) ((status+1)%2);
        Advertising advertsing = new Advertising();
        advertsing.setId(id);
        advertsing.setStatus(status);
        boolean b = advertsingService.updateAdversing(advertsing);
        if (b = false)
            return "redirect:/admin/advertsing_list?updatestatus=false";
        else
            return "redirect:/admin/advertsing_list?updatestatus=ture";
    }

    @RequestMapping("advertsing_add")
    public String advertsing_add(){
        return "/admin/advertsing-add";
    }

    @RequestMapping("advertsing_add_submit")
    public String advertsing_add_sumbit(String constituency, String content, String pic,
                                 String title, String url, String createTime, String endTime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ctime = null;
        Date etime = null;
        try {
            ctime = sdf.parse(createTime);
            etime = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Advertising advertsing = new Advertising();
        advertsing.setConstituency(constituency);
        advertsing.setContent(content);
        advertsing.setCreateTime(ctime);
        advertsing.setEndTime(etime);
        advertsing.setPic(pic);
        advertsing.setStatus((byte) 0);
        advertsing.setTitle(title);
        advertsing.setUrl(url);
        advertsingService.addAdversing(advertsing);

        return "redirect:/admin/advertsing_list";
    }

    @RequestMapping("advertsing_update")
    public String advertsing_update(HttpServletRequest request, Integer id, String createTime, String endTime,
                                    String constituency, String content, String pic, String title, String url) {

        Date ctime = null;
        Date etime = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.US);
        try {
            ctime = sdf1.parse(createTime);
            etime = sdf1.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String timec = sdf2.format(ctime);
        String timee = sdf2.format(etime);

        request.setAttribute("id",id);
        request.setAttribute("constituency", constituency);
        request.setAttribute("content", content);
        request.setAttribute("pic", pic);
        request.setAttribute("createTime",timec);
        request.setAttribute("endTime",timee);
        request.setAttribute("title", title);
        request.setAttribute("url",url);

        return "/admin/advertsing-update";
    }

    @RequestMapping("advertsing_update_submit")
    public String advertsing_update_submit(Integer id, String newcreateTime, String newendTime,
                                    String newconstituency, String newcontent, String newpic, String newtitle, String newurl) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ctime = null;
        Date etime = null;
        try {
            ctime = sdf.parse(newcreateTime);
            etime = sdf.parse(newendTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Advertising advertsing = new Advertising();
        advertsing.setId(id);
        advertsing.setConstituency(newconstituency);
        advertsing.setContent(newcontent);
        advertsing.setPic(newpic);
        advertsing.setTitle(newtitle);
        advertsing.setUrl(newurl);
        advertsing.setCreateTime(ctime);
        advertsing.setCreateTime(etime);
        advertsingService.updateAdversing(advertsing);

        return "redirect:/admin/advertsing_list";
    }


}
