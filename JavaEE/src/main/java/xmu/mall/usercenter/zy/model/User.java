package xmu.mall.usercenter.zy.model;

import java.io.Serializable;

/**
 * @Description: 用户实体类
 * @ClassNmae: User
 * @author ZhengYang
 * @version: [1.0]
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -1602869510905935769L;
	long user_id;	
	String user_name;	//用户姓名
	String password;	//用户密码（进行加密，用rsa加密，注意保留公钥和私钥【有问题可以问曹将将】）
	String mobile_phone;	//用户联系方式
	String imagepath;       //头像(0-0有时间、能做的话就做吧，不能做也放个静态图片上去)
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getUser_id() {
		return user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	

	
}
