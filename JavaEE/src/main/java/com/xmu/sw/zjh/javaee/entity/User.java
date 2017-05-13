package com.xmu.sw.zjh.javaee.entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -1602869510905935769L;
	long user_id;	
	String user_name;	//用户姓名
	String password;	//用户密码（进行加密，用rsa加密，注意保留公钥和私钥【有问题可以问曹将将】）
	String mobile_phone;	//用户联系方式
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

	
}
