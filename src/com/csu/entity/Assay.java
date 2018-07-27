package com.csu.entity;

import org.json.JSONObject;

//�����ٴ�������ñ���Ҫ���ڱ��滼�ߵĸ���ָ�꣬ÿһ���һ����������
public class Assay {
	
	private String twoHourGlucose;  //������СʱѪ��
	private String ftriglycerides;  //�ո���������
	private String hdLipoprotein;  //���ܶ�֬����
	private String bmi;            //���أ����/��ߣ��ף�
	private String assayDate;
	private int UserID; //��Ӧ�Ļ���ID
	private int Id;
	private String FPGlucose; //�ո�Ѫ��
	private String BloodPressure; //Ѫѹ
	
	
	public String getTwoHourGlucose() {
		return twoHourGlucose;
	}
	public void setTwoHourGlucose(String twoHourGlucose) {
		this.twoHourGlucose = twoHourGlucose;
	}
	public String getFtriglycerides() {
		return ftriglycerides;
	}
	public void setFtriglycerides(String ftriglycerides) {
		this.ftriglycerides = ftriglycerides;
	}
	public String getHdLipoprotein() {
		return hdLipoprotein;
	}
	public void setHdLipoprotein(String hdLipoprotein) {
		this.hdLipoprotein = hdLipoprotein;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getAssayDate() {
		return assayDate;
	}
	public void setAssayDate(String assayDate) {
		this.assayDate = assayDate;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFPGlucose() {
		return FPGlucose;
	}
	public void setFPGlucose(String fPGlucose) {
		FPGlucose = fPGlucose;
	}
	public String getBloodPressure() {
		return BloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		BloodPressure = bloodPressure;
	}
	   
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("Id", this.Id);
		jo.put("twoHourGlucose", this.twoHourGlucose);
		jo.put("ftriglycerides", this.ftriglycerides);
		jo.put("hdLipoprotein", this.hdLipoprotein);
		jo.put("assayDate", this.assayDate);
		jo.put("bmi", this.bmi);
		jo.put("UserID", this.UserID);
		jo.put("FPGlucose", this.FPGlucose);
		jo.put("BloodPressure", this.BloodPressure);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	   
	/*
	 * private String twoHourGlucose;  //������СʱѪ��
	private String ftriglycerides;  //�ո���������
	private String hdLipoprotein;  //���ܶ�֬����
	private String bmi;            //���أ����/��ߣ��ף�
	private String assayDate;
	private int UserID; //��Ӧ�Ļ���ID
	private int Id;
	private String FPGlucose; //�ո�Ѫ��
	private String BloodPressure; //Ѫѹ
	 */
	   
}
