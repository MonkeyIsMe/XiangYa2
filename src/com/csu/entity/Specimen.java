package com.csu.entity;

import org.json.JSONObject;

public class Specimen {
	private int Id;//Primary Key
	private String specimen_name;  //标本名称
	private String specimen_type;  //标本类型
	private String specimen_place; //标本存放位置
	private String specimen_record; //使用记录
	private int specimen_num;       //标本数量
	private String concentration;       //标本浓度
	private int patientId;          //患者ID
	private String desc;            //备注
	private String latestTime;      //最近使用日期
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getSpecimen_name() {
		return specimen_name;
	}
	public void setSpecimen_name(String specimen_name) {
		this.specimen_name = specimen_name;
	}
	public String getSpecimen_type() {
		return specimen_type;
	}
	public void setSpecimen_type(String specimen_type) {
		this.specimen_type = specimen_type;
	}
	public String getSpecimen_place() {
		return specimen_place;
	}
	public void setSpecimen_place(String specimen_place) {
		this.specimen_place = specimen_place;
	}
	public String getSpecimen_record() {
		return specimen_record;
	}
	public void setSpecimen_record(String specimen_record) {
		this.specimen_record = specimen_record;
	}
	public int getSpecimen_num() {
		return specimen_num;
	}
	public void setSpecimen_num(int specimen_num) {
		this.specimen_num = specimen_num;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLatestTime() {
		return latestTime;
	}
	public void setLatestTime(String latestTime) {
		this.latestTime = latestTime;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("Id", this.Id);
		jo.put("specimen_name", this.specimen_name);
		jo.put("specimen_type", this.specimen_type);
		jo.put("specimen_place", this.specimen_place);
		jo.put("specimen_record", this.specimen_record);
		jo.put("specimen_num", this.specimen_num);
		jo.put("concentration", this.concentration);
		jo.put("patientId", this.patientId);
		jo.put("desc", this.desc);
		jo.put("latestTime", this.latestTime);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	/*
	 * private int Id;//Primary Key
	private String specimen_name;  //标本名称
	private String specimen_type;  //标本类型
	private String specimen_place; //标本存放位置
	private String specimen_record; //使用记录
	private int specimen_num;       //标本数量
	private String concentration;       //标本浓度
	private int patientId;          //患者ID
	private String desc;            //备注
	private String latestTime;      //最近使用日期
	 */
}
