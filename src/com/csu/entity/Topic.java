package com.csu.entity;

import org.json.JSONObject;

public class Topic {
	private Integer topicId;
	private String  topicName;//¿ÎÌâÃû
	private Integer builderId;
	
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Integer getBuilderId() {
		return builderId;
	}
	public void setBuilderId(Integer builderId) {
		this.builderId = builderId;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("topicName", this.topicName);
		jo.put("builderId", this.builderId);
		jo.put("topicId", this.topicId);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
