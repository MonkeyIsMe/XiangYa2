package com.csu.entity;

import org.json.JSONObject;

public class Record {
	
	private int Id;
	private int patientId; //病人Id
	private String diagnosisDate; //诊断日期
	private String doctorName; //就诊医生
	private String recordName; //登记人
	private String recordDate; //登记日期
	private String r1; //备用1
	private String r2; //备用2
	private int topicId; //
	private String revisitDate;  //
	private int sysuserId; //
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDiagnosisDate() {
		return diagnosisDate;
	}
	public void setDiagnosisDate(String diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getR1() {
		return r1;
	}
	public void setR1(String r1) {
		this.r1 = r1;
	}
	public String getR2() {
		return r2;
	}
	public void setR2(String r2) {
		this.r2 = r2;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getRevisitDate() {
		return revisitDate;
	}
	public void setRevisitDate(String revisitDate) {
		this.revisitDate = revisitDate;
	}
	public int getSysuserId() {
		return sysuserId;
	}
	public void setSysuserId(int sysuserId) {
		this.sysuserId = sysuserId;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("Id", this.Id);
		jo.put("patientId", this.patientId);
		jo.put("diagnosisDate", this.diagnosisDate);
		jo.put("doctorName", this.doctorName);
		jo.put("recordName", this.recordName);
		jo.put("recordDate", this.recordDate);
		jo.put("r1", this.r1);
		jo.put("r2", this.r2);
		jo.put("topicId", this.topicId);
		jo.put("revisitDate", this.revisitDate);
		jo.put("sysuserId", this.sysuserId);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}

	/*
	 * private int Id;
	private int patientId; //病人Id
	private String diagnosisDate; //诊断日期
	private String doctorName; //就诊医生
	private String recordName; //登记人
	private String recordDate; //登记日期
	private String r1; //备用1
	private String r2; //备用2
	private int topicId; //
	private String revisitDate;  //
	private int sysuserId; //
	 */
}
