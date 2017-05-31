package xmu.mall.usercenter.zy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zy.mappers.IUserAddressMapper;
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

}
