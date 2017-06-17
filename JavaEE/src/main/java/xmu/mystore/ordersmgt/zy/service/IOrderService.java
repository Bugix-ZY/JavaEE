package xmu.mystore.ordersmgt.zy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mystore.ordersmgt.zy.model.Order;

@Component
public interface IOrderService {
	
	/*-- 查询 --*/
	public Order getOrderBySN(String sn);
	public Order getOrderByID(long id);
	public List<Order> getAllOrder();
	public List<Order> getOrderByConsignee(String consignee);
	public List<Order> getOrderByUrgency(String urgency);
	public List<Order> getOrderByStatus(int status);
	public List<Order> getOrderByAddTime(long start, long end);
	public List<Order> getOrderByGoodsName(String goodsName);
	public List<Long> getAllOrderID();
	public List<Long> getOrderIDByConsignee(String consignee);
	public List<Long> getOrderIDByUrgency(String urgency);
	public List<Long> getOrderIDByStatus(int status);
	public List<Long> getOrderIDByAddTime(@Param("start")long start, @Param("end")long end);
	public List<Long> getOrderIDByGoodsName(String goodsName);
	public List<Long> getOrderIDByUserID(long userid); 
	
	public List<Long> getUnpaidOrderIDByUserID(long userid);
	public List<Long> getShippingOrderIDByUserID(long userid);
	public List<Long> getCompletedOrderIDByUserID(long userid);
	public List<Long> getCanceledOrderIDByUserID(long userid);
	// 高级查询
	public List<Order> searchOrder(String sn, String goodsname,String consignee,String username,
			String mobile, String start, String end,String status,String urgency) ;

	/*-- 更新 --*/
	public void updateOrderRemark(Order order);
	public void updateOrderAddress(Order order);
	public void updateOrderExpressCode(Order order);
	public void updateOrderStatus(Order order);
	
	public void updateOrder(Order order);
	/*-- 新增 --*/
	public void addOrder(Order order);
	public void receiveOrder(@Param("order_id") long order_id);
	public void cancelOrder(@Param("order_id") long order_id);
	
	public String createOrder_sn();
}
