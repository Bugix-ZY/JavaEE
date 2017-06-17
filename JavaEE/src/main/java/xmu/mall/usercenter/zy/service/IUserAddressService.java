package xmu.mall.usercenter.zy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.Region;
import xmu.mall.usercenter.zy.model.UserAddress;

@Component
public interface IUserAddressService {
	public List<UserAddress> getAddressByID(long userid);
	public void deleteAddress(long addressid);
	public void updateAddress(UserAddress address);
	public void addAddress(UserAddress address);
	public void setDefaultAddress(@Param("user_id")long userid,@Param("address_id") long addressid);
	public UserAddress getDefaultAddress(long user_id);
	
}
