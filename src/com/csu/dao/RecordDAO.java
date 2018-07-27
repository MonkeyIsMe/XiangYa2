package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Record;
import com.csu.utils.JDBCUtil;

public class RecordDAO {
	//增加记录
	public boolean addRecord(Record r){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_record(patientId,diagnosisDate,doctorName,recordName,recordDate,r1,r2,topicId,revisitDate,sysuserId)" +
				"values(?,?,?,?,?,?,?,?,?,?)";
		//boolean flag = false;
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, r.getPatientId());
			stmt.setString(2, r.getDiagnosisDate());
			stmt.setString(3, r.getDoctorName());
			stmt.setString(4, r.getRecordName());
			stmt.setString(5, r.getRecordDate());
			stmt.setString(6, r.getR1());
			stmt.setString(7, r.getR2());
			stmt.setInt(8, r.getTopicId());
			stmt.setString(9, r.getRevisitDate());
			stmt.setInt(10, r.getSysuserId());
			stmt.execute();
			//System.out.println(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//删除记录
	public boolean deleteRecordById(int id){
		Connection conn = JDBCUtil.getConnection();
		String sql ="delete from tab_record where id=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//更新记录
	public boolean updateRecord(Record record){
		Connection conn = JDBCUtil.getConnection();
		String sql ="update tab_record set patientId=?,diagnosisDate=?,doctorName=?,recordName=?,recordDate=?,r1=?,r2=? where id=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, record.getPatientId());
			stmt.setString(2, record.getDiagnosisDate());
			stmt.setString(3, record.getDoctorName());
			stmt.setString(4, record.getRecordName());
			stmt.setString(5, record.getRecordDate());
			stmt.setString(6, record.getR1());
			stmt.setString(7, record.getR2());
			stmt.setInt(8, record.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//根据id查得一条记录
	public Record queryRecordById(int id){
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from tab_record where id=?";
		Record record = new Record();
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				record.setDiagnosisDate(rs.getString("diagnosisDate"));
				record.setDoctorName(rs.getString("doctorName"));
				record.setId(rs.getInt("Id"));
				record.setPatientId(rs.getInt("patientId"));
				record.setR1(rs.getString("r1"));
				record.setR2(rs.getString("r2"));
				record.setRecordDate(rs.getString("recordDate"));
				record.setRecordName(rs.getString("recordName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return record;
	}
	
	
	//根据patientId查到多天记录
	public ArrayList<Record>fetchRecordListByPatientId(int patientId){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Record> recordList = new ArrayList<Record>();
		String sql = "select * from tab_record where patientId=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, patientId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Record record = new Record();
				record.setDiagnosisDate(rs.getString("diagnosisDate"));
				record.setDoctorName(rs.getString("doctorName"));
				record.setId(rs.getInt("Id"));
				record.setPatientId(rs.getInt("patientId"));
				record.setR1(rs.getString("r1"));
				record.setR2(rs.getString("r2"));
				record.setRecordDate(rs.getString("recordDate"));
				record.setRecordName(rs.getString("recordName"));
				record.setTopicId(rs.getInt("topicId"));
				record.setRevisitDate(rs.getString("revisitDate"));
				
				recordList.add(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return recordList;
	}
	
	
	//根据病人id查找记录信息
	public Record queryLastRecordByPatientId(int patientid){
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from tab_record where patientId=?";
		Record record = new Record();
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, patientid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				record.setId(rs.getInt("Id"));
				record.setPatientId(rs.getInt("patientId"));
				record.setDiagnosisDate(rs.getString("diagnosisDate"));
				record.setDoctorName(rs.getString("doctorName"));
				record.setRecordName(rs.getString("recordName"));
				record.setRecordDate(rs.getString("recordDate"));
				record.setR1(rs.getString("r1"));
				record.setR2(rs.getString("r2"));
				record.setRecordDate(rs.getString("topicId"));
				record.setRecordName(rs.getString("revisitDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}
}

//PreparedStatement stmt= conn.prepareStatement(sql);