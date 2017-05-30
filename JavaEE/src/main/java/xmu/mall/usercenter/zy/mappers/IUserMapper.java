package xmu.mall.usercenter.zy.mappers;

import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.User;

@Component
public interface IUserMapper {
	User getUserByID(long id);
	User getUserByMobile(String mobile);
	User getUserByUsername(String name);
}
