package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.ClientInfoDAO;
import com.csu.entity.PatientInfo;

public class TestClientInfo {
	
	@Test
	public void searchCount() {
		String pname = "·½·¼·¼";
		ClientInfoDAO cid = new ClientInfoDAO();
		int ans = cid.searchCount(pname);
		System.out.println(ans);
	}
	
	@Test
	public void count() {
		ClientInfoDAO cid = new ClientInfoDAO();
		System.out.println(cid.count());
	}
	
	@Test
	public void SelectClientInfoByName() {
		ClientInfoDAO cid = new ClientInfoDAO();
		int i = 0;
		int pageSize = 2;
		String pname = "·½·¼·¼";
		ArrayList<PatientInfo> pi = cid.SelectClientInfoByName(i, pageSize, pname);
		for(PatientInfo pid :pi) {
			System.out.println(pid.toString());
		}
		
	}
}
