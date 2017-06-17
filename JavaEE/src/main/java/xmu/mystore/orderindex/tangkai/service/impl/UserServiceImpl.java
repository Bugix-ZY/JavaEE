package xmu.mystore.orderindex.tangkai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.orderindex.tangkai.mapper.UserMapper;
import xmu.mystore.orderindex.tangkai.model.User;
import xmu.mystore.orderindex.tangkai.model.UserAddress;
import xmu.mystore.orderindex.tangkai.service.UserService;

/**
 * @author tangkai
 * @data 2017年6月2日--下午4:14:50
 */
@Service("tangkai_UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userMapper;
	
	@Override
	public User getUserByUserId(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserId(user_id);
	}

	@Override
	public void addUserAddress(UserAddress address) {
		// TODO Auto-generated method stub
		userMapper.addUserAddress(address);
	}

	@Override
	public List<UserAddress> getUserAddressesByUserId(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserAddressesByUserId(user_id);
	}

	@Override
	public List<UserAddress> getNotDefaultAddress(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getNotDefaultAddress(user_id);
	}

	@Override
	public UserAddress getDefaultAddress(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getDefaultAddress(user_id);
	}

	@Override
	public UserAddress getAddressById(long address_id) {
		// TODO Auto-generated method stub
		return userMapper.getAddressById(address_id);
	}
	

}
