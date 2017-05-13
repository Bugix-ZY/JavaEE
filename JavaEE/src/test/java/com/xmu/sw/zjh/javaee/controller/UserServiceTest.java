package com.xmu.sw.zjh.javaee.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xmu.sw.zjh.javaee.config.MybatisConfig;
import com.xmu.sw.zjh.javaee.config.WebAppInitializer;
import com.xmu.sw.zjh.javaee.config.WebConfig;
import com.xmu.sw.zjh.javaee.entity.User;
import com.xmu.sw.zjh.javaee.service.IUserService;
import com.xmu.sw.zjh.javaee.serviceimpl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( classes={MybatisConfig.class, UserServiceImpl.class})
public class UserServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void testGetUser() {
		User user = userService.getUser(2550);
		assertNotNull("users should not be null", user);
		System.out.println(user.getUser_name());
		System.out.println(user.getMobile_phone());
	}

}
