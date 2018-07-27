package com.csu.entity;

import org.json.JSONObject;

public class DiagName {
	private Integer diagNameId;
	private String diagName;
	private Integer diagTypeId;
	private String diagDefine;
	private String diagPoint;
	public Integer getDiagNameId() {
		return diagNameId;
	}
	public void setDiagNameId(Integer diagNameId) {
		this.diagNameId = diagNameId;
	}
	public String getDiagName() {
		return diagName;
	}
	public void setDiagName(String diagName) {
		this.diagName = diagName;
	}
	public Integer getDiagTypeId() {
		return diagTypeId;
	}
	public void setDiagTypeId(Integer diagTypeId) {
		this.diagTypeId = diagTypeId;
	}
	public String getDiagDefine() {
		return diagDefine;
	}
	public void setDiagDefine(String diagDefine) {
		this.diagDefine = diagDefine;
	}
	public String getDiagPoint() {
		return diagPoint;
	}
	public void setDiagPoint(String diagPoint) {
		this.diagPoint = diagPoint;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("diagNameId", this.diagNameId);
		jo.put("diagName", this.diagName);
		jo.put("diagTypeId", this.diagTypeId);
		jo.put("diagDefine", this.diagDefine);
		jo.put("diagPoint", this.diagPoint);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	/*
	 * private Integer diagNameId;
	private String diagName;
	private Integer diagTypeId;
	private String diagDefine;
	private String diagPoint;
	 */
}
