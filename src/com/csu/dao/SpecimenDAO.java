package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.csu.entity.Specimen;
import com.csu.utils.JDBCUtil;

public class SpecimenDAO {
	
	//添加一个标本
	public boolean addSpecimen(Specimen specimen){
		Connection conn = JDBCUtil.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String latestTime = sdf.format(new Date());
		String sql = "insert into tab_specimen(specimen_name,specimen_type,specimen_place,specimen_num,concentration,latestTime,description,patientId) " +
    			"values('"+specimen.getSpecimen_name()+"','"+specimen.getSpecimen_type()+"','"+specimen.getSpecimen_place()+"','"+specimen.getSpecimen_num()+"','"+specimen.getConcentration()+"','"+latestTime+"','"+specimen.getDesc()+"','"+specimen.getPatientId()+"')";
    	System.out.println(sql);
    	try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	return true;
	}
	
	//查询一个病人所有标本
	public ArrayList<Specimen> getSpecimenByUid(int pid){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Specimen> specimenList = new ArrayList<Specimen>();
		String sql = "select * from tab_specimen where patientId ="+pid;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
    			Specimen specimen = new Specimen();
    			specimen.setId(rs.getInt("Id"));
    			specimen.setSpecimen_name(rs.getString("Specimen_name"));
    			specimen.setSpecimen_type(rs.getString("Specimen_type"));
    			specimen.setSpecimen_place(rs.getString("Specimen_place"));
    			specimen.setConcentration(rs.getString("Concentration"));
    			specimen.setSpecimen_num(rs.getInt("Specimen_num"));
    			specimen.setLatestTime(rs.getString("LatestTime"));
    			specimen.setDesc(rs.getString("description"));
    			specimenList.add(specimen);   			
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return specimenList;
		
	}
	
	//获得一个标本信息
	 public Specimen getSpecimenInfo(int id){
		Connection conn = JDBCUtil.getConnection();
		Specimen specimen = new Specimen();
		String sql ="select * from tab_specimen where id="+id;
    	System.out.println(sql);
    	PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
        	    specimen.setId(rs.getInt("Id"));
   				specimen.setSpecimen_name(rs.getString("Specimen_name"));
   				specimen.setSpecimen_type(rs.getString("Specimen_type"));
   				specimen.setSpecimen_place(rs.getString("Specimen_place"));
   				specimen.setConcentration(rs.getString("Concentration"));
   				specimen.setSpecimen_num(rs.getInt("Specimen_num"));
   				specimen.setLatestTime(rs.getString("LatestTime"));
   				specimen.setDesc(rs.getString("description"));
           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return specimen;
		 
	 }
	 
	 //更新一个标本信息
	 public boolean editSpecimenInfo(Specimen specimen){
		Connection conn = JDBCUtil.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String latestTime = sdf.format(new Date());
    	String sql = "update tab_specimen set Specimen_name='"+specimen.getSpecimen_name()+"',Specimen_type='"+specimen.getSpecimen_type()+"',Specimen_place='"+specimen.getSpecimen_place()+"',Concentration='"+specimen.getConcentration()+"'," +
    			"Specimen_num='"+specimen.getSpecimen_num()+"',LatestTime='"+latestTime+"',description='"+specimen.getDesc()+"' where id="+specimen.getId();
    	System.out.println(sql);
    	PreparedStatement stmt;
    	try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	return true;
	 }
	 
	 //删除一个标本信息
	 public boolean deleteSpecimen(int sid){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_specimen where id ="+sid;
    	System.out.println(sql);
    	PreparedStatement stmt;
    	try {
			stmt = conn.prepareStatement(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	 }
}
