package xmu.mystore.orderindex.tangkai.service;

import java.util.List;

import xmu.mystore.orderindex.tangkai.model.User;
import xmu.mystore.orderindex.tangkai.model.UserAddress;

/**
 * @author tangkai
 * @data 2017年6月2日--下午4:03:59
 */
public interface UserService {
	public User getUserByUserId(long user_id);
	
	public void addUserAddress(UserAddress address);
	
	public List<UserAddress> getUserAddressesByUserId(long user_id);
	
	public List<UserAddress> getNotDefaultAddress(long user_id);
	
	public UserAddress getDefaultAddress(long user_id);
	
	public UserAddress getAddressById(long address_id);
}
