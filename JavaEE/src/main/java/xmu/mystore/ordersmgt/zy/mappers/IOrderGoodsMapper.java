package xmu.mystore.ordersmgt.zy.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import xmu.mystore.ordersmgt.zy.model.OrderGoods;

@Component
public interface IOrderGoodsMapper {
	List<OrderGoods> getOrderGoodsByOrderId(long id);
}
