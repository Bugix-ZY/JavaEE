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
	int is_default;          //是否为默认地址。注：一个用户常用地址可以是多个，默认地址就只有一个(⊙o⊙)哦 
	
	
	@Override
	public String toString() {
		return "UserAddress [address_id=" + address_id + ", user_id=" + user_id + ", consignee=" + consignee
				+ ", zipcode=" + zipcode + ", telephone=" + telephone + ", country=" + country + ", province="
				+ province + ", city=" + city + ", district=" + district + ", detail=" + detail + ", is_default="
				+ is_default + "]";
	}
	public long getAddress_id() {
		return address_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public String getConsignee() {
		return consignee;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getTelephone() {
		return telephone;
	}
	public int getCountry() {
		return country;
	}
	public int getProvince() {
		return province;
	}
	public int getCity() {
		return city;
	}
	public int getDistrict() {
		return district;
	}
	public String getDetail() {
		return detail;
	}
	public int getIs_default() {
		return is_default;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setIs_default(int is_default) {
		this.is_default = is_default;
	}
	
	
	
	
	
}
