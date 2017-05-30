package xmu.mall.usercenter.zy.model;

public class UserAddress {

	long address_id;          //主码，地址ID
	long user_id;             //用户ID
	String consignee;         //收件人
	String zipcode;     	  //邮编
	String telephone;   	  //电话
	int  country;             //国家ID
	int  province;            //省ID
	int  city;                //城市ID
	int  district;            //区ID
	String detail;            //详细地址
	boolean is_default;          //是否为默认地址。注：一个用户常用地址可以是多个，默认地址就只有一个(⊙o⊙)哦
	
}
