package com.wpx.shop_user.service.impl;

import com.wpx.shop_user.dao.UserInfoDao;
import com.wpx.shop_user.domain.UserInfo;
import com.wpx.shop_user.service.UserInfoService;
import com.wpx.shop_user.util.MD5;
import com.wpx.shop_user.util.RandomStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo reg(UserInfo userInfo)throws Exception {
        MD5 md5 = new MD5(userInfo.getUserPwd());
        //设置加密密码
        userInfo.setUserPwd(md5.get32());
        //设置注册日期
        userInfo.setBurnDate(new Date());
        //设置用户ID
        userInfo.setUserNo(RandomStr.getRandomStr());
        //保存
        return userInfoDao.save(userInfo);
    }

    /**
     * 要求用户自行提供用户编号便可以辽
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo login(UserInfo userInfo)throws Exception {
        //判空
        if (userInfo != null) {
            MD5 md5 = new MD5(userInfo.getUserPwd());
            //通过用户名或者密码进行
            UserInfo byUserNameOrUserNo = userInfoDao.findByUserNameOrUserNo(userInfo.getUserNo(),userInfo.getUserNo());
            //如果密码一致
            if (byUserNameOrUserNo.getUserPwd().equals(md5.get32())) {
                //返回用户信息
                return byUserNameOrUserNo;
            }else{
                return null;
            }
        }
        return null;
    }
}
