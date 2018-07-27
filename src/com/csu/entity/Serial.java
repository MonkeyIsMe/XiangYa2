package com.csu.entity;

import org.json.JSONObject;

public class Serial {
	private int regist;
	private int ans_sum;
	
	
	public int getRegist() {
		return regist;
	}
	public void setRegist(int regist) {
		this.regist = regist;
	}
	public int getAns_sum() {
		return ans_sum;
	}
	public void setAns_sum(int ans_sum) {
		this.ans_sum = ans_sum;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("regist", this.regist);
		jo.put("ans_sum", this.ans_sum);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
}
