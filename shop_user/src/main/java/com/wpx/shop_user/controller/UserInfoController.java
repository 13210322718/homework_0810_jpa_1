package com.wpx.shop_user.controller;

import com.wpx.shop_user.domain.UserInfo;
import com.wpx.shop_user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/login")
    @ResponseBody
    public UserInfo login(UserInfo userInfo, HttpSession session) {
        UserInfo login = null;
        try {
            login = userInfoService.login(userInfo);
            session.setAttribute("userInfo", login);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return login;
        }
    }
    @GetMapping("/reg")
    @ResponseBody
    public Map reg(UserInfo userInfo) {
        Map<String, Object> msg = new HashMap<>();
        try {
            UserInfo reg = userInfoService.reg(userInfo);
            msg.put("userInfo", reg);
            msg.put("code", 200);
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("userInfo", null);
            msg.put("code", 400);
        } finally {
            return msg;
        }
    }
}
