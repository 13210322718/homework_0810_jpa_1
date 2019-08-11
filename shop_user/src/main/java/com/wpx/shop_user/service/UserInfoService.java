package com.wpx.shop_user.service;


import com.wpx.shop_user.domain.UserInfo;

public interface UserInfoService {
    UserInfo reg(UserInfo userInfo)throws Exception;
    UserInfo login(UserInfo userInfo)throws Exception;
}
