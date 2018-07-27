package com.csu.entity;

import org.json.JSONObject;

public class Choice2 {
	private int I_ID;
	private int C_Num; //答案编号
	private int C_SubNum;
	private String C_Content; //答案内容
	private int C_Score; //分值
	
	public int getI_ID() {
		return I_ID;
	}
	public void setI_ID(int i_ID) {
		I_ID = i_ID;
	}
	public int getC_Num() {
		return C_Num;
	}
	public void setC_Num(int c_Num) {
		C_Num = c_Num;
	}
	public int getC_SubNum() {
		return C_SubNum;
	}
	public void setC_SubNum(int c_SubNum) {
		C_SubNum = c_SubNum;
	}
	public String getC_Content() {
		return C_Content;
	}
	public void setC_Content(String c_Content) {
		C_Content = c_Content;
	}
	public int getC_Score() {
		return C_Score;
	}
	public void setC_Score(int c_Score) {
		C_Score = c_Score;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("I_ID", this.I_ID);
		jo.put("C_Num", this.C_Num);
		jo.put("C_SubNum", this.C_SubNum);
		jo.put("C_Content", this.C_Content);
		jo.put("C_Score", this.C_Score);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
}

/*
 * 
 * CREATE TABLE `tab_choice2` (
  `I_ID` int(11) NOT NULL,
  `C_Num` int(11) NOT NULL,
  `C_SubNum` int(11) NOT NULL,
  `C_Content` varchar(5000) DEFAULT NULL,
  `C_Score` int(11) DEFAULT NULL,
  PRIMARY KEY (`I_ID`,`C_Num`,`C_SubNum`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
 * */
