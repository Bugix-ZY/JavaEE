package xmu.mall.usercenter.zy.mappers;

import java.util.List;

import xmu.mall.usercenter.zy.model.Region;
import xmu.mall.usercenter.zy.model.UserAddress;

public interface IUserAddressMapper {
	List<UserAddress> getAddressByID(long userid);
	void deleteAddress(long addressid);
	void updateAddress(UserAddress address);
	void addAddress(UserAddress address);
}
