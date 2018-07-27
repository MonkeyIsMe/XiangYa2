package com.csu.entity;

import org.json.JSONObject;

//测试结果表：该表主要用于保存患者每一次心理测评的结果，具体字段信息
public class Result {
	private Integer id; 
	private Integer recordId; //诊断记录Id
	private Integer itemId; //项目id
	private String result; //结果
	private String introduction; //说明
	private String remark; //备注
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;                                        
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("id", this.id);
		jo.put("recordId", this.recordId);
		jo.put("itemId", this.itemId);
		jo.put("result", this.result);
		jo.put("introduction", this.introduction);
		jo.put("remark", this.remark);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
	/*
	 * private Integer id; 
	private Integer recordId; //诊断记录Id
	private Integer itemId; //项目id
	private String result; //结果
	private String introduction; //说明
	private String remark; //备注
	 */
}
