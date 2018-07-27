package com.csu.entity;

import org.json.JSONObject;

public class Skind {
	private int sk_id;
	private int f_id;
	private String name;
	
	
	public int getSk_id() {
		return sk_id;
	}
	public void setSk_id(int sk_id) {
		this.sk_id = sk_id;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("f_id", this.f_id);
		jo.put("sk_id", this.sk_id);
		jo.put("name", this.name);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
 * CREATE TABLE `tab_skind` (
  `sk_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `f_id` int(10) unsigned NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;
*/

