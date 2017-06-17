package xmu.mall.usercenter.zy.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.goodsindex.zjh.constant.RenderAjaxReturnResult;
import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.usercenter.zy.mapper.IUserCollectionMapper;
import xmu.mall.usercenter.zy.mapper.IUserMapper;
import xmu.mall.usercenter.zy.model.UserCollection;
import xmu.mall.usercenter.zy.service.IUserCollectionService;

@Service("userCollectionService")
@Transactional
public class UserCollectionImpl implements IUserCollectionService {
	
	@Autowired
	private IUserCollectionMapper uCMapper;
	
	public void addCollection(long userid, long goodsid) {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String addtime = sdFormatter.format(nowTime);
		System.out.println(addtime);
		UserCollection uc = new UserCollection();
		uc.setUser_id(userid);
		uc.setGoods_id(goodsid);
		uc.setAdd_time(addtime);
		this.uCMapper.addCollection(uc);
	}
	
	public void deleteCollection(long userid, long goodsid) {
		this.uCMapper.deleteCollection(userid, goodsid);
	}

	public UserCollection hasCollection(long userid, long goodsid) {
		return this.uCMapper.hasCollection(userid, goodsid);
	}

	public List<UserCollection> getAllCollectionByUserID(long userid) {
		return this.uCMapper.getAllCollectionByUserID(userid);
	}

}
