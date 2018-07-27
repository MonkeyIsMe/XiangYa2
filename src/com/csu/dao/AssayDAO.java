package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Assay;
import com.csu.utils.JDBCUtil;

public class AssayDAO {
	
	//根据userid查询试验报告
	public ArrayList<Assay> getAllAssay(int userid){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Assay> al = new ArrayList<Assay>();
		String sql = "select * from tab_assay where UserId="+userid;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
	        while(rs.next()){
	        	Assay assay = new Assay();
	            assay.setId(rs.getInt("Id"));
	       	    assay.setFPGlucose(rs.getString("FPGlucose"));
	       	    assay.setTwoHourGlucose(rs.getString("TwoHourGlucose"));
	      	    assay.setFtriglycerides(rs.getString("Ftriglycerides"));
	       	    assay.setHdLipoprotein(rs.getString("HDLipoprotein"));
	       	    assay.setBmi(rs.getString("BMI"));
	       	    assay.setBloodPressure(rs.getString("BloodPressure"));
	       	    assay.setAssayDate(rs.getString("assayDate"));
        	    al.add(assay);
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	//添加一份试验报告
	public boolean addAssay(Assay assay,int userid){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_assay(FpGlucose,TwoHourGlucose,Ftriglycerides,HdLipoprotein,BMI,BloodPressure,assayDate,UserId)" +
    			" values('"+assay.getFPGlucose()+"','"+assay.getTwoHourGlucose()+"','"+assay.getFtriglycerides()+"','"+assay.getHdLipoprotein()+"','"+assay.getBmi()+"','"+assay.getBloodPressure()+"','"+assay.getAssayDate()+"','"+userid+"')";
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
	
	//修改一份试验报告
	 public boolean editAssayInfo(Assay assay,int id){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "update tab_assay set FpGlucose='"+assay.getFPGlucose()+"',TwoHourGlucose='"+assay.getTwoHourGlucose()+"',Ftriglycerides='"+assay.getFtriglycerides()+"',HdLipoprotein='"+assay.getHdLipoprotein()+"'," +
	    			"BMI='"+assay.getBmi()+"',BloodPressure='"+assay.getBloodPressure()+"',assayDate='"+assay.getAssayDate()+"' where id="+id;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 return true;
	 }
	 
	//删除一份试验报告
	 public boolean deleteAssay(int id){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "delete from tab_assay where id ="+id;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 return true;
	 }
	//通过id查询试验报告
	 public Assay getAssayInfo(int id){
		 Connection conn = JDBCUtil.getConnection();
		 Assay assay = new Assay();
		 String sql ="select * from tab_assay where id="+id;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
	        	   assay.setId(rs.getInt("id"));
	        	   assay.setFPGlucose(rs.getString("FpGlucose"));
	        	   assay.setTwoHourGlucose(rs.getString("TwoHourGlucose"));
	        	   assay.setFtriglycerides(rs.getString("Ftriglycerides"));
	        	   assay.setHdLipoprotein(rs.getString("HdLipoprotein"));
	        	   assay.setBmi(rs.getString("BMI"));
	        	   assay.setBloodPressure(rs.getString("BloodPressure"));
	        	   assay.setAssayDate(rs.getString("assayDate"));
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return assay;
	 }
}
