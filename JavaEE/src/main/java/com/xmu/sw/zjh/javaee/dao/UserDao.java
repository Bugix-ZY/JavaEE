package com.xmu.sw.zjh.javaee.dao;

import org.springframework.stereotype.Component;

import com.xmu.sw.zjh.javaee.entity.User;

@Component
public interface UserDao {
	User getUser(Integer id);
}
