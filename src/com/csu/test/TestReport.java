package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.ReportDAO;
import com.csu.entity.Report;

public class TestReport {
	
	ReportDAO rd = new ReportDAO();
	
	
	@Test
	public void deleteReport() {
		int id = 1139;
		boolean flag = rd.deleteReport(id);
		System.out.println(flag);
	}
	
	
	@Test
	public void count() {
		int ans = rd.count();
		System.out.println(ans);
	}
	
	@Test
	public void getDateCount() {
		String sdate = "2015-03-04 12:32:36";
		String edate = "2015-05-10 12:57:03";
		int count = rd.getDateCount(sdate, edate);
		System.out.println(count);
	}
	
	@Test
	public void getRecordCount() {
		int cnt = 1;
		String txt = "·½·¼·¼";
		int count = rd.getRecordCount(cnt, txt);
		System.out.println(count);
	}


	@Test
	public void queryReportByPage() {
		int i = 0;
		int page = 5;
		ArrayList<Report> list = rd.queryReportByPage(i, page);
		for(Report re : list) {
			System.out.println(re.toString());
		}
	}
	
	@Test
	public void queryByDate() {
		String sdate = "2015-03-04 12:32:36";
		String edate = "2015-05-10 12:57:03";
		int i = 0;
		int pageSize = 8;
		ArrayList<Report> list = rd.queryByDate(sdate, edate, i, pageSize);
		for(Report re : list) {
			System.out.println(re.toString());
		}
	}

}
