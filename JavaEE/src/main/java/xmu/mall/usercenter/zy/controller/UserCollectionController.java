package xmu.mall.usercenter.zy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mall.usercenter.zy.model.UserCollection;
import xmu.mall.usercenter.zy.service.IUserCollectionService;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
import xmu.mystore.ordersmgt.zy.model.Order;
import xmu.mystore.ordersmgt.zy.model.OrderGoods;

@Controller
@RequestMapping(value="/user/collection")
public class UserCollectionController {
	
	@Autowired
	private IUserCollectionService userCollectionService;
	
	@Autowired
	private GoodsMgtService goodsMgtService;

	/**
	 * 添加收藏
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public void addCollection (
			HttpServletRequest request,
			HttpSession session)
	{
		long  goodsid = Long.valueOf(request.getParameter("goodsId").toString());
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		userCollectionService.addCollection(userid, goodsid);
	}
	
	/**
	 * 删除收藏
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public void deleteCollection (
			HttpServletRequest request,
			HttpSession session)
	{
		long  goodsid = Long.valueOf(request.getParameter("goodsId").toString());
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		userCollectionService.deleteCollection(userid, goodsid);
	}
	
	/**
	 * 显示该用户全部收藏记录
	 */
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String showAllCollection(Model model, HttpSession session)
	{
		Long userid = Long.valueOf(session.getAttribute("userId").toString());
		List<UserCollection> allcollection = userCollectionService.getAllCollectionByUserID(userid);
		List<Goods>  collections = new ArrayList<Goods>(0);
		for (UserCollection coll : allcollection) {
			long goodsid = coll.getGoods_id();
			collections.add(goodsMgtService.getGoodsByGoodsId(goodsid));
		}
		model.addAttribute("collections",collections);  			// list
		return "zy/usercollection";
	}
}
