package com.csu.test;

import org.junit.Test;

import com.csu.dao.PatientDAO;
import com.csu.entity.PatientInfo;

public class TestPatient {
	
	@Test
	public void addPatient() {
		PatientDAO pd = new PatientDAO();
		PatientInfo pi = new PatientInfo();
		pi.setAdmissionNumber("test");
		pi.setBirthArea("test");
		pi.setBirthday("test");
		pi.setBuilderId("test");
		pi.setFatherBirthArea("test");
		pi.setU_name("test");
		pd.addPatient(pi);
	}
	
	@Test
	public void DeletePatient() {
		int id = 93;
		PatientDAO pd = new PatientDAO();
		pd.DeletePatient(id);
	}
	
	@Test
	public void QueryPatientByUid() {
		int id = 88;
		PatientInfo pi = new PatientInfo();
		PatientDAO pd = new PatientDAO();
		pi = pd.QueryPatientByUid(id);
		System.out.println(pi.toString());
	}
	
	@Test
	public void setTopicPatient() {
		int topicId = 1;
		int uid = 92;
		PatientDAO pd = new PatientDAO();
		pd.setTopicPatient(topicId, uid);
	}
	
	@Test
	public void count() {
		String condition = "124712101";
		int topicId = 1;
		PatientDAO pd = new PatientDAO();
		int count = pd.count(topicId, condition);
		System.out.println(count);
	}
	
	@Test
	public void UpdatePatient() {
		PatientDAO pd = new PatientDAO();
		PatientInfo pi = new PatientInfo();
		pi.setAdmissionNumber("test1312");
		pi.setBirthArea("test1321");
		pi.setBirthday("test1321");
		pi.setBuilderId("test13231");
		pi.setFatherBirthArea("test1321");
		pi.setU_name("test1231");
		pd.UpdatePatient(92,pi);
	}
	
	@Test
	public void searchCount() {
		String condition = "124712101";
		int topicId = 1;
		String pname = "test1231";
		PatientDAO pd = new PatientDAO();
		int count = pd.searchCount(pname, topicId, condition);
		System.out.println(count);
	}
}
