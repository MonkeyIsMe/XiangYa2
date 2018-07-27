package com.csu.entity;

import org.json.JSONObject;

public class Reference {
	private int S_ID;
	private int F_Num;
	private int F_Rid;
	private int R_Score1;
	private int R_Score2;
	private String R_Sex;
	private int R_Age1;
	private int R_Age2;
	private String R_Suggestion;
	
	
	public int getS_ID() {
		return S_ID;
	}
	public void setS_ID(int s_ID) {
		S_ID = s_ID;
	}
	public int getF_Num() {
		return F_Num;
	}
	public void setF_Num(int f_Num) {
		F_Num = f_Num;
	}
	public int getF_Rid() {
		return F_Rid;
	}
	public void setF_Rid(int f_Rid) {
		F_Rid = f_Rid;
	}
	public int getR_Score1() {
		return R_Score1;
	}
	public void setR_Score1(int r_Score1) {
		R_Score1 = r_Score1;
	}
	public int getR_Score2() {
		return R_Score2;
	}
	public void setR_Score2(int r_Score2) {
		R_Score2 = r_Score2;
	}
	public String getR_Sex() {
		return R_Sex;
	}
	public void setR_Sex(String r_Sex) {
		R_Sex = r_Sex;
	}
	public int getR_Age1() {
		return R_Age1;
	}
	public void setR_Age1(int r_Age1) {
		R_Age1 = r_Age1;
	}
	public int getR_Age2() {
		return R_Age2;
	}
	public void setR_Age2(int r_Age2) {
		R_Age2 = r_Age2;
	}
	public String getR_Suggestion() {
		return R_Suggestion;
	}
	public void setR_Suggestion(String r_Suggestion) {
		R_Suggestion = r_Suggestion;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("S_ID", this.S_ID);
		jo.put("F_Num", this.F_Num);
		jo.put("F_Rid", this.F_Rid);
		jo.put("R_Score1", this.R_Score1);
		jo.put("R_Score2", this.R_Score2);
		jo.put("R_Sex", this.R_Sex);
		jo.put("R_Age1", this.R_Age1);
		jo.put("R_Suggestion", this.R_Suggestion);
		jo.put("R_Age2", this.R_Age2);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}

/*
CREATE TABLE `tab_refer` (
`S_ID` int(10) unsigned NOT NULL,
`F_Num` int(10) unsigned NOT NULL,
`F_Rid` int(10) unsigned NOT NULL,
`R_Score1` int(10) DEFAULT NULL,
`R_Score2` int(10) DEFAULT NULL,
`R_Sex` varchar(4) DEFAULT NULL,
`R_Age1` int(10) DEFAULT NULL,
`R_Age2` int(10) DEFAULT NULL,
`R_Suggestion` varchar(3000) DEFAULT NULL,
PRIMARY KEY (`S_ID`,`F_Num`,`F_Rid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
*/