package com.xmu.sw.zjh.javaee.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import xmu.mall.usercenter.zy.service.IUserCollectionService;
import xmu.mall.usercenter.zy.serviceImpl.UserCollectionImpl;
import xmu.mystore.config.zy.MybatisConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( classes={MybatisConfig.class,  UserCollectionImpl.class})
public class UserCollectionTest {
	

	@Autowired
	@Qualifier("userCollectionService")
	IUserCollectionService ucs;
	
	@Test
	public void test() {
		ucs.addCollection((long)1,(long)131);
		ucs.deleteCollection(1, 120);
	}
}
