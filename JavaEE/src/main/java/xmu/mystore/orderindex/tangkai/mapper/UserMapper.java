package xmu.mystore.orderindex.tangkai.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.mystore.orderindex.tangkai.model.User;
import xmu.mystore.orderindex.tangkai.model.UserAddress;

/**
 * @author tangkai
 * @data 2017年6月2日--下午4:17:17
 */
@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
	public void addUserAddress(UserAddress address);
	
	public List<UserAddress> getUserAddressesByUserId(long user_id);
	
	public List<UserAddress> getNotDefaultAddress(long user_id);
	
	public UserAddress getDefaultAddress(long user_id);
	
	public UserAddress getAddressById(long address_id);
	
}
