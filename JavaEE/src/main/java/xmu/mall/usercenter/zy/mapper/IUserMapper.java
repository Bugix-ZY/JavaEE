package xmu.mall.usercenter.zy.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.User;

@Component
public interface IUserMapper {
	User getUserByID(long id);
	User getUserByMobile(String mobile);
	User getUserByUsername(String name);
	void updateUsername(@Param("user_id")long userid, @Param("user_name")String username);
}
