package com.csu.entity;

import java.util.Date;

import org.json.JSONObject;

public class MentalScale {
	private int S_ID;
	private String S_Name;
	private String S_Intro;
	private String S_Guide;
	private double S_StdScroe;
	private int S_FullScore;
	private int S_ReportInfo;
	private String S_TYPE2;
	private String S_TYPE3;
	private String S_TYPE4;
	private String S_Remark;
	private int S_UseSum;
	private int S_Value;
	private String S_Formula;
	private int sk_id;
	private String updateTime;
	
	
	public int getS_ID() {
		return S_ID;
	}
	public void setS_ID(int s_ID) {
		S_ID = s_ID;
	}
	public String getS_Name() {
		return S_Name;
	}
	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}
	public String getS_Intro() {
		return S_Intro;
	}
	public void setS_Intro(String s_Intro) {
		S_Intro = s_Intro;
	}
	public String getS_Guide() {
		return S_Guide;
	}
	public void setS_Guide(String s_Guide) {
		S_Guide = s_Guide;
	}
	public double getS_StdScroe() {
		return S_StdScroe;
	}
	public void setS_StdScroe(double s_StdScroe) {
		S_StdScroe = s_StdScroe;
	}
	public int getS_FullScore() {
		return S_FullScore;
	}
	public void setS_FullScore(int s_FullScore) {
		S_FullScore = s_FullScore;
	}
	public int getS_ReportInfo() {
		return S_ReportInfo;
	}
	public void setS_ReportInfo(int s_ReportInfo) {
		S_ReportInfo = s_ReportInfo;
	}
	public String getS_TYPE2() {
		return S_TYPE2;
	}
	public void setS_TYPE2(String s_TYPE2) {
		S_TYPE2 = s_TYPE2;
	}
	public String getS_TYPE3() {
		return S_TYPE3;
	}
	public void setS_TYPE3(String s_TYPE3) {
		S_TYPE3 = s_TYPE3;
	}
	public String getS_TYPE4() {
		return S_TYPE4;
	}
	public void setS_TYPE4(String s_TYPE4) {
		S_TYPE4 = s_TYPE4;
	}
	public String getS_Remark() {
		return S_Remark;
	}
	public void setS_Remark(String s_Remark) {
		S_Remark = s_Remark;
	}
	public int getS_UseSum() {
		return S_UseSum;
	}
	public void setS_UseSum(int s_UseSum) {
		S_UseSum = s_UseSum;
	}
	public int getS_Value() {
		return S_Value;
	}
	public void setS_Value(int s_Value) {
		S_Value = s_Value;
	}
	public String getS_Formula() {
		return S_Formula;
	}
	public void setS_Formula(String s_Formula) {
		S_Formula = s_Formula;
	}
	public int getSk_id() {
		return sk_id;
	}
	public void setSk_id(int sk_id) {
		this.sk_id = sk_id;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("S_ID", this.S_ID);
		jo.put("S_Name", this.S_Name);
		jo.put("S_Intro", this.S_Intro);
		jo.put("S_Guide", this.S_Guide);
		jo.put("S_StdScroe", this.S_StdScroe);
		jo.put("S_FullScore", this.S_FullScore);
		jo.put("S_ReportInfo", this.S_ReportInfo);
		jo.put("S_TYPE2", this.S_TYPE2);
		jo.put("S_TYPE3", this.S_TYPE3);
		jo.put("S_TYPE4", this.S_TYPE4);
		jo.put("S_Remark", this.S_Remark);
		jo.put("S_UseSum", this.S_UseSum);
		jo.put("S_Value", this.S_Value);
		jo.put("S_Formula", this.S_Formula);
		jo.put("sk_id", this.sk_id);
		jo.put("updateTime", this.updateTime);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
 * CREATE TABLE `tab_mentalscale` (
  `S_ID` int(11) NOT NULL AUTO_INCREMENT,
  `S_Name` varchar(100) NOT NULL,
  `S_Intro` varchar(4000) DEFAULT NULL,
  `S_Guide` varchar(500) DEFAULT NULL,
  `S_StdScroe` decimal(4,2) DEFAULT NULL,
  `S_FullScore` int(11) DEFAULT NULL,
  `S_ReportInfo` tinyint(1) DEFAULT NULL,
  `S_TYPE2` char(4) DEFAULT NULL,
  `S_TYPE3` char(4) DEFAULT NULL,
  `S_TYPE4` char(4) DEFAULT NULL,
  `S_Remark` varchar(100) DEFAULT NULL,
  `S_UseSum` int(10) unsigned DEFAULT '0',
  `S_Value` int(10) unsigned DEFAULT '0',
  `S_Formula` varchar(50) NOT NULL,
  `sk_id` int(10) unsigned DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`S_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2317 DEFAULT CHARSET=gbk;

 * 
 */
