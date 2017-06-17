package xmu.mall.goodsindex.zjh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
import xmu.mall.goodsindex.zjh.model.OrderInfo;
import xmu.mall.goodsindex.zjh.model.ShoppingCart;
import xmu.mall.goodsindex.zjh.service.IShoppingCartService;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.goodsmgt.zlt.service.GoodsService;
import xmu.mystore.ordersmgt.zy.service.IOrderGoodsService;
import xmu.mystore.ordersmgt.zy.service.IOrderService;

@Controller
@RequestMapping(value="/cart")
public class ShoppingCartController {
	
	@Autowired
	@Qualifier("ShoppingCartService")
	private IShoppingCartService shoppingCartService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private GoodsService goodService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderGoodsService orderGoodsService;

	
	/**
	 * 跳转到购物车主页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String cartIndex(Model model,HttpSession session)
	{
		Long userId=Long.valueOf(session.getAttribute("userId").toString());
		model.addAttribute("shoppingCartList",shoppingCartService.getShoppingCartListByUserId(userId));
		return "zjh/cartIndex";
	}
	
	/**
	 * 添加购物车
	 * @param shopppingCart
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public AjaxReturnResult addShoppingCart(
			@ModelAttribute ShoppingCart shopppingCart,
			Model model,
			HttpSession session)
	{
		//需要session
		shopppingCart.setUserId(Long.valueOf(session.getAttribute("userId").toString()));
		return shoppingCartService.add(shopppingCart);
	}
	
	/**
	 * 删除购物车
	 * @param shoppingCarts
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult deleteShoppingCarts(
			@RequestBody List<ShoppingCart> shoppingCarts
			)
	{
		return shoppingCartService.delete(shoppingCarts);
	}
	
	/**
	 * 更新购物车
	 * @param shoppingCarts
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxReturnResult updateShoppingCarts(
			@RequestBody List<ShoppingCart> shoppingCarts
			)
	{
		return shoppingCartService.update(shoppingCarts);
	}
	
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
			Model model)
	{
		List<OrderInfo> orderInforList=new ArrayList<OrderInfo>();
		if(goodsId.length==goodsNumber.length)
		{
			for(int i=0;i<goodsId.length;++i)
			{
				OrderInfo orderInfo=new OrderInfo();
				orderInfo.setGoodsId(Long.valueOf(goodsId[i]));
				orderInfo.setGoodsNumber(Long.valueOf(goodsNumber[i]));
				orderInforList.add(orderInfo);
			}
		}
		model.addAttribute("orderList",orderInforList);
		return "zjh/ordertest";
	}
	
//	/**
//	 * 处理订单页面
//	 * @param goodsId
//	 * @param goodsNumber
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value="/order",method=RequestMethod.POST)
//	public String turnToOrderPage(
//			String[]goodsId,
//			String[]goodsNumber,
//			Model model, HttpSession session)
//	{
//
//		Long user_id=Long.valueOf(session.getAttribute("userId").toString());
//
//		
//		Order order = new Order();
//	
//        order.setOrder_sn(orderService.createOrder_sn()); 
//		
//		List<Order> orders = orderService.getShoppingCart(user_id);	
//		System.out.println(orders.size());
//		if(orders.size() == 0)
//			return "test";		
//		User user = userService.getUserByID(user_id);
//		UserAddress address = userService.getDefaultAddress(user_id);
//		order.setConsignee(address.getConsignee());
//		order.setIsUrgency("N");
//		order.setZipcode(address.getZipcode());
//		order.setOrder_status(0);
//		order.setAddress(address.getDetail());
//		order.setTelephone(address.getTelephone());
//		order.setUser_id(user_id);
//		order.setTotal_weight(0d);
//		order.setOrder_price(0d);
//		order.setRemark("");
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d = new Date();
//		String t = df.format(d);
//		try {
//			int time_now = (int) (df.parse(t).getTime() / 1000);
//			
//			order.setAdd_time(time_now);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		orderService.addOrder(order);
//		
//		double total_weight = 0;
//		
//		double order_price = 0;
//		
//		List<OrderGoods> orderGoodsList=new ArrayList<OrderGoods>();
//		if(goodsId.length==goodsNumber.length)
//		{
//			for(int i=0;i<goodsId.length;++i)
//			{
//				OrderGoods orderGoods=new OrderGoods();
//				Goods goods = (Goods) goodService.getGoodsById(Long.parseLong(goodsId[i]));
//				orderGoods.setOrder_id(order.getOrder_id());
//				orderGoods.setGoods_id(Long.parseLong(goodsId[i]));
//				orderGoods.setGoods_name(goods.getName());
//				orderGoods.setGoods_price(goods.getReal_price());
//				orderGoods.setGoods_number(Integer.parseInt(goodsNumber[i]));
//				total_weight += goods.getWeight() * Integer.parseInt(goodsNumber[i]);
//				order_price += goods.getReal_price() * Integer.parseInt(goodsNumber[i]);
//				orderGoodsService.addOrderGoods(orderGoods);
//				goodService.deleteGoodsNumById(goodsId[i], Integer.parseInt(goodsNumber[i]));
//				shoppingCartService.deleteByUserIdAndGoodsId(user_id, Long.parseLong(goodsId[i]));
//				orderGoodsList.add(orderGoods);
//			}
//		}
//		
//		order.setTotal_weight(total_weight);
//		order.setOrder_price(order_price);
//		//System.out.println(order.getTotal_weight() + "   " + order.getOrder_price());
//		orderService.updateOrder(order);
//		
//		model.addAttribute("userAddress", address);
//		model.addAttribute("goodslist", orderGoodsList);
//		model.addAttribute("order", order);
//		
//		model.addAttribute("user", user);
//		return "tangkai/balance";
//	}

}
