package xmu.mall.usercenter.zy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.UserAddress;

@Component
public interface IUserAddressMapper {
	
	List<UserAddress> getAddressByID(long userid);
	
	void deleteAddress(long addressid);
	
	void updateAddress(UserAddress address);
	
	void addAddress(UserAddress address);
	
	void setDefaultAddress(@Param("user_id")long userid, @Param("address_id") long addressid);
	
	UserAddress getDefaultAddress(long user_id);
	
	List<UserAddress> getUserAddressesByUserId(long user_id);
}
