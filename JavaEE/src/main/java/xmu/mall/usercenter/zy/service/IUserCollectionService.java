package xmu.mall.usercenter.zy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mall.usercenter.zy.model.UserCollection;

@Component
public interface IUserCollectionService {
	public void addCollection(long userid, long goodsid);
	public void deleteCollection(@Param("user_id")long userid, @Param("goods_id")long goodsid);
	public UserCollection hasCollection(@Param("user_id")long userid, @Param("goods_id")long goodsid); // 是否收藏过该商品
	public List<UserCollection> getAllCollectionByUserID(long userid);
}
