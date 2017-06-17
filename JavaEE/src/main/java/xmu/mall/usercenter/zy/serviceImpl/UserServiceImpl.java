package xmu.mall.usercenter.zy.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zy.mapper.IUserMapper;
import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService
{
	@Autowired
	private IUserMapper userMapper;
	
	public User getUserByID(long id) {
		return this.userMapper.getUserByID(id);
	}
	public User getUserByMobile(String mobile){
		return this.userMapper.getUserByMobile(mobile);
	}
	public User getUserByUsername(String name) {
		return this.userMapper.getUserByUsername(name);
	}
	public void updateUsername(long userid, String username) {
		this.userMapper.updateUsername(userid, username);
	}

}
