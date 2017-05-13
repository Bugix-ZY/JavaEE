package com.xmu.sw.zjh.javaee.entity;
import javax.validation.constraints.*;

/**
 * @Description: 订单实体类
 * @ClassNmae: Order
 * @author ZhengYang
 * @version: [1.0]
 */

public class Order {
	
	/* 订单 订单号 */
	@NotNull(message = "订单号不可以为 Null ")
	private long order_id; 
	/* 订单编号 */
	@NotNull
	private String order_sn;
	/* 用户ID */
	@NotNull
	private long user_id;  
	/* 订单状态 */
	@NotNull
	private int order_status;    //（0：未付款；1：已付款；2：定制中；3：已发货；4：已收货；5：取消）
	/* 收货人 */
	@NotNull
	@Size(min=1, max=10)
	private String consignee;    
	/* 地址 */
	@NotNull
	@Size(min=1, max=50)
	private String address;  
	/* 邮编 */
	@NotNull
	@Pattern(regexp = "[1-9]\\d{5}", message = "邮编必须为 6 位数字")
	private String zipcode;    
	/* 电话 */
	@NotNull
	@Pattern(regexp = "((\\+\\d+)?1[34578]\\d{9}$) || ((\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$)" )
	private String telephone;   
	/* 邮箱 */
	private String email;       
	/* 商品总价 */
	private double goods_price; 
	/* 订单总价 */
	private double order_price; 
	/* 备注 */
	private String remark;      
	/* 订单总重 */
	private	double total_weight; 
	/* 订单签名 */
	private String signature_characters;  
	/* 下单时间（用int类型来保存时间戳） */
	private int add_time;      
	/* 支付时间 */
	private int pay_time;      
	/* 状态变为定制中的时间 */
	private int make_time;     
	/* 状态变为已发货的时间 */
	private int shipped_time;   
	/* 状态变为已收货的时间 */
	private int receive_time;   
	/* 状态变为已取消的时间 */
	private int cancel_time;   
	/* 快递单号 */
	private String expressCode;
	/* 是否加急  （可以用Y/N来表示）*/
	private String isUrgency;
	
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}	
	
	


}
