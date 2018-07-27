package com.csu.entity;

import java.util.Date;

import org.json.JSONObject;


public class PatientInfo {
	private int u_id;
	private String u_name;
	private String identity; //身份证
	private String patientId; //患者编号
	private String admissionNumber; //住院号，门诊号
	private String testNumber; //受试编号
	private String gender;//性别
	//private int age;//
	private String nation;//名族
	private String birthday;//出生年月
	private String birthArea;//出生地
	private String isAdopted;//是否被领养
	private String motherBirthArea;//亲生母亲出生地
	private String motherNation;//亲生母亲名族
	private String fatherBirthArea;//亲生父亲出生地
	private String fatherNation;//亲生父亲名族
	private String hand;//左右利手
	private String relationship=null; //与先证者的关系
	private String preName=null; //先证者姓名
	private String growthArea; //幼年在何处长大
	private String builderId;  //创建者Id
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getAdmissionNumber() {
		return admissionNumber;
	}
	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}
	public String getTestNumber() {
		return testNumber;
	}
	public void setTestNumber(String testNumber) {
		this.testNumber = testNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthArea() {
		return birthArea;
	}
	public void setBirthArea(String birthArea) {
		this.birthArea = birthArea;
	}
	public String getIsAdopted() {
		return isAdopted;
	}
	public void setIsAdopted(String isAdopted) {
		this.isAdopted = isAdopted;
	}
	public String getMotherBirthArea() {
		return motherBirthArea;
	}
	public void setMotherBirthArea(String motherBirthArea) {
		this.motherBirthArea = motherBirthArea;
	}
	public String getMotherNation() {
		return motherNation;
	}
	public void setMotherNation(String motherNation) {
		this.motherNation = motherNation;
	}
	public String getFatherBirthArea() {
		return fatherBirthArea;
	}
	public void setFatherBirthArea(String fatherBirthArea) {
		this.fatherBirthArea = fatherBirthArea;
	}
	public String getFatherNation() {
		return fatherNation;
	}
	public void setFatherNation(String fatherNation) {
		this.fatherNation = fatherNation;
	}
	public String getHand() {
		return hand;
	}
	public void setHand(String hand) {
		this.hand = hand;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getPreName() {
		return preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public String getGrowthArea() {
		return growthArea;
	}
	public void setGrowthArea(String growthArea) {
		this.growthArea = growthArea;
	}
	public String getBuilderId() {
		return builderId;
	}
	public void setBuilderId(String builderId) {
		this.builderId = builderId;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("u_id", this.u_id);
		jo.put("u_name", this.u_name);
		jo.put("identity", this.identity);
		jo.put("patientId", this.patientId);
		jo.put("admissionNumber", this.admissionNumber);
		jo.put("testNumber", this.testNumber);
		jo.put("gender", this.gender);
		jo.put("nation", this.nation);
		jo.put("birthday", this.birthday);
		jo.put("birthArea", this.birthArea);
		jo.put("isAdopted", this.isAdopted);
		jo.put("motherBirthArea", this.motherBirthArea);
		jo.put("motherNation", this.motherNation);
		jo.put("fatherBirthArea", this.fatherBirthArea);
		jo.put("fatherNation", this.fatherNation);
		jo.put("hand", this.hand);
		jo.put("relationship", this.relationship);
		jo.put("preName", this.preName);
		jo.put("growthArea", this.growthArea);
		jo.put("builderId", this.builderId);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	/*
	 * private int u_id;
	private String u_name;
	private String identity; //身份证
	private String patientId; //患者编号
	private String admissionNumber; //住院号，门诊号
	private String testNumber; //受试编号
	private String gender;//性别
	//private int age;//
	private String nation;//名族
	private String birthday;//出生年月
	private String birthArea;//出生地
	private String isAdopted;//是否被领养
	private String motherBirthArea;//亲生母亲出生地
	private String motherNation;//亲生母亲名族
	private String fatherBirthArea;//亲生父亲出生地
	private String fatherNation;//亲生父亲名族
	private String hand;//左右利手
	private String relationship=null; //与先证者的关系
	private String preName=null; //先证者姓名
	private String growthArea; //幼年在何处长大
	private String builderId;  //创建者Id
	 */
}
