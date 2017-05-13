package com.xmu.sw.zjh.javaee.entity;

/**
 * @Description: 商品品牌实体类
 * @ClassNmae:Brand
 * @author Zheng Yang
 * @version: [1.0]
 */

public class Brand {
	
	/** 品牌 名称 */
	private String name; //1-20字
	/** 品牌 网址 */
	private String url; //符合规划，保存到数据库自动加http://
	/** 品牌 简介 */
	private String description;
	/** 品牌 是否显示在前台 */
	private boolean isVisible;
	
	/* -- Getters -- */
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String getDescription() {
		return description;
	}
	public boolean isVisible() {
		return isVisible;
	}

	/* -- Setters -- */
	/**
	 * Name: setName
	 * Description: 修改品牌的名称,名称长度为1-20字
	 * @param name
	 * @return
	 * 
	 */
	public boolean setName(String name) {
		if (name.length() < 1 || name.length() > 20){
			return false;
		}
		this.name = name;
		return true;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean setDescription(String description) {
		if (description.getBytes().length < 0 || description.getBytes().length > 255){
			return false;
		}
		this.description = description;
		return true;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	
	
}
