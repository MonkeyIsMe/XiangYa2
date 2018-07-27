package com.csu.entity;

import java.util.Date;

import org.json.JSONObject;

public class Unit {
	private int U_ID;
	private String U_NAME;
	private String U_INFO;
	private String U_ICONPATH;
	private String U_STATE;
	private String U_ProName;
	private Date U_CreatTime;
	
	
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public String getU_NAME() {
		return U_NAME;
	}
	public void setU_NAME(String u_NAME) {
		U_NAME = u_NAME;
	}
	public String getU_INFO() {
		return U_INFO;
	}
	public void setU_INFO(String u_INFO) {
		U_INFO = u_INFO;
	}
	public String getU_ICONPATH() {
		return U_ICONPATH;
	}
	public void setU_ICONPATH(String u_ICONPATH) {
		U_ICONPATH = u_ICONPATH;
	}
	public String getU_STATE() {
		return U_STATE;
	}
	public void setU_STATE(String u_STATE) {
		U_STATE = u_STATE;
	}
	public String getU_ProName() {
		return U_ProName;
	}
	public void setU_ProName(String u_ProName) {
		U_ProName = u_ProName;
	}
	public Date getU_CreatTime() {
		return U_CreatTime;
	}
	public void setU_CreatTime(Date u_CreatTime) {
		U_CreatTime = u_CreatTime;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("U_ID", this.U_ID);
		jo.put("U_NAME", this.U_NAME);
		jo.put("U_INFO", this.U_INFO);
		jo.put("U_ICONPATH", this.U_ICONPATH);
		jo.put("U_STATE", this.U_STATE);
		jo.put("U_ProName", this.U_ProName);
		jo.put("U_CreatTime", this.U_CreatTime);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}

/*
 * 
 * CREATE TABLE `tab_unit` (
  `U_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `U_NAME` varchar(30) NOT NULL,
  `U_INFO` varchar(200) DEFAULT NULL,
  `U_ICONPATH` varchar(100) DEFAULT NULL,
  `U_STATE` char(1) DEFAULT NULL,
  `U_ProName` varchar(100) DEFAULT NULL,
  `U_CreatTime` datetime DEFAULT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;
*/
