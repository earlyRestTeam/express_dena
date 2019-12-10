package com.example.express_dena.services;

import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.05.20:44
 */
public interface ISendMail {
    boolean sendHtmlMail(String title, String templatePath, Map<String, Object> model, String acceptUser);
}
