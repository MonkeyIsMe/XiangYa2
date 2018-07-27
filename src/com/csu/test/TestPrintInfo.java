package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.PrintInforDAO;
import com.csu.entity.Factor;
import com.csu.entity.PatientInfo;
import com.csu.entity.SysUser;

public class TestPrintInfo {
	PrintInforDAO pid = new PrintInforDAO();
	
	@Test
	public void getPatientInfo() {
		int u_id = 27;
		PatientInfo pi = pid.getPatientInfo(u_id);
		System.out.println(pi.toString());
	}
	
	
	@Test
	public void getFactor() {
		String s_id = "8";
		ArrayList<Factor> factor = pid.getFactor(s_id);
		for(Factor fa : factor) {
			System.out.println(fa.toString());
		}
	}
	
	@Test
	public void getReportInfo() {
		String s_id = "6";
		ArrayList list = pid.getReportInfo(s_id);
		for(int i = 0; i < list.size(); i++ ) {
			System.out.println(list.get(i).toString());
		}
	}
	
	@Test
	public void getU_iconpath() {
		ArrayList list = pid.getU_iconpath();
		for(int i = 0; i < list.size(); i++ ) {
			System.out.println(list.get(i).toString());
		}
	}
}
