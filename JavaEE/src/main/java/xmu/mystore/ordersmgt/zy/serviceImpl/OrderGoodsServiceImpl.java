package xmu.mystore.ordersmgt.zy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.ordersmgt.zy.mapper.IOrderGoodsMapper;
import xmu.mystore.ordersmgt.zy.model.OrderGoods;
import xmu.mystore.ordersmgt.zy.service.IOrderGoodsService;

@Service("orderGoodsService")
@Transactional
public class OrderGoodsServiceImpl implements IOrderGoodsService {

	@Autowired
	private IOrderGoodsMapper orderGoodsMapper;
	
	public List<OrderGoods> getOrderGoodsByOrderId(long id) {
		return orderGoodsMapper.getOrderGoodsByOrderId(id);
	}

	public void addOrderGoods(OrderGoods orderGoods) {
		orderGoodsMapper.addOrderGoods(orderGoods);
	}

}
