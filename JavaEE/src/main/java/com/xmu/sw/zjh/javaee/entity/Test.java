package com.xmu.sw.zjh.javaee.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.xmu.sw.zjh.javaee.service.IUserService;

public class Test {
	@Autowired
	@Qualifier("userService")
	IUserService us ;
	
	public void test(){
		User user = us.getUser(2550);
		System.out.println(user);
	}
}
