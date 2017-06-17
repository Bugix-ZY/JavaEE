package xmu.mystore.ordersmgt.zy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zy.model.Order;

@Component
public interface IOrderMapper {
	
	/*-- 查询 --*/
	Order getOrderBySN(String sn);
	Order getOrderByID(long id);
	List<Order> getAllOrder();
	List<Order> getOrderByConsignee(String consignee);
	List<Order> getOrderByUrgency(String urgency);
	List<Order> getOrderByStatus(int status);
	List<Order> getOrderByAddTime(@Param("start")long start, @Param("end")long end);
	List<Order> getOrderByGoodsName(String goodsName);
	
	List<Long> getAllOrderID();
	List<Long> getOrderIDByConsignee(String consignee);
	List<Long> getOrderIDByUrgency(String urgency);
	List<Long> getOrderIDByStatus(int status);
	List<Long> getOrderIDByAddTime(@Param("start")long start, @Param("end")long end);
	List<Long> getOrderIDByGoodsName(String goodsName);
	List<Long> getOrderIDByUserID(long userid); 
	
	List<Long> getUnpaidOrderIDByUserID(long userid);
	List<Long> getShippingOrderIDByUserID(long userid);
	List<Long> getCompletedOrderIDByUserID(long userid);
	List<Long> getCanceledOrderIDByUserID(long userid);
	
	/*-- 更新 --*/
	void updateOrderRemark(Order order);
	void updateOrderAddress(Order order);
	void updateOrderExpressCode(Order order);
	void updateOrderStatus(Order order);
	
	void updateOrderPayTime(Order order);
	void updateOrderShipTime(Order order);
	void updateOrderMakeTime(Order order);
	void updateOrderRecvTime(Order order);
	void updateOrderCancelTime(Order order);
	
	void updateOrder(Order order);
	
	/*-- 给用户信息页的接口 --*/
	void addOrder(Order order);
//	public List<Order> getOrderByStatus(long user_id, int status);
	public void receiveOrder(@Param("order_id") long order_id);
	public void cancelOrder(@Param("order_id") long order_id);
//	public List<Order> getOrderByUser_id(long user_id);
}
