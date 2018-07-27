package com.csu.test;
 
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.csu.dao.AssayDAO;
import com.csu.dao.KindManageDAO;
import com.csu.dao.PatientDAO;
import com.csu.dao.RecordDAO;
import com.csu.dao.ScaleEditDAO;
import com.csu.dao.SpecimenDAO;
import com.csu.entity.Assay;
import com.csu.entity.Fkind;
import com.csu.entity.MentalScale;
import com.csu.entity.PatientInfo;
import com.csu.entity.Record;
import com.csu.entity.Specimen;
import com.csu.utils.JDBCUtil;
import com.mysql.fabric.xmlrpc.base.Array;
//This is a test
public class TestAssay {
 
	@Test
	public void getAllAssay() {
		ArrayList<Assay> al = new ArrayList<>();
		AssayDAO ad = new AssayDAO();
		int userid = 49;
		al = ad.getAllAssay(userid);
		for(Assay as : al) {
		System.out.println(as.toString());
		}
	}
	
	@Test
	public void addAssay() {
		Assay assay = new Assay();
		AssayDAO ad = new AssayDAO();
		assay.setAssayDate("2018-7-24");
		assay.setBloodPressure("test");
		assay.setBmi("test");
		assay.setFPGlucose("test");
		int userid = 46;
		ad.addAssay(assay, userid);
	}
	
	@Test
	public void editAssayInfo() {
		Assay assay = new Assay();
		AssayDAO ad = new AssayDAO();
		assay.setAssayDate("2018-7-24");
		assay.setBloodPressure("test");
		assay.setBmi("test");
		assay.setFPGlucose("test");
		ad.editAssayInfo(assay,22);
	}
	
	@Test
	public void deleteAssay() {
		int id = 23;
		AssayDAO ad = new AssayDAO();
		ad.deleteAssay(id);
	}
	
	@Test
	public void getAssayInfo() {
		int id = 9;
		AssayDAO ad = new AssayDAO();
		Assay assay = ad.getAssayInfo(id);
		System.out.println(assay.toString());
	}
}

