package xmu.mall.usercenter.zy.model;

import java.io.Serializable;

/**
 * @Description: 用户实体类
 * @ClassNmae: User
 * @author ZhengYang
 * @version: [1.0]
 */

public class UserCollection implements Serializable {

	private static final long serialVersionUID = 8270629270914117271L;
	
	private long rec_id;       //主键
	private long user_id;      //用户ID
	private long goods_id;     //商品ID
	private String  add_time;  //添加时间
	
	
	/*-- Getters and Setters */
	public long getRec_id() {
		return rec_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public long getGoods_id() {
		return goods_id;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public void setGoods_id(long goods_id) {
		this.goods_id = goods_id;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	
}
