package com.csu.entity;

import org.json.JSONObject;

//题目选项表：该表主要用于存储每一个题目的选项
public class Choice {
	private int I_ID; //对应的题目编号
	private int C_Num; //选项编号
	private String C_Content; //选项内容
	private int C_Score; //选项分值
	private String C_SubChoice; //子选项
	
	
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
	public String getC_SubChoice() {
		return C_SubChoice;
	}
	public void setC_SubChoice(String c_SubChoice) {
		C_SubChoice = c_SubChoice;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("I_ID", this.I_ID);
		jo.put("C_Num", this.C_Num);
		jo.put("C_Content", this.C_Content);
		jo.put("C_Score", this.C_Score);
		jo.put("C_SubChoice", this.C_SubChoice);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
	
}


/*
 * private int I_ID; //对应的题目编号
	private int C_Num; //选项编号
	private String C_Content; //选项内容
	private int C_Score; //选项分值
	private String C_SubChoice; //子选项
 */
/*
CREATE TABLE `tab_choice` (
`I_ID` int(11) NOT NULL,
`C_Num` int(11) NOT NULL,
`C_Content` varchar(5000) DEFAULT NULL,
`C_Score` int(11) DEFAULT NULL,
`C_SubChoice` char(1) DEFAULT NULL,
PRIMARY KEY (`I_ID`,`C_Num`),
CONSTRAINT `FK_TAB_CHOI_REFERENCE_TAB_SCAL` FOREIGN KEY (`I_ID`) REFERENCES `tab_scaleitem` (`I_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
*/