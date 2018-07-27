package com.csu.entity;

import org.json.JSONObject;

public class Menu {
	private int m_id;
	private String m_code;
	private String m_name;
	private String m_description;
	private int superiormenu_id;
	
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_description() {
		return m_description;
	}
	public void setM_description(String m_description) {
		this.m_description = m_description;
	}
	public int getSuperiormenu_id() {
		return superiormenu_id;
	}
	public void setSuperiormenu_id(int superiormenu_id) {
		this.superiormenu_id = superiormenu_id;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("m_id", this.m_id);
		jo.put("m_code", this.m_code);
		jo.put("m_name", this.m_name);
		jo.put("m_description", this.m_description);
		jo.put("superiormenu_id", this.superiormenu_id);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
 * CREATE TABLE `tab_menu` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_code` varchar(64) DEFAULT NULL,
  `m_name` varchar(128) NOT NULL,
  `m_description` varchar(1000) DEFAULT NULL,
  `superiormenu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
  
