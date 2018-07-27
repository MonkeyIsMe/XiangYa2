package com.csu.entity;

import org.json.JSONObject;

public class DiagType {
	private Integer diagTypeId;
	private String diagTypeName;
	private Integer diagRuleId;
	private String diagTypeIntroduction;
	
	
	public Integer getDiagTypeId() {
		return diagTypeId;
	}
	public void setDiagTypeId(Integer diagTypeId) {
		this.diagTypeId = diagTypeId;
	}
	public String getDiagTypeName() {
		return diagTypeName;
	}
	public void setDiagTypeName(String diagTypeName) {
		this.diagTypeName = diagTypeName;
	}
	public Integer getDiagRuleId() {
		return diagRuleId;
	}
	public void setDiagRuleId(Integer diagRuleId) {
		this.diagRuleId = diagRuleId;
	}
	public String getDiagTypeIntroduction() {
		return diagTypeIntroduction;
	}
	public void setDiagTypeIntroduction(String diagTypeIntroduction) {
		this.diagTypeIntroduction = diagTypeIntroduction;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("diagRuleId", this.diagRuleId);
		jo.put("diagTypeId", this.diagTypeId);
		jo.put("diagTypeName", this.diagTypeName);
		jo.put("diagTypeIntroduction", this.diagTypeIntroduction);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}
