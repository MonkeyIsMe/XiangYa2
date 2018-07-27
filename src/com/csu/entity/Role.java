package com.csu.entity;

import org.json.JSONObject;

public class Role {
	private int r_id;
	private String r_code;
	private String r_name;
	private String r_description;
	private int r_sort;
	
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_code() {
		return r_code;
	}
	public void setR_code(String r_code) {
		this.r_code = r_code;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_description() {
		return r_description;
	}
	public void setR_description(String r_description) {
		this.r_description = r_description;
	}
	public int getR_sort() {
		return r_sort;
	}
	public void setR_sort(int r_sort) {
		this.r_sort = r_sort;
	}
	
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("r_id", this.r_id);
		jo.put("r_code", this.r_code);
		jo.put("r_name", this.r_name);
		jo.put("r_description", this.r_description);
		jo.put("r_sort", this.r_sort);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}


/*
 * 
 * CREATE TABLE `tab_role` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_code` varchar(64) DEFAULT NULL,
  `r_name` varchar(128) NOT NULL,
  `r_description` varchar(1000) DEFAULT NULL,
  `r_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
