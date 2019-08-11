package com.wpx.shop_user.dao;

import com.wpx.shop_user.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

//使用Habnate
public interface UserInfoDao extends JpaRepository<UserInfo, String> {
//    UserInfo findByUserNameOrUserNo(UserInfo userInfo);
    UserInfo findByUserNameOrUserNo(String userName,String userNo);
}
