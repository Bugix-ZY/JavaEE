package xmu.mystore.ordersmgt.zy.model;
import java.io.Serializable;

import javax.validation.constraints.*;
import org.springframework.stereotype.Component;

/**
 * @Description: 订单实体类
 * @ClassNmae: Order
 * @author ZhengYang
 * @version: [1.0]
 */

@Component
public class Order implements Serializable {
	
	private static final long serialVersionUID = 129L;
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
	@Pattern(regexp = "\\d{6}", message = "邮编必须为 6 位数字")
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
	private long add_time;      
	/* 支付时间 */
	private long pay_time;      
	/* 状态变为定制中的时间 */
	private long make_time;     
	/* 状态变为已发货的时间 */
	private long shipped_time;   
	/* 状态变为已收货的时间 */
	private long receive_time;   
	/* 状态变为已取消的时间 */
	private long cancel_time;   
	/* 快递单号 */
	private String expressCode;
	/* 是否加急  （可以用Y/N来表示）*/
	private String isUrgency;
	
	/*-- Getters --*/
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getOrder_id() {
		return order_id;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public long getUser_id() {
		return user_id;
	}
	public int getOrder_status() {
		return order_status;
	}
	public String getConsignee() {
		return consignee;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getEmail() {
		return email;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public double getOrder_price() {
		return order_price;
	}
	public String getRemark() {
		return remark;
	}
	public double getTotal_weight() {
		return total_weight;
	}
	public String getSignature_characters() {
		return signature_characters;
	}
	public long getAdd_time() {
		return add_time;
	}
	public long getPay_time() {
		return pay_time;
	}
	public long getMake_time() {
		return make_time;
	}
	public long getShipped_time() {
		return shipped_time;
	}
	public long getReceive_time() {
		return receive_time;
	}
	public long getCancel_time() {
		return cancel_time;
	}
	public String getExpressCode() {
		return expressCode;
	}
	public String getIsUrgency() {
		return isUrgency;
	}

	
	/* -- Setters --*/
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	
	public void setAdd_time(long add_time) {
		this.add_time = add_time;
	}
	
	public void setPay_time(long pay_time) {
		this.pay_time = pay_time;
	}
	
	public void setMake_time(long make_time) {
		this.make_time = make_time;
	}
	
	public void setShipped_time(long shipped_time) {
		this.shipped_time = shipped_time;
	}
	
	public void setReceive_time(long receive_time) {
		this.receive_time = receive_time;
	}
	
	public void setCancel_time(long cancel_time) {
		this.cancel_time = cancel_time;
	}
	
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}
	public void setTotal_weight(double total_weight) {
		this.total_weight = total_weight;
	}
	public void setSignature_characters(String signature_characters) {
		this.signature_characters = signature_characters;
	}
	public void setIsUrgency(String isUrgency) {
		this.isUrgency = isUrgency;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	
	
	public String toString() {
		return "Order [order_id=" + order_id + ", order_sn=" + order_sn + ", user_id=" + user_id + ", order_status="
				+ order_status + ", consignee=" + consignee + ", address=" + address + ", zipcode=" + zipcode
				+ ", telephone=" + telephone + ", email=" + email + ", goods_price=" + goods_price + ", order_price="
				+ order_price + ", remark=" + remark + ", total_weight=" + total_weight + ", signature_characters="
				+ signature_characters + ", add_time=" + add_time + ", pay_time=" + pay_time + ", make_time="
				+ make_time + ", shipped_time=" + shipped_time + ", receive_time=" + receive_time + ", cancel_time="
				+ cancel_time + ", expressCode=" + expressCode + ", isUrgency=" + isUrgency + "]";
	}	
	
}
