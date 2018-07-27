package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csu.entity.PatientInfo;
import com.csu.utils.JDBCUtil;

public class PatientDAO {
	
	//添加病人
	 public boolean addPatient(PatientInfo pi){
		    Connection conn = JDBCUtil.getConnection();
	    	
	    	//Database db = Database.getInstance();
	    	
			try {
				String sql = "insert into tab_patientinfo(u_name,gender,birthday,isAdopted,nation,fatherBirthArea,fatherNation,motherBirthArea,motherNation,hand,preName,relationship,growthArea,birthArea,builderId) " +
		    			"values('"+pi.getU_name()+"','"+pi.getGender()+"','"+pi.getBirthday()+"','"+pi.getIsAdopted()+"','"+pi.getNation()+"','"+pi.getFatherBirthArea()+"','"+pi.getFatherNation()+"','"+pi.getMotherBirthArea()+"','"+pi.getMotherNation()+"','"+pi.getHand()+"','"+pi.getPreName()+"','"+pi.getRelationship()+"','"+pi.getGrowthArea()+"','"+pi.getBirthArea()+"','"+pi.getBuilderId()+"')";
		    	System.out.println(sql);
		    	//System.out.println(pi.getU_name());
		    	PreparedStatement stmt= conn.prepareStatement(sql);
				stmt.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
	    	//Statement stmt = db.getStmt();
			return true;
	    }
	 
	 //删除病人
	 public boolean DeletePatient(int uid)
	 {
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "delete from tab_patientinfo where u_id="+uid;
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
	 
	 //更新病人
	 public boolean UpdatePatient(int uid,PatientInfo pi)
	 {
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "update tab_patientinfo set U_name='"+pi.getU_name()+"',relationship='"+pi.getRelationship()+"'," +
	    			"PreName='"+pi.getPreName()+"',nation='"+pi.getNation()+"',motherNation='"+pi.getMotherNation()+"'," +
	    			"MotherBirthArea='"+pi.getMotherBirthArea()+"',fatherNation='"+pi.getFatherNation()+"',fatherBirthArea='"+pi.getFatherBirthArea()+"' , IsAdopted='"+pi.getIsAdopted()+"', " +
	    			"birthArea='"+pi.getBirthArea()+"',birthday='"+pi.getBirthday()+"',gender='"+pi.getGender()+"',hand='"+pi.getHand()+"',growthArea='"+pi.getGrowthArea()+"' where u_id="+uid;
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
	 
	 //根据u_id查询病人
	 public PatientInfo QueryPatientByUid(int uid)
	 {
		Connection conn = JDBCUtil.getConnection();
		PatientInfo pi = new PatientInfo();
		String sql = "select * from tab_patientinfo where u_id="+uid;
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
            while(rs.next()){
	        		pi.setBirthArea(rs.getString("birthArea"));
	        		pi.setBirthday(rs.getString("birthday"));
	        		pi.setFatherBirthArea(rs.getString("fatherBirthArea"));
	        		pi.setFatherNation(rs.getString("fatherNation"));
	        		pi.setGender(rs.getString("gender"));
	        		pi.setGrowthArea(rs.getString("growthArea"));
	        		pi.setHand(rs.getString("hand"));
	        		pi.setIdentity(rs.getString("identity"));
	        		pi.setIsAdopted(rs.getString("IsAdopted"));
	        		pi.setMotherBirthArea(rs.getString("MotherBirthArea"));
	        		pi.setMotherNation(rs.getString("MotherNation"));
	        		pi.setNation(rs.getString("Nation"));
	        		pi.setPatientId(rs.getString("PatientId"));
	        		pi.setPreName(rs.getString("PreName"));
	        		pi.setRelationship(rs.getString("Relationship"));
	        		pi.setTestNumber(rs.getString("TestNumber"));
	        		pi.setU_id(rs.getInt("u_id"));
	        		pi.setU_name(rs.getString("U_name"));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return pi;
	 }
	 
	 //给uid设置一个课题
	 public boolean setTopicPatient(int topicId,int uid){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "insert into tab_patient_topic(patientId,topicId) values("+uid+","+topicId+")";
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
	 
	 
	 //根据课题id，topicid和创建者id，condition，名字pname，分页查询病人信息
	 public ArrayList<PatientInfo> queryByPname(int i,int pageSize,int topicId,String pname,String condition){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<PatientInfo> piList = new ArrayList<PatientInfo>();
		 String sql = "select * from tab_patientinfo where u_name like '%"+pname+"%' AND  u_id IN(select patientId from tab_patient_topic where topicId="+topicId+") AND builderId IN("+condition+") order by u_id desc limit " + i + "," + pageSize;  
	     System.out.println(sql);
	     try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 while(rs.next())  
	            {  
	            	//int scaleId = Integer.parseInt((String)rs.get(0));
	            	PatientInfo pa = new PatientInfo();
	        		pa.setBirthArea(rs.getString("birthArea"));
	        		pa.setBirthday(rs.getString("birthday"));
	        		pa.setFatherBirthArea(rs.getString("fatherBirthArea"));
	        		pa.setFatherNation(rs.getString("fatherNation"));
	        		pa.setGender(rs.getString("gender"));
	        		pa.setGrowthArea(rs.getString("growthArea"));
	        		pa.setHand(rs.getString("hand"));
	        		pa.setIdentity(rs.getString("identity"));
	        		pa.setIsAdopted(rs.getString("IsAdopted"));
	        		pa.setMotherBirthArea(rs.getString("MotherBirthArea"));
	        		pa.setMotherNation(rs.getString("MotherNation"));
	        		pa.setNation(rs.getString("Nation"));
	        		pa.setPatientId(rs.getString("PatientId"));
	        		pa.setPreName(rs.getString("PreName"));
	        		pa.setRelationship(rs.getString("Relationship"));
	        		pa.setTestNumber(rs.getString("TestNumber"));
	        		pa.setU_id(rs.getInt("u_id"));
	        		pa.setU_name(rs.getString("U_name"));
	        		pa.setBuilderId(rs.getString("builderId"));
	            	piList.add(pa);
	            }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return piList;
	 }
	 
	 
	 //根据课题id，topicid和创建者id，condition，名字pname，查询病人信息数目
	 public int searchCount(String pname,int topicId,String condition) {
		 Connection conn = JDBCUtil.getConnection();
		 int count = 0;
		 String sql = "select count(*) from tab_patientinfo p where u_name like'%"+pname+"%' AND u_id IN(select patientId from tab_patient_topic where topicId="+topicId+") AND builderId IN("+condition+")";
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();//游标指向第一行
			count = rs.getInt(1);//取得总行数
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	 }
	 
	 
	//根据课题id，topicid和创建者id，condition，分页查询病人信息数目
	 public int count(int topicId,String condition) {
		 Connection conn = JDBCUtil.getConnection();
		 int count = 0;
		 String sql = "select count(*) from tab_patientinfo p where u_id IN(select patientId from tab_patient_topic where topicId="+topicId+") AND builderId IN("+condition+")";
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 rs.next();//游标指向第一行 
			 count = rs.getInt(1);
			 rs.close();
			 stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	 }
	 
	 //根据课题id，topicid和创建者id，condition，分页查询病人信息数目
	 public ArrayList<PatientInfo> queryByPage(int i,int pageSize,int topicId,String condition){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<PatientInfo> piList = new ArrayList<PatientInfo>();
		 String sql = "select * from tab_patientinfo p where u_id IN(select patientId from tab_patient_topic where topicId="+topicId+") AND builderId IN("+condition+")  limit " + i + "," + pageSize;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())  
            {  
            	//int scaleId = Integer.parseInt((String)rs.get(0));
            	PatientInfo pa = new PatientInfo();
        		pa.setBirthArea(rs.getString("birthArea"));
        		pa.setBirthday(rs.getString("birthday"));
        		pa.setFatherBirthArea(rs.getString("fatherBirthArea"));
        		pa.setFatherNation(rs.getString("fatherNation"));
        		pa.setGender(rs.getString("gender"));
        		pa.setGrowthArea(rs.getString("growthArea"));
        		pa.setHand(rs.getString("hand"));
        		pa.setIdentity(rs.getString("identity"));
        		pa.setIsAdopted(rs.getString("IsAdopted"));
        		pa.setMotherBirthArea(rs.getString("MotherBirthArea"));
        		pa.setMotherNation(rs.getString("MotherNation"));
        		pa.setNation(rs.getString("Nation"));
        		pa.setPatientId(rs.getString("PatientId"));
        		pa.setPreName(rs.getString("PreName"));
        		pa.setRelationship(rs.getString("Relationship"));
        		pa.setTestNumber(rs.getString("TestNumber"));
        		pa.setU_id(rs.getInt("u_id"));
        		pa.setU_name(rs.getString("U_name"));
        		pa.setBuilderId(rs.getString("builderId"));
            	piList.add(pa);
            }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return piList;
	 }
}
