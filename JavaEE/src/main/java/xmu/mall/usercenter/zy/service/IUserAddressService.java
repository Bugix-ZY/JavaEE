package xmu.mall.usercenter.zy.service;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.Region;
import xmu.mall.usercenter.zy.model.UserAddress;

@Component
public interface IUserAddressService {
	public List<UserAddress> getAddressByID(long userid);
	public void deleteAddress(long addressid);
	public void updateAddress(UserAddress address);
	public void addAddress(UserAddress address);
}
