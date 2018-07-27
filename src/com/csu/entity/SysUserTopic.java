package com.csu.entity;

import org.json.JSONObject;

public class SysUserTopic {
	private int Id;
	private String u_account; //登录的账号
	private int topicId;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("Id", this.Id);
		jo.put("u_account", this.u_account);
		jo.put("topicId", this.topicId);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
 * CREATE TABLE `tab_sysuser_topic` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `u_account` varchar(255) DEFAULT NULL COMMENT '登录的账号',
  `topicId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='系统用户与课题组对应关系表';
*/

