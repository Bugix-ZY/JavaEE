package xmu.mystore.orderindex.tangkai.controller;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.orderindex.tangkai.model.Order;
import xmu.mystore.orderindex.tangkai.model.OrderGoods;
import xmu.mystore.orderindex.tangkai.model.User;
import xmu.mystore.orderindex.tangkai.model.UserAddress;
import xmu.mystore.orderindex.tangkai.service.OrderGoodsService;
import xmu.mystore.orderindex.tangkai.service.OrderService;
import xmu.mystore.orderindex.tangkai.service.UserService;

/**
 * @author tangkai
 * @data 2017年6月2日--下午4:17:11
 */
@Controller
@RequestMapping(value="/cart/")
public class CartController {
	
	@Autowired
	@Qualifier("tangkai_OrderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("tangkai_OrderGoodsService")
	private OrderGoodsService orderGoodsService;
	@Autowired
	@Qualifier("tangkai_UserService")
	private UserService userService;
	
	
	@RequestMapping("addOrder")
	public String addOrder(Model model, HttpServletRequest request)
	{
		long address_id = Long.parseLong(request.getParameter("address_id"));
		long order_id = Long.parseLong(request.getParameter("order_id"));
		long user_id = Long.parseLong(request.getParameter("user_id"));
		Order order = orderService.getOrderByOrderId(order_id);
		List<UserAddress> addresses = userService.getUserAddressesByUserId(user_id);
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		UserAddress address = null;
		for(UserAddress temp:addresses)
		{
			if(temp.getAddress_id() == address_id)
				address = temp;
		}
		if(address != null)
		{
			order.setAddress(address.getDetail());
			order.setConsignee(address.getConsignee());
			order.setTelephone(address.getTelephone());
			order.setZipcode(address.getZipcode());
		}
		
		order.setOrder_status(1);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String t = df.format(d);
		try {
			int pay_time = (int) (df.parse(t).getTime() / 1000);
			
			order.setPay_time(pay_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		orderService.updateOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", userService.getUserByUserId(user_id));
	    return "tangkai/lookupOrder";
	}
	
	@RequestMapping("chooseAddress")
	public String chooseAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		List<UserAddress> addresses = userService.getNotDefaultAddress(user_id);
		UserAddress defaultAddress = userService.getDefaultAddress(user_id);
		model.addAttribute("defaultAddress", defaultAddress);
		model.addAttribute("user_id", user_id);
		model.addAttribute("userAddresses", addresses);
		return "tangkai/deliveryAddress";
	}
	
	@RequestMapping("newAddress")
	public String newAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		List<UserAddress> addresses = userService.getUserAddressesByUserId(user_id);
		model.addAttribute("userAddresses", addresses);
		model.addAttribute("user_id", user_id);
		return "tangkai/newAddress";
	}
	
	@RequestMapping("getAddress")
	public String getAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		long address_id = Long.parseLong(request.getParameter("address_id"));
		
		List<Order> orders = orderService.getShoppingCart(user_id);			
		if(orders.size() == 0)
			return "test";		
		Order order = orders.get(0);		
		User user = userService.getUserByUserId(user_id);		
		List<OrderGoods> goodslist = orderGoodsService.getAllOrdersByOrderId(order.getOrder_id());
		
		UserAddress address = userService.getAddressById(address_id);

		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
	}
	
	@RequestMapping("addNewAddress")
	public String addNewAddress(Model model, HttpServletRequest request)
	{
		long user_id = Long.parseLong(request.getParameter("user_id"));
		String consignee = request.getParameter("consignee");
		String telephone = request.getParameter("telephone");
		String zipcode = request.getParameter("zipcode");
		String detail = request.getParameter("detail");
		UserAddress address = new UserAddress();
		address.setUser_id(user_id);
		address.setZipcode(zipcode);
		address.setConsignee(consignee);
		address.setDetail(detail);
		address.setTelephone(telephone);
		
		userService.addUserAddress(address);
		
		List<UserAddress> addresses = userService.getNotDefaultAddress(user_id);
		
		address = addresses.get(addresses.size() - 1);
		
		List<Order> orders = orderService.getShoppingCart(user_id);			
		if(orders.size() == 0)
			return "test";		
		Order order = orders.get(0);		
		User user = userService.getUserByUserId(user_id);		
		List<OrderGoods> goodslist = orderGoodsService.getAllOrdersByOrderId(order.getOrder_id());

		model.addAttribute("userAddress", address);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		return "tangkai/balance";
		
	}
}
