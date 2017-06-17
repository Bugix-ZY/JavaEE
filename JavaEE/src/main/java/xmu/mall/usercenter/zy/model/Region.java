package xmu.mall.usercenter.zy.model;

import java.io.Serializable;

public class Region implements Serializable {

	private static final long serialVersionUID = 309681792581287267L;
	
	int region_id;
	int parent_id;
	int agency_id;
	int type;
	String region_name;
	
	public int getRegion_id() {
		return region_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public int getAgency_id() {
		return agency_id;
	}
	public int getType() {
		return type;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	
}
