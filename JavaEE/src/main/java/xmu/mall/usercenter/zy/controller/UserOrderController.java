package xmu.mall.usercenter.zy.controller;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.goodsmgt.zlt.model.Goods;
import xmu.mystore.goodsmgt.zlt.service.GoodsMgtService;
import xmu.mystore.ordersmgt.zy.model.Order;
import xmu.mystore.ordersmgt.zy.model.OrderGoods;
import xmu.mystore.ordersmgt.zy.service.IOrderGoodsService;
import xmu.mystore.ordersmgt.zy.service.IOrderService;

@Controller
@RequestMapping(value="/user/order")
public class UserOrderController {
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("orderGoodsService")
	private IOrderGoodsService orderGoodsService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("GoodsMgtService")
	private GoodsMgtService goodsMgtService;
	
	
	/* 显示该用户全部订单记录*/
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String showAllOrder(Model model, HttpSession session)
	{
		Long userid=Long.valueOf(session.getAttribute("userId").toString());
		List<Long> orderids = orderService.getOrderIDByUserID(userid);
		List<Order> orders = new ArrayList<Order>(0);
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Long orderid : orderids) {
			Order o = orderService.getOrderByID(orderid);
			og = orderGoodsService.getOrderGoodsByOrderId(orderid);
			ordergoods.put(Long.toString(orderid), og);
			orders.add(o);
		}
		System.out.println("wowo::" + ordergoods.size());
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		return "zy/userallorder";
	}
	
	/* 显示该用户全部 "未付款" 订单记录*/
	@RequestMapping(value="/unpaid", method=RequestMethod.GET)
	public String showAllUnpaidOrder(Model model, HttpSession session)
	{
		Long userid=Long.valueOf(session.getAttribute("userId").toString());
		List<Long> orderids = orderService.getUnpaidOrderIDByUserID(userid);
		List<Order> orders = new ArrayList<Order>(0);
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Long orderid : orderids) {
			Order o = orderService.getOrderByID(orderid);
			og = orderGoodsService.getOrderGoodsByOrderId(orderid);
			ordergoods.put(Long.toString(orderid), og);
			orders.add(o);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		return "zy/userallorder";
	}
	
	/* 显示该用户全部 "待收货" 订单记录*/
	@RequestMapping(value="/wait", method=RequestMethod.GET)
	public String showAllShippingOrder(Model model, HttpSession session)
	{
		Long userid=Long.valueOf(session.getAttribute("userId").toString());
		List<Long> orderids = orderService.getShippingOrderIDByUserID(userid);
		List<Order> orders = new ArrayList<Order>(0);
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Long orderid : orderids) {
			Order o = orderService.getOrderByID(orderid);
			og = orderGoodsService.getOrderGoodsByOrderId(orderid);
			ordergoods.put(Long.toString(orderid), og);
			orders.add(o);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		return "zy/userallorder";
	}
	
	/* 显示该用户全部 "已完成" 订单记录*/
	@RequestMapping(value="/completed", method=RequestMethod.GET)
	public String showAllCompletedOrder(Model model, HttpSession session)
	{
		Long userid=Long.valueOf(session.getAttribute("userId").toString());
		List<Long> orderids = orderService.getCompletedOrderIDByUserID(userid);
		List<Order> orders = new ArrayList<Order>(0);
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Long orderid : orderids) {
			Order o = orderService.getOrderByID(orderid);
			og = orderGoodsService.getOrderGoodsByOrderId(orderid);
			ordergoods.put(Long.toString(orderid), og);
			orders.add(o);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		return "zy/userallorder";
	}
	
	/* 显示该用户全部 "已取消" 订单记录*/
	@RequestMapping(value="/canceled", method=RequestMethod.GET)
	public String showAllCanceledOrder(Model model, HttpSession session)
	{
		Long userid=Long.valueOf(session.getAttribute("userId").toString());
		List<Long> orderids = orderService.getCanceledOrderIDByUserID(userid);
		List<Order> orders = new ArrayList<Order>(0);
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Long orderid : orderids) {
			Order o = orderService.getOrderByID(orderid);
			og = orderGoodsService.getOrderGoodsByOrderId(orderid);
			ordergoods.put(Long.toString(orderid), og);
			orders.add(o);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		return "zy/userallorder";
	}
	
	/* 查看订单详情 */
	@RequestMapping(value="/details",method=RequestMethod.GET)
	public String showOrderDetails(@RequestParam(name="order_sn")String sn, Model model, HttpSession session)
	{
		Long userid=Long.valueOf(session.getAttribute("userId").toString());
		Order order = orderService.getOrderBySN(sn);
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		List<String> goodsimg = new ArrayList<String>(0);
		for (OrderGoods og : ordergoods) {
			long goodsid = og.getGoods_id();
			Goods good = goodsMgtService.getGoodsByGoodsId(goodsid);
			goodsimg.add(good.getImage_path());
		}
		System.out.println(order.getUser_id());
		User user = userService.getUserByID(userid);
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		model.addAttribute("goodsimg",goodsimg);
		return "zy/userorderdetails";
	}
	
	
}
