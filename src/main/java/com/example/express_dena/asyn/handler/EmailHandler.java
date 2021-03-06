package com.example.express_dena.asyn.handler;

import com.example.express_dena.asyn.Event;
import com.example.express_dena.asyn.EventHandler;
import com.example.express_dena.asyn.EventType;
import com.example.express_dena.services.CodeCenter;
import com.example.express_dena.services.ISendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class EmailHandler implements EventHandler {
    @Autowired
    ISendMail sendMail;

    @Autowired
    CodeCenter codeCenter;

    @Override
    public void doHandler(Event event) {
        Map map = new HashMap<>();
        //key 是标记 是什么类型的 空 默认是 注册的验证码
        //其余的 要你们 自己 加
        String key = event.mapGet("key");
        if( key == null ){
            String mail = event.mapGet("mail");
            if(mail == null)
                return;
            String code = codeCenter.genCode(mail);
            map.put("code",code);
            sendMail.sendHtmlMail("获取验证码","registerTemp",map,mail);
        }else if ( key.equals("sendaccount")){
            String mail = event.mapGet("mail");
            map.put("account",event.mapGet("account"));
            map.put("password",event.mapGet("password"));
            sendMail.sendHtmlMail("恭喜注册成为骑手！","sendAccountTemp",map,mail);
        }else if (key.equals("checkfail")){
            String mail = event.mapGet("mail");
            sendMail.sendHtmlMail("对不起申请失败！","checkfailTemp",map,mail);
        }else if(key.equals("findBack")){
            String mail = event.mapGet("mail");
            if(mail == null)
                return;
            String code = codeCenter.genCode(mail);
            map.put("code",code);
            sendMail.sendHtmlMail("获取验证码","findBackTemp",map,mail);
        }

    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.SEND_MAIL);
    }
}
