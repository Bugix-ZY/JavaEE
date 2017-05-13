package com.xmu.sw.zjh.javaee.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmu.sw.zjh.javaee.dao.UserDao;
import com.xmu.sw.zjh.javaee.entity.User;
import com.xmu.sw.zjh.javaee.service.IUserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService
{
	@Autowired
	private UserDao userDao;
	
	public User getUser(int id)
	{
		return this.userDao.getUser(id);
	}

}
