package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Report;

import com.csu.utils.JDBCUtil;

public class ReportDAO {
	
	//删除一个报告
	public boolean deleteReport(int reportId){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_report where id="+reportId;
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
	
	//获得两个时间之间的报告数目
	public int getDateCount(String sdate,String edate){
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from tab_report where t_time between '"+sdate+"' AND '"+edate +"'";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
	   		 if(rs.next()){
	   			 count = rs.getInt("count(*)");
	   		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//查询报告的全部数目
	public int count() {
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		String sql = "select count(*) from tab_report order by id asc";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();//游标指向第一行  
            count = rs.getInt(1);//取得总行数  
            rs.close() ;  
            stmt.close() ;  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//根据id 或者  量表名 或者 患者姓名 查询记录的数目
	public int getRecordCount(int condition,String text){
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		String[] columnNames = {"U_ID", "U_NAME", "S_NAME"};
		String sql = "";
		if (condition == 0) {	   
  		    sql = "select count(*) from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " = " + "'" + text + "')"; 		     
     	 } else if(condition == 1){
     		sql = "select count(*) from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " LIKE " + "'" + text + "%')"; 		     
     	 } else { 	          
  	        sql = "select count(*) from tab_report where S_ID IN (select S_ID from tab_mentalscale where " + columnNames[condition] + " LIKE " + "'" + text + "%')"; 	           
     	 }
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
   			 count = rs.getInt("count(*)");
   		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//分页查询所有的报告信息
	public ArrayList<Report> queryReportByPage(int i,int pageSize){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Report> al = new ArrayList<Report>();
		String sql = "select * from tab_report order by t_time desc limit " + i + "," + pageSize;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Report ri = new Report();
			int reportId = rs.getInt("id");
			int uid = rs.getInt("u_id");
			int sid = rs.getInt("s_id");
			String datetime = rs.getString("t_time");
			
			ri.setT_time(datetime);
			ri.setId(reportId);
			ri.setS_id(sid);
			ri.setU_id(uid);
			
			String sql1 = "select u_name from tab_patientinfo where u_id="+uid;
			System.out.println(sql1);
			
			String sql2 = "select s_name from tab_mentalscale where s_id="+sid;
			System.out.println(sql2);
			
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			ResultSet rs1 = stmt1.executeQuery();
			ResultSet rs2 = stmt2.executeQuery();
			
			if(rs1.next()){
				 ri.setUname(rs1.getString("u_name"));
			 }
			 
			 if(rs2.next()){
				 ri.setSname(rs2.getString("s_name"));
			 }
			 
			 al.add(ri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	//按日期分页查询报告信息
	public ArrayList<Report> queryByDate(String sdate,String edate,int i,int pageSize){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Report> al = new ArrayList<Report>();
		String sql = "select * from tab_report where t_time between '"+sdate+"' AND '"+edate +"' order by t_time desc limit " + i + "," + pageSize;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Report ri = new Report();
			
			int reportId = rs.getInt("id");
			int uid = rs.getInt("u_id");
			int sid = rs.getInt("s_id");
			String datetime = rs.getString("t_time");
			
			ri.setT_time(datetime);
			ri.setId(reportId);
			ri.setS_id(sid);
			ri.setU_id(uid);
			
			String sql1 = "select u_name from tab_patientinfo where u_id="+uid;
			System.out.println(sql1);
			
			String sql2 = "select s_name from tab_mentalscale where s_id="+sid;
			System.out.println(sql2);
			
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			ResultSet rs1 = stmt1.executeQuery();
			ResultSet rs2 = stmt2.executeQuery();
			
			if(rs1.next()){
				 ri.setUname(rs1.getString("u_name"));
			 }
			 
			 if(rs2.next()){
				 ri.setSname(rs2.getString("s_name"));
			 }
			 
			 al.add(ri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	//通过不同id条件 分页查询 报告信息
	 public ArrayList<Report> queryByCondition(int condition,String text,int i,int pageSize){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Report> al = new ArrayList<Report>();
		 String[] columnNames = {"U_ID", "U_NAME", "S_NAME"};
		 String sql = "";
		 if (condition == 0) {
			 sql = "select * from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " = " + "'" + text + "') order by t_time desc limit " + i + "," + pageSize;
		 }
		 else if(condition == 1){
			 sql = "select * from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " LIKE " + "'" + text + "%') order by t_time desc limit " + i + "," + pageSize;
		 }
		 else {
			 sql = "select * from tab_report where S_ID IN (select S_ID from tab_mentalscale where " + columnNames[condition] + " LIKE " + "'" + text + "%') order by t_time desc limit " + i + "," + pageSize;
		 }
		 System.out.println(sql);
		 try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Report ri = new Report();
				
				int reportId = rs.getInt("id");
				int uid = rs.getInt("u_id");
				int sid = rs.getInt("s_id");
				String datetime = rs.getString("t_time");
				
				ri.setT_time(datetime);
				ri.setId(reportId);
				ri.setS_id(sid);
				ri.setU_id(uid);
				
				String sql1 = "select u_name from tab_patientinfo where u_id="+uid;
				System.out.println(sql1);
				
				String sql2 = "select s_name from tab_mentalscale where s_id="+sid;
				System.out.println(sql2);
				
				PreparedStatement stmt1 = conn.prepareStatement(sql1);
				PreparedStatement stmt2 = conn.prepareStatement(sql2);
				ResultSet rs1 = stmt1.executeQuery();
				ResultSet rs2 = stmt2.executeQuery();
				
				if(rs1.next()){
					 ri.setUname(rs1.getString("u_name"));
				 }
				 
				if(rs2.next()){
					 ri.setSname(rs2.getString("s_name"));
				 }
				 
				al.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return al;
	 }
	 
	 //根据id条件查询关键字keyvalue对应的日期内全部数据的数目
	 public int getDateAndCdCount(int condition,String keyValue,String sdate,String edate){
		 int count = 0;
		 Connection conn = JDBCUtil.getConnection();
		 String[] columnNames = {"U_ID", "U_NAME", "S_NAME"};
		 String sql = "";
		 if (condition == 0) {	   
			sql = "select count(*) from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " = " + "'" + keyValue + "') AND t_time between '"+sdate+"' AND '"+edate +"'";	     
		 } else if(condition == 1){
	    	sql = "select count(*) from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " LIKE " + "'" + keyValue + "%') AND t_time between '"+sdate+"' AND '"+edate +"'";	          
	     } else { 	          
	 	    sql = "select count(*) from tab_report where S_ID IN (select S_ID from tab_mentalscale where " + columnNames[condition] + " LIKE " + "'" + keyValue + "%') AND t_time between '"+sdate+"' AND '"+edate +"'";	      	           
	     }
		 System.out.println(sql);
		 try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
     			 count = rs.getInt("count(*)");
     		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	 }
	   //根据id条件查询关键字keyvalue对应的日期内全部数据
	 public ArrayList<Report> queryByDateAndCond(int condition,String keyValue,String sdate,String edate,int i,int pageSize){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Report> al = new ArrayList<Report>();
		 String[] columnNames = {"U_ID", "U_NAME", "S_NAME"};
    	 String sql = "";
    	 if (condition == 0) {	   
  		    sql = "select * from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " = " + "'" + keyValue + "') AND t_time between '"+sdate+"' AND '"+edate +"' order by t_time desc limit " + i + "," + pageSize;	     
     	 } else if(condition == 1){
     		sql = "select * from tab_report where U_ID IN (select U_ID from tab_patientinfo where " + columnNames[condition] + " LIKE " + "'" + keyValue + "%') AND t_time between '"+sdate+"' AND '"+edate +"' order by t_time desc limit " + i + "," + pageSize;	          
     	 } else { 	          
  	        sql = "select * from tab_report where S_ID IN (select S_ID from tab_mentalscale where " + columnNames[condition] + " LIKE " + "'" + keyValue + "%') AND t_time between '"+sdate+"' AND '"+edate +"' order by t_time desc limit " + i + "," + pageSize;	      	           
     	 }
    	 System.out.println(sql);
    	 try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Report ri = new Report();
				int reportId = rs.getInt("id");
				int uid = rs.getInt("u_id");
				int sid = rs.getInt("s_id");
				String datetime = rs.getString("t_time");
				
				ri.setT_time(datetime);
				ri.setId(reportId);
				ri.setS_id(sid);
				ri.setU_id(uid);
				
				String sql1 = "select u_name from tab_patientinfo where u_id="+uid;
				System.out.println(sql1);
				
				String sql2 = "select s_name from tab_mentalscale where s_id="+sid;
				System.out.println(sql2);
				
				PreparedStatement stmt1 = conn.prepareStatement(sql1);
				PreparedStatement stmt2 = conn.prepareStatement(sql2);
				ResultSet rs1 = stmt1.executeQuery();
				ResultSet rs2 = stmt2.executeQuery();
				
				if(rs1.next()){
					 ri.setUname(rs1.getString("u_name"));
				 }
				 
				if(rs2.next()){
					 ri.setSname(rs2.getString("s_name"));
				 }
				 
				al.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return al;
	 }
}
