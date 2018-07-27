package com.csu.entity;

import org.json.JSONObject;

public class RoleMenu {
	private int id;
	private int r_id;
	private int m_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("id", this.id);
		jo.put("r_id", this.r_id);
		jo.put("m_id", this.m_id);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
CREATE TABLE `tab_rolemenu` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`r_id` int(11) NOT NULL,
`m_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
KEY `fkey_rm_rid` (`r_id`),
KEY `fkey_rm_mid` (`m_id`),
CONSTRAINT `fkey_rm_mid` FOREIGN KEY (`m_id`) REFERENCES `tab_menu` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fkey_rm_rid` FOREIGN KEY (`r_id`) REFERENCES `tab_role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/