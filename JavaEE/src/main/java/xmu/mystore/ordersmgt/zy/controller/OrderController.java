package xmu.mystore.ordersmgt.zy.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.ordersmgt.zy.model.Order;
import xmu.mystore.ordersmgt.zy.model.OrderGoods;
import xmu.mystore.ordersmgt.zy.service.IOrderGoodsService;
import xmu.mystore.ordersmgt.zy.service.IOrderService;

@Controller
@RequestMapping(value="order/")
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("orderGoodsService")
	private IOrderGoodsService orderGoodsService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	
	/* 显示全部订单记录*/
	@RequestMapping(value="all", method=RequestMethod.GET)
	public String showAllOrder(Model model)
	{
		List<Order> orders = orderService.getAllOrder();
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<User> users = new ArrayList<User>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Order order : orders) {
			og = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
			User usr = userService.getUserByID(order.getUser_id());
			ordergoods.put(Long.toString(order.getOrder_id()), og);
			users.add(usr);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		model.addAttribute("users",users); 				// list
		return "zy/orderall";
	}
	
	
	/* 查看订单详情 */
	@RequestMapping(value="details",method=RequestMethod.GET)
	public String showOrderDetails(@RequestParam(name="order_sn")String sn, Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		return "zy/orderdetails";
	}

	
	/* 订单发货：已付款 -> 定制中 */
	@RequestMapping(value="confirm", method=RequestMethod.GET)
	public String showAllOrderAfterUpdateStatus(@RequestParam(name="order_sn")String sn,Model model)
	{
		Order o = orderService.getOrderBySN(sn);
		o.setOrder_status(2); // 定制中：2
		orderService.updateOrderStatus(o);
		List<Order> orders = orderService.getAllOrder();
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<User> users = new ArrayList<User>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Order order : orders) {
			og = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
			User usr = userService.getUserByID(order.getUser_id());
			ordergoods.put(Long.toString(order.getOrder_id()), og);
			users.add(usr);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		model.addAttribute("users",users); 				// list
		return "zy/orderall";
	}
	
	/* 确认修改订单快递单号后 (发货)  */
	@RequestMapping(value="expresscodeonly",method=RequestMethod.POST)
	public String updateOrderDeliveryExpressCode(@RequestParam(name="code")String code, @RequestParam(name="order_sn")String sn,Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		order.setExpressCode(code);
		order.setOrder_status(3); // 已发货：3
		orderService.updateOrderStatus(order);
		orderService.updateOrderAddress(order);
		
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		
		return "zy/orderdetails";
	}
	
	
	
	/* 跳转至修改订单号页面 */
	@RequestMapping(value="deliver",method=RequestMethod.GET)
	public String updateOrderExpressCode(@RequestParam(name="order_sn")String sn, Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		
		return "zy/orderdeliver";
	}	
	
	/* 跳转至修改订单详情 */
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateOrderPage(@RequestParam(name="order_sn")String sn, Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		return "zy/orderupdate";
	}
	
	/* 确认修改订单备注后  */
	/* 修改备注 */
	@RequestMapping(value="remark",method=RequestMethod.POST)
	public String updateOrderRemark(@RequestParam(name="note")String note, @RequestParam(name="order_sn")String sn,Model model) throws UnsupportedEncodingException
	{
		Order order = orderService.getOrderBySN(sn);
		order.setRemark(note);
		orderService.updateOrderRemark(order);
		
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		
		return "zy/orderupdate";
	}
	
	/* 确认修改订单地址后  */
	/* 修改地址 */
	@RequestMapping(value="address",method=RequestMethod.POST)
	public String updateOrderAddress(@RequestParam(name="address")String address, @RequestParam(name="order_sn")String sn,Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		order.setAddress(address);
		orderService.updateOrderAddress(order);
		
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		
		return "zy/orderupdate";
	}
	
	/* 确认修改订单快递单号后  */
	/* 修改快递单号 */
	@RequestMapping(value="expresscode",method=RequestMethod.POST)
	public String updateOrderExpressCode(@RequestParam(name="code")String code, @RequestParam(name="order_sn")String sn,Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		order.setExpressCode(code);
		orderService.updateOrderAddress(order);
		
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		
		return "zy/orderupdate";
	}
	
	/* 确认修改订单状态后  */
	/* 修改订单状态 */
	@RequestMapping(value="status",method=RequestMethod.POST)
	public String updateOrderStatus(@RequestParam(name="orderstatus")String status, @RequestParam(name="order_sn")String sn,Model model)
	{
		Order order = orderService.getOrderBySN(sn);
		order.setOrder_status(Integer.parseInt(status));
		orderService.updateOrderStatus(order);
		
		List<OrderGoods> ordergoods = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
		User user = userService.getUserByID(order.getUser_id());
		model.addAttribute("order",order); 
		model.addAttribute("ordergoods",ordergoods); 
		model.addAttribute("user",user); 
		
		return "zy/orderupdate";
	}


	/* 跳转至精确搜索页面  */
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String searchPage(Model model)
	{
		return "zy/ordersearch";
	}

	/* 跳转至搜索结果页面  */
	@RequestMapping(value="searchresult",method=RequestMethod.POST)
	public String searchResultPage(@RequestParam(name="ordersn")String sn, @RequestParam(name="goodsname")String goodsname,
			@RequestParam(name="consignee")String consignee,@RequestParam(name="username")String username,
			@RequestParam(name="mobile")String mobile, @RequestParam(name="addtimestart")String start, 
			@RequestParam(name="addtimeend")String end,@RequestParam(name="orderstatus")String status,
			@RequestParam(name="isurgency")String urgency, Model model) throws ParseException
	{
		
		List<Order> orders = orderService.searchOrder(sn, goodsname, consignee, username, mobile, start, end, status, urgency);
		HashMap<String, List<OrderGoods>> ordergoods = new HashMap<String, List<OrderGoods>>(0);
		List<User> users = new ArrayList<User>(0);
		List<OrderGoods> og = new ArrayList<OrderGoods>(0);
		for (Order order : orders) {
			og = orderGoodsService.getOrderGoodsByOrderId(order.getOrder_id());
			User usr = userService.getUserByID(order.getUser_id());
			ordergoods.put(Long.toString(order.getOrder_id()), og);
			users.add(usr);
		}
		model.addAttribute("orders",orders);  			// list
		model.addAttribute("ordergoods",ordergoods); 	// hashmap
		model.addAttribute("users",users); 				// list
		return "zy/ordersearchresult";
	}

}
