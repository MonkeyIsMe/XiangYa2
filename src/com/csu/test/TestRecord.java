package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.RecordDAO;
import com.csu.entity.Record;

public class TestRecord {
	
	RecordDAO rd = new RecordDAO();
	
	@Test
	public void addRecord() {
		Record r = new Record();
		r.setDiagnosisDate("2018-7-27");
		r.setDoctorName("YuJiaxin");
		r.setPatientId(1);
		r.setSysuserId(1);
		r.setTopicId(9);
		rd.addRecord(r);
	}
	
	@Test
	public void updateRecord() {
		Record r = new Record();
		r.setId(43);
		r.setDiagnosisDate("2018-7-27");
		r.setDoctorName("YuJiaxin");
		r.setPatientId(1);
		r.setSysuserId(1);
		r.setTopicId(9);
		r.setRecordDate("2018-7-27");
		r.setRecordName("Test");
		rd.updateRecord(r);
	}

	
	@Test
	public void queryLastRecordByPatientId() {
		int pid = 41;
		Record r = new Record();
		r = rd.queryLastRecordByPatientId(pid);
		System.out.println(r.toString());
	}


	@Test
	public void fetchRecordListByPatientId() {
		int pid = 40;
		ArrayList<Record> record = rd.fetchRecordListByPatientId(pid);
		for(Record r : record) {
			System.out.println(r.toString());
		}
	}
}
