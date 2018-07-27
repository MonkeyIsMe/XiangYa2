package com.csu.entity;

import org.json.JSONObject;

public class DiagClass {
	private Integer diagClassId;
	private String diagClassName;
	private Integer diagNameId;
	
	
	public Integer getDiagClassId() {
		return diagClassId;
	}
	public void setDiagClassId(Integer diagClassId) {
		this.diagClassId = diagClassId;
	}
	public String getDiagClassName() {
		return diagClassName;
	}
	public void setDiagClassName(String diagClassName) {
		this.diagClassName = diagClassName;
	}
	public Integer getDiagNameId() {
		return diagNameId;
	}
	public void setDiagNameId(Integer diagNameId) {
		this.diagNameId = diagNameId;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("diagClassId", this.diagClassId);
		jo.put("diagClassName", this.diagClassName);
		jo.put("diagNameId", this.diagNameId);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}
