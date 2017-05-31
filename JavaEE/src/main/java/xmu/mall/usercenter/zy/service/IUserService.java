package xmu.mall.usercenter.zy.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.User;

@Component
public interface IUserService {
	public User getUserByID(long id);
	public User getUserByMobile(String mobile);
	public User getUserByUsername(String name);
	public void updateUsername(@Param("user_id")long userid, @Param("user_name")String username);
}
