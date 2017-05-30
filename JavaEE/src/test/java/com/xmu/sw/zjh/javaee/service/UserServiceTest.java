package com.xmu.sw.zjh.javaee.service;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mall.usercenter.zy.serviceImpl.UserServiceImpl;
import xmu.mystore.config.zy.MybatisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( classes={MybatisConfig.class, UserServiceImpl.class})
public class UserServiceTest {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@Test
	public void testGetUser() {
		User user = userService.getUserByID(2550);
		assertNotNull("users should not be null", user);
		System.out.println(user.getUser_name());
		System.out.println(user.getMobile_phone());
	}
	
	@Test
	public void testGetUserByMobile() {
		User user = userService.getUserByMobile("15000588578");
		System.out.println(user.getUser_name());
		System.out.println(user.getMobile_phone());
	}
	


}
