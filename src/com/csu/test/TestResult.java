package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.ResultDAO;
import com.csu.entity.Result;

public class TestResult {
	
	@Test
	public void addResult() {
		Result re = new Result();
		ResultDAO rd = new ResultDAO();
		re.setIntroduction("test");
		re.setRecordId(123);
		re.setResult("no result");
		re.setRemark("no remark");
		re.setItemId(14);
		rd.addResult(re);
	}
	
	@Test
	public void queryResultsByRecordId() {
		ResultDAO rd = new ResultDAO();
		int rid = 34;
		ArrayList<Result> result = rd.queryResultsByRecordId(rid);
		for(Result re : result) {
			System.out.println(re.toString());
		}
	}
}
