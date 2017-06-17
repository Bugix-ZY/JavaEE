package xmu.mystore.orderindex.tangkai.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mall.goodsindex.zjh.service.IShoppingCartService;
import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.model.UserAddress;
import xmu.mall.usercenter.zy.service.IUserAddressService;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;
import xmu.mystore.ordersmgt.zy.model.Order;
import xmu.mystore.ordersmgt.zy.model.OrderGoods;
import xmu.mystore.ordersmgt.zy.service.IOrderGoodsService;
import xmu.mystore.ordersmgt.zy.service.IOrderService;

/**
 * @author tangkai
 * @data 2017年6月2日--下午4:17:11
 */
@Controller
@RequestMapping(value="/cart/")
public class CartController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderGoodsService orderGoodsService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserAddressService userAddressService;

	@Autowired
	@Qualifier("ShoppingCartService")
	private IShoppingCartService shoppingCartService;

	
	@Autowired
	private GoodsService goodService;
	
	@Autowired
	private GoodsMgtService goodsMgtService;
	
	
	/**
	 * 处理订单页面
	 * @param goodsId
	 * @param goodsNumber
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String turnToOrderPage(
			String[]goodsId,
			String[]goodsNumber,
			Model model, HttpSession session)
	{

		Long user_id=Long.valueOf(session.getAttribute("userId").toString());

		
		Order order = new Order();
		String sn = orderService.createOrder_sn();
        order.setOrder_sn(sn); 
			
		User user = userService.getUserByID(user_id);
		UserAddress address = userAddressService.getDefaultAddress(user_id);
		order.setConsignee(address.getConsignee());
		order.setIsUrgency("N");
		order.setZipcode(address.getZipcode());
		order.setOrder_status(0);
		order.setAddress(address.getDetail());
		order.setTelephone(address.getTelephone());
		order.setUser_id(user_id);
		order.setTotal_weight(0);
		order.setOrder_price(0);
		order.setRemark("");
		order.setAdd_time(System.currentTimeMillis());
		orderService.addOrder(order);
		
		order = orderService.getOrderBySN(sn);
		double total_weight = 0;
		
		double order_price = 0;
		
		List<OrderGoods> orderGoodsList=new ArrayList<OrderGoods>();
		if(goodsId.length==goodsNumber.length)
		{
			for(int i=0;i<goodsId.length;++i)
			{
				OrderGoods orderGoods=new OrderGoods();
				Goods tmp = new Goods();
				tmp.setId(Long.parseLong(goodsId[i]));
				Goods goods = (Goods) goodService.getAGoods(tmp);
				orderGoods.setOrder_id(order.getOrder_id());
				orderGoods.setGoods_id(Long.parseLong(goodsId[i]));
				orderGoods.setGoods_name(goods.getName());
				orderGoods.setGoods_price(goods.getReal_price());
				orderGoods.setGoods_number(Integer.parseInt(goodsNumber[i]));
				total_weight += goods.getWeight() * Integer.parseInt(goodsNumber[i]);
				order_price += goods.getReal_price() * Integer.parseInt(goodsNumber[i]);
				orderGoodsService.addOrderGoods(orderGoods);
				goodsMgtService.deleteGoodsNumById(Long.parseLong(goodsId[i]), Integer.parseInt(goodsNumber[i]));
				shoppingCartService.deleteByUserIdAndGoodsId(user_id, Long.parseLong(goodsId[i]));
				orderGoodsList.add(orderGoods);
			}
		}
		
		order.setTotal_weight(total_weight);
		order.setOrder_price(order_price);
		orderService.updateOrder(order);
		
		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", orderGoodsList);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
	}

	
	@RequestMapping("addOrder")
	public String addOrder(Model model, HttpServletRequest request)
	{
		long address_id = Long.parseLong(request.getParameter("address_id"));
		long order_id = Long.parseLong(request.getParameter("order_id"));
		long user_id = Long.parseLong(request.getParameter("user_id"));
		Order order = orderService.getOrderByID(order_id);
	
		List<OrderGoods> goods = orderGoodsService.getOrderGoodsByOrderId(order_id);
		
		order.setOrder_status(1);
		order.setPay_time(System.currentTimeMillis());
		orderService.updateOrder(order);
		
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", userService.getUserByID(user_id));
	    return "tangkai/lookupOrder";
	}
//	@RequestMapping("chooseAddress")
//	public String chooseAddress(Model model, HttpServletRequest request)
//	{
//		long user_id = Long.parseLong(request.getParameter("user_id"));
//		List<UserAddress> addresses = userService.getNotDefaultAddress(user_id);
//		UserAddress defaultAddress = userService.getDefaultAddress(user_id);
//		model.addAttribute("defaultAddress", defaultAddress);
//		model.addAttribute("user_id", user_id);
//		model.addAttribute("userAddresses", addresses);
//		return "tangkai/deliveryAddress";
//	}
//	
//	@RequestMapping("newAddress")
//	public String newAddress(Model model, HttpServletRequest request)
//	{
//		long user_id = Long.parseLong(request.getParameter("user_id"));
//		List<UserAddress> addresses = userService.getUserAddressesByUserId(user_id);
//		model.addAttribute("userAddresses", addresses);
//		model.addAttribute("user_id", user_id);
//		return "tangkai/newAddress";
//	}
//	
//	@RequestMapping("getAddress")
//	public String getAddress(Model model, HttpServletRequest request)
//	{
//		long user_id = Long.parseLong(request.getParameter("user_id"));
//		long address_id = Long.parseLong(request.getParameter("address_id"));
//		
//		List<Order> orders = orderService.getShoppingCart(user_id);			
//		if(orders.size() == 0)
//			return "test";		
//		Order order = orders.get(0);		
//		User user = userService.getUserByUserId(user_id);		
//		List<OrderGoods> goodslist = orderGoodsService.getAllOrdersByOrderId(order.getOrder_id());
//		
//		UserAddress address = userService.getAddressById(address_id);
//
//		model.addAttribute("userAddress", address);
//		model.addAttribute("goodslist", goodslist);
//		model.addAttribute("order", order);
//		
//		model.addAttribute("user", user);
//		return "tangkai/balance";
//	}
//	
//	@RequestMapping("addNewAddress")
//	public String addNewAddress(Model model, HttpServletRequest request)
//	{
//		long user_id = Long.parseLong(request.getParameter("user_id"));
//		String consignee = request.getParameter("consignee");
//		String telephone = request.getParameter("telephone");
//		String zipcode = request.getParameter("zipcode");
//		String detail = request.getParameter("detail");
//		UserAddress address = new UserAddress();
//		address.setUser_id(user_id);
//		address.setZipcode(zipcode);
//		address.setConsignee(consignee);
//		address.setDetail(detail);
//		address.setTelephone(telephone);
//		
//		userService.addUserAddress(address);
//		
//		List<UserAddress> addresses = userService.getNotDefaultAddress(user_id);
//		
//		address = addresses.get(addresses.size() - 1);
//		
//		List<Order> orders = orderService.getShoppingCart(user_id);			
//		if(orders.size() == 0)
//			return "test";		
//		Order order = orders.get(0);		
//		User user = userService.getUserByUserId(user_id);		
//		List<OrderGoods> goodslist = orderGoodsService.getAllOrdersByOrderId(order.getOrder_id());
//
//		model.addAttribute("userAddress", address);
//		model.addAttribute("goodslist", goodslist);
//		model.addAttribute("order", order);
//		
//		model.addAttribute("user", user);
//		return "tangkai/balance";
//		
//	}
}
