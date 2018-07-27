package com.csu.entity;

import org.json.JSONObject;

public class Options {
	private Integer optionId; 
	private String optionName; //选项名
	private Integer itemId; //项目表ID
	private String remark; //备注
	
	
	public Integer getOptionId() {
		return optionId;
	}
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("optionId", this.optionId);
		jo.put("optionName", this.optionName);
		jo.put("itemId", this.itemId);
		jo.put("remark", this.remark);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}
