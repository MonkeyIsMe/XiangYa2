package com.csu.entity;

import org.json.JSONObject;

public class UserMsg {
	private int u_id;
	private String u_name;
	private String u_gender;
	private String u_tel;
	private String u_mail;
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("u_id", this.u_id);
		jo.put("u_name", this.u_name);
		jo.put("u_gender", this.u_gender);
		jo.put("u_tel", this.u_tel);
		jo.put("u_mail", this.u_mail);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}

/*
CREATE TABLE `tab_usermsg` (
`u_id` int(11) NOT NULL,
`u_name` varchar(128) NOT NULL DEFAULT '',
`u_gender` varchar(16) NOT NULL,
`u_tel` varchar(64) DEFAULT NULL,
`u_mail` varchar(64) DEFAULT NULL,
PRIMARY KEY (`u_id`),
CONSTRAINT `fkey_umsg_uid` FOREIGN KEY (`u_id`) REFERENCES `tab_sysuser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/