package xmu.mystore.ordersmgt.zy.serviceImpl;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;
import xmu.mystore.annotation.zy.ServiceLogger;
import xmu.mystore.ordersmgt.zy.mapper.IOrderMapper;
import xmu.mystore.ordersmgt.zy.model.Order;
import xmu.mystore.ordersmgt.zy.service.IOrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderMapper orderMapper;
	
	@Autowired
	private IUserService userService;
	
	/*-- 查询 --*/
	/* 返回 Order */
	public Order getOrderBySN(String sn) {
		return this.orderMapper.getOrderBySN(sn);
	}
	public Order getOrderByID(long id) {
		return this.orderMapper.getOrderByID(id);
	}
	public List<Order> getAllOrder() {
		return this.orderMapper.getAllOrder();
	}
	public List<Order> getOrderByConsignee(String consignee) {
		return this.orderMapper.getOrderByConsignee(consignee);
	}
	public List<Order> getOrderByUrgency(String urgency) {
		return this.orderMapper.getOrderByUrgency(urgency);
	}
	public List<Order> getOrderByStatus(int status) {
		return this.orderMapper.getOrderByStatus(status);
	}
	public List<Order> getOrderByAddTime(long start, long end) {
		return this.orderMapper.getOrderByAddTime(start, end);
	}
	public List<Order> getOrderByGoodsName(String goodsName) {
		return this.orderMapper.getOrderByGoodsName(goodsName);
	}
	/* 返回 ID*/
	public List<Long> getAllOrderID() {
		return this.orderMapper.getAllOrderID();
	}
	public List<Long> getOrderIDByConsignee(String consignee) {
		return this.orderMapper.getOrderIDByConsignee(consignee);
	}
	public List<Long> getOrderIDByUrgency(String urgency) {
		return this.orderMapper.getOrderIDByUrgency(urgency);
	}
	public List<Long> getOrderIDByStatus(int status) {
		return this.orderMapper.getOrderIDByStatus(status);
	}
	public List<Long> getOrderIDByAddTime(long start, long end) {
		return this.orderMapper.getOrderIDByAddTime(start, end);
	}
	public List<Long> getOrderIDByGoodsName(String goodsName) {
		return this.orderMapper.getOrderIDByGoodsName(goodsName);
	}
	public List<Long> getOrderIDByUserID(long userid) {
		return this.orderMapper.getOrderIDByUserID(userid);
	}
	public List<Long> getUnpaidOrderIDByUserID(long userid) {
		return this.orderMapper.getUnpaidOrderIDByUserID(userid);
	}
	public List<Long> getShippingOrderIDByUserID(long userid) {
		return this.orderMapper.getShippingOrderIDByUserID(userid);
	}
	public List<Long> getCompletedOrderIDByUserID(long userid) {
		return this.orderMapper.getCompletedOrderIDByUserID(userid);
	}
	public List<Long> getCanceledOrderIDByUserID(long userid) {
		return this.orderMapper.getCanceledOrderIDByUserID(userid);
	}
	
	/* 根据各字段进行查询 */
	public List<Order> searchOrder(String sn, String goodsname, String consignee, String username, String mobile,
			String start, String end, String status, String urgency) {
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); 
		Order ordersn = null;
		long orderid = -1;
		List<Long> allorders = getAllOrderID();
		List<Long> ordersGoodsname = allorders;
		List<Long> ordersConsignee = allorders;
		List<Long> ordersUsername = allorders;
		List<Long> ordersUserid = allorders;
		List<Long> ordersTime = allorders;
		List<Long> ordersStatus = allorders;
		List<Long> ordersUrgency = allorders;
		List<Order> orders = new ArrayList<Order>(0);
		
		if (!sn.isEmpty()) {
			ordersn = getOrderBySN(sn);
			if (ordersn != null) {
				orderid = ordersn.getOrder_id();
				allorders.clear();
				allorders.add(orderid);
			} else {
				allorders.clear();
			}
		} 
		if (!goodsname.isEmpty()) {
			ordersGoodsname = getOrderIDByGoodsName(goodsname);
		}
		if (!consignee.isEmpty()) {
			ordersConsignee = getOrderIDByConsignee(consignee);
		}
		if (!start.isEmpty() && !end.isEmpty()) {
			try {
				ordersTime = getOrderIDByAddTime(format.parse(start).getTime(), format.parse(end).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!start.isEmpty() && end.isEmpty()) {
			try {
				ordersTime = getOrderIDByAddTime(format.parse(start).getTime(), Long.MAX_VALUE);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (start.isEmpty() && !end.isEmpty()) {
			ordersTime = getOrderIDByAddTime(0, Long.MAX_VALUE);
		}
		if (!urgency.isEmpty() && !urgency.equals("-1")) {

			ordersUrgency = getOrderIDByUrgency(urgency);
		}
		if (!status.isEmpty() && !status.equals("-1")) {
			ordersStatus = getOrderIDByStatus(Integer.parseInt(status));
		}
			
		if (!mobile.isEmpty()) {
			User user = userService.getUserByMobile(mobile); 
			if (user != null) {
				ordersUserid = getOrderIDByUserID(user.getUser_id());
			} else {
				ordersUserid.clear();
			}
		}
		if (!username.isEmpty()) {
			User user = userService.getUserByUsername(username);
			if (user != null) {
				ordersUsername = getOrderIDByUserID(user.getUser_id());
			} else {
				ordersUserid.clear();
			}
		}
	
		if (ordersGoodsname.isEmpty()|| ordersConsignee.isEmpty() || ordersTime.isEmpty()
				|| ordersUrgency.isEmpty() || ordersStatus.isEmpty() || ordersUsername.isEmpty()
				|| ordersUserid.isEmpty()) {
			allorders.clear();
		} else {
			allorders.retainAll(ordersGoodsname);
			allorders.retainAll(ordersConsignee);
			allorders.retainAll(ordersTime);
			allorders.retainAll(ordersUrgency);
			allorders.retainAll(ordersStatus);
			allorders.retainAll(ordersUsername);
			allorders.retainAll(ordersUserid);
		}


		for (long oid : allorders) {
			orders.add(getOrderByID(oid));
		}
		return orders;
		
	}

	/*-- 更新 --*/
	@ServiceLogger
	public void updateOrderRemark(Order order) {
		this.orderMapper.updateOrderRemark(order);
	}
	@ServiceLogger
	public void updateOrderAddress(Order order) {
		this.orderMapper.updateOrderAddress(order);
	}
	@ServiceLogger
	public void updateOrderExpressCode(Order order) {
		this.orderMapper.updateOrderExpressCode(order);
	}
	@ServiceLogger
	public void updateOrderStatus(Order order) {
		// 设置其他时间为 0 的含义是：如果订单状态后退，那么先前状态恢复成默认值 0
		if (order.getOrder_status() == 1) {
			order.setPay_time(System.currentTimeMillis());
			order.setMake_time(0);
			order.setShipped_time(0);
			order.setReceive_time(0);
			order.setCancel_time(0);
		} else if (order.getOrder_status() == 2) {
			order.setMake_time(System.currentTimeMillis());
			order.setShipped_time(0);
			order.setReceive_time(0);
			order.setCancel_time(0);
		} else if  (order.getOrder_status() == 3) {
			order.setShipped_time(System.currentTimeMillis());
			order.setReceive_time(0);
			order.setCancel_time(0);
		} else if  (order.getOrder_status() == 4) {
			order.setReceive_time(System.currentTimeMillis());
		} else if  (order.getOrder_status() == 5) {
			order.setCancel_time(System.currentTimeMillis());
		}
		this.orderMapper.updateOrderPayTime(order);
		this.orderMapper.updateOrderShipTime(order);
		this.orderMapper.updateOrderMakeTime(order);
		this.orderMapper.updateOrderCancelTime(order);
		this.orderMapper.updateOrderRecvTime(order);
		this.orderMapper.updateOrderStatus(order);
	}
	
	
	public void addOrder(Order order) {
		this.orderMapper.addOrder(order);
	}


	public void receiveOrder(long order_id) {
		Order order = orderMapper.getOrderByID(order_id);
		orderMapper.updateOrderRecvTime(order);
	}

	public void cancelOrder(long order_id) {
		Order order = orderMapper.getOrderByID(order_id);
		orderMapper.updateOrderCancelTime(order);
	}
	
	public String createOrder_sn() {
		Format format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(new Date());
        int x = (new Random(System.currentTimeMillis())).nextInt(100000);
        
        String order_sn = time + String.format("%05d",x);
		return order_sn;
	}
	@Override
	public void updateOrder(Order order) {
		orderMapper.updateOrder(order);
	}

}
