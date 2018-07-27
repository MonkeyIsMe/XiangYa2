package com.csu.entity;

import org.json.JSONObject;

public class Dept {
	private int dept_id;
	private String dept_code;
	private String dept_name;
	private String dept_description;
	private int superiotdept_id;
	private int dept_sort;
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_description() {
		return dept_description;
	}
	public void setDept_description(String dept_description) {
		this.dept_description = dept_description;
	}
	public int getSuperiotdept_id() {
		return superiotdept_id;
	}
	public void setSuperiotdept_id(int superiotdept_id) {
		this.superiotdept_id = superiotdept_id;
	}
	public int getDept_sort() {
		return dept_sort;
	}
	public void setDept_sort(int dept_sort) {
		this.dept_sort = dept_sort;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("dept_id", this.dept_id);
		jo.put("dept_code", this.dept_code);
		jo.put("dept_name", this.dept_name);
		jo.put("dept_description", this.dept_description);
		jo.put("superiotdept_id", this.superiotdept_id);
		jo.put("dept_sort", this.dept_sort);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
 *CREATE TABLE `tab_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(64) DEFAULT NULL,
  `dept_name` varchar(128) NOT NULL,
  `dept_description` varchar(1000) DEFAULT NULL,
  `superiotdept_id` int(11) DEFAULT '1',
  `dept_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8; 
 */
