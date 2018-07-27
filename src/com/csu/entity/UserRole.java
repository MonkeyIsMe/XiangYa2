package com.csu.entity;

import org.json.JSONObject;

public class UserRole {
	private int id;
	private int u_id;
	private int r_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("u_id", this.u_id);
		jo.put("id", this.id);
		jo.put("r_id", this.r_id);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}

/*
 * CREATE TABLE `tab_userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_ur_uid` (`u_id`),
  KEY `fkey_ur_rid` (`r_id`),
  CONSTRAINT `fkey_ur_rid` FOREIGN KEY (`r_id`) REFERENCES `tab_role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkey_ur_uid` FOREIGN KEY (`u_id`) REFERENCES `tab_sysuser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */