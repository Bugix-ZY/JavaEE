package xmu.mall.usercenter.zy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zy.mapper.IUserAddressMapper;
import xmu.mall.usercenter.zy.model.Region;
import xmu.mall.usercenter.zy.model.UserAddress;
import xmu.mall.usercenter.zy.service.IUserAddressService;

@Service("userAddressService")
@Transactional
public class UserAddressService implements IUserAddressService {
	
	@Autowired
	private IUserAddressMapper uaMapper;
	
	
	public List<UserAddress> getAddressByID(long userid) {	
		return uaMapper.getAddressByID(userid);
	}

	public void deleteAddress(long addressid) {
		uaMapper.deleteAddress(addressid);
	}

	public void updateAddress(UserAddress address) {
		uaMapper.updateAddress(address);
	}

	public void addAddress(UserAddress address) {
		uaMapper.addAddress(address);
	}

	public void setDefaultAddress(long userid, long addressid) {
		uaMapper.setDefaultAddress(userid, addressid);
	}

	public UserAddress getDefaultAddress(long user_id) {
		return uaMapper.getDefaultAddress(user_id);
	}



}
