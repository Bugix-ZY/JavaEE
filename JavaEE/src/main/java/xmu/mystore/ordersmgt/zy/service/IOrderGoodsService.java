package xmu.mystore.ordersmgt.zy.service;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zy.model.OrderGoods;

@Component
public interface IOrderGoodsService {
	List<OrderGoods> getOrderGoodsByOrderId(long id);
	public void addOrderGoods(OrderGoods orderGoods);
}
