package com.wpx.shop_user;

import com.wpx.shop_user.domain.UserInfo;
import com.wpx.shop_user.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopUserApplicationTests {
	@Autowired
	UserInfoService userInfoService;
	@Test
	public void contextLoads() {
	}
	@Test
	public void reg(){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("wpx");
		userInfo.setUserPwd("1");
		try {
			userInfoService.reg(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void login(){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserNo("wpx");
		userInfo.setUserPwd("1");
		try {
			UserInfo login = userInfoService.login(userInfo);
			System.out.println(login);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
