package com.xmu.sw.zjh.javaee.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xmu.mystore.config.zy.MybatisConfig;
import xmu.mystore.ordersmgt.zy.model.Order;
import xmu.mystore.ordersmgt.zy.model.OrderGoods;
import xmu.mystore.ordersmgt.zy.service.IOrderGoodsService;
import xmu.mystore.ordersmgt.zy.service.IOrderService;
import xmu.mystore.ordersmgt.zy.serviceImpl.OrderServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( classes={MybatisConfig.class,  OrderServiceImpl.class})
public class OrderServiceTest {

	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("orderGoodsService")
	private IOrderGoodsService orderGoodsService;
	
//
//
//	
//	@Test 
//	public void helpme(){
//		List<Long> ids = orderService.getOrderIDByUserID(2550);
//		assertNotNull("ids should not be null", ids);
//		for (Long long1 : ids) {
//			System.out.println(long1);
//		}
//	}
//	
//	@Test
//	public void testGetAllOrder() {
//		List<Order> orders = orderService.getAllOrder();
//		assertNotNull("orders should not be null", orders);
//		System.out.println("---- testGetAllOrder ");
//		for (Order order : orders) {
//			System.out.println(order);
//		}
//	}
//
//	@Test
//	public void testGetOrderBySN() {
//		Order order = orderService.getOrderBySN("2017051200000");
//		assertNotNull("order should not be null", order);
//	}
//	
//	@Test
//	public void testGetOrderByConsignee() {
//		List<Order> orders = orderService.getOrderByConsignee("ZY");
//		assertNotNull("orders should not be null", orders);
//		System.out.println("---- testGetOrderByConsignee (ZY)");
//		for (Order order : orders) {
//			System.out.println(order.getOrder_sn());
//		}
//	}
//	
//	@Test
//	public void testGetOrderByUrgency() {
//		List<Order> orders = orderService.getOrderByUrgency("N");
//		assertNotNull("orders should not be null", orders);
//		System.out.println("---- testGetOrderByUrgency (N)");
//		for (Order order : orders) {
//			System.out.println(order.getOrder_sn());
//		}
//	}
//	
//	@Test
//	public void testGetOrderByStatus() {
//		List<Order> orders = orderService.getOrderByStatus(1);
//		assertNotNull("orders should not be null", orders);
//		System.out.println("---- testGetOrderByStatus (1)");
//		for (Order order : orders) {
//			System.out.println(order.getOrder_sn());
//		}
//	}
//	
//	@Test
//	public void testGetOrderByAddTime() {
//		List<Order> orders = orderService.getOrderByAddTime(10000000, 12345678);
//		assertNotNull("orders should not be null", orders);
//		System.out.println("---- testGetOrderByAddTime (10000000 ~ 12345678)");
//		for (Order order : orders) {
//			System.out.println(order.getOrder_sn());
//		}
//	}
//	
//	@Test
//	public void testGetOrderGoodsName() {
//		List<Order> orders = orderService.getOrderByGoodsName("Spring In Action");
//		assertNotNull("orders should not be null", orders);
//		System.out.println("---- testGetOrderGoodsName (Spring In Action)");
//		for (Order order : orders) {
//			System.out.println(order.getOrder_sn());
//		}
//	}
	
	
	@Test
	public void test() {
		List<Long> orders = orderService.getUnpaidOrderIDByUserID(1);
		assertNotNull("orders should not be null", orders);
		for (Long order : orders) {
			System.out.println(order);
		}
		System.out.println("--------");
		orders = orderService.getCanceledOrderIDByUserID(1);
		assertNotNull("orders should not be null", orders);
		for (Long order : orders) {
			System.out.println(order);
		}
//		System.out.println("--------");
//		orders = orderService.getShippingOrderIDByUserID(1);
//		assertNotNull("orders should not be null", orders);
//		for (Long order : orders) {
//			System.out.println(order);
//		}
//		System.out.println("--------");
//		orders = orderService.getCompletedOrderIDByUserID(1);
//		assertNotNull("orders should not be null", orders);
//		for (Long order : orders) {
//			System.out.println(order);
//		}
	}

}
