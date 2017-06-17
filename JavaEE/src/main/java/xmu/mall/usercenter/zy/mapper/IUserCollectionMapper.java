package xmu.mall.usercenter.zy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.UserCollection;

@Component
public interface IUserCollectionMapper {
	
	void addCollection(UserCollection uc);

	void deleteCollection(@Param("user_id")long userid, @Param("goods_id")long goodsid);
	
	UserCollection hasCollection(@Param("user_id")long userid, @Param("goods_id")long goodsid); // 是否收藏过该商品
	
	List<UserCollection> getAllCollectionByUserID(long userid);
	
}
