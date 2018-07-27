package com.csu.entity;

import java.util.Date;

import org.json.JSONObject;

public class Comment {
	private int S_ID;
	private int U_ID;
	private Date T_Time;
	private String T_ZFComment;
	private String T_RComment;
	private String T_Comment;
	
	public int getS_ID() {
		return S_ID;
	}
	public void setS_ID(int s_ID) {
		S_ID = s_ID;
	}
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public Date getT_Time() {
		return T_Time;
	}
	public void setT_Time(Date t_Time) {
		T_Time = t_Time;
	}
	public String getT_ZFComment() {
		return T_ZFComment;
	}
	public void setT_ZFComment(String t_ZFComment) {
		T_ZFComment = t_ZFComment;
	}
	public String getT_RComment() {
		return T_RComment;
	}
	public void setT_RComment(String t_RComment) {
		T_RComment = t_RComment;
	}
	public String getT_Comment() {
		return T_Comment;
	}
	public void setT_Comment(String t_Comment) {
		T_Comment = t_Comment;
	}
	
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("S_ID", this.S_ID);
		jo.put("U_ID", this.U_ID);
		jo.put("T_Time", this.T_Time);
		jo.put("T_ZFComment", this.T_ZFComment);
		jo.put("T_RComment", this.T_RComment);
		jo.put("T_Comment", this.T_Comment);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}


/*
 * CREATE TABLE `tab_comments` (
  `S_ID` int(10) unsigned NOT NULL,
  `U_ID` int(10) unsigned NOT NULL,
  `T_Time` datetime NOT NULL,
  `T_ZFComment` varchar(300) DEFAULT NULL,
  `T_RComment` varchar(200) DEFAULT NULL,
  `T_Comment` varchar(15000) DEFAULT NULL,
  PRIMARY KEY (`S_ID`,`U_ID`,`T_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */