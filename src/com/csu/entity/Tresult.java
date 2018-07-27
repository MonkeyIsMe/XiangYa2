package com.csu.entity;

import java.util.Date;

import org.json.JSONObject;

public class Tresult {
	private int U_ID;
	private int S_ID;
	private int I_ID;
	private Date T_Time;
	private int C_Num;
	private int C_SubNum;
	private int isAudited;
	
	
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public int getS_ID() {
		return S_ID;
	}
	public void setS_ID(int s_ID) {
		S_ID = s_ID;
	}
	public int getI_ID() {
		return I_ID;
	}
	public void setI_ID(int i_ID) {
		I_ID = i_ID;
	}
	public Date getT_Time() {
		return T_Time;
	}
	public void setT_Time(Date t_Time) {
		T_Time = t_Time;
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
	public int getIsAudited() {
		return isAudited;
	}
	public void setIsAudited(int isAudited) {
		this.isAudited = isAudited;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("U_ID", this.U_ID);
		jo.put("I_ID", this.I_ID);
		jo.put("S_ID", this.S_ID);
		jo.put("T_Time", this.T_Time);
		jo.put("C_Num", this.C_Num);
		jo.put("C_SubNum", this.C_SubNum);
		jo.put("isAudited", this.isAudited);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}

/*
CREATE TABLE `tab_tresult` (
`U_ID` int(11) NOT NULL DEFAULT '0',
`S_ID` int(11) NOT NULL DEFAULT '0',
`I_ID` int(11) NOT NULL DEFAULT '0',
`T_Time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
`C_Num` int(11) DEFAULT NULL,
`C_SubNum` int(11) DEFAULT NULL,
`isAudited` int(10) unsigned NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/