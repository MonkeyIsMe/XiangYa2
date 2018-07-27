package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.PatientInfo;
import com.csu.utils.JDBCUtil;

public final class ClientInfoDAO {
	
	//��ҳ��ѯ���в��˹˿͵���Ϣ
	public ArrayList<PatientInfo> SelectAllClientInfo(int i,int pageSize){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<PatientInfo> al = new ArrayList<PatientInfo>();
		String sql = "select * from tab_patientinfo order by u_id asc limit " + i + "," + pageSize; 
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
		           PatientInfo pi = new PatientInfo();
		           pi.setU_id(rs.getInt("u_id"));
		           pi.setU_name(rs.getString("u_name"));
		           pi.setIdentity(rs.getString("identity"));
		           pi.setPatientId(rs.getString("patientId"));
		           pi.setAdmissionNumber(rs.getString("admissionNumber"));
		           pi.setTestNumber(rs.getString("testNumber"));
		           pi.setGender(rs.getString("gender"));
		           pi.setNation(rs.getString("nation"));
		           pi.setBirthday(rs.getString("birthday"));
		           pi.setBirthArea(rs.getString("birthArea"));
		           al.add(pi);          
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	//ͨ�����ֲ�ѯ������Ϣ������
	public int searchCount(String patientName) {
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		String sql = "select count(*) from tab_patientinfo where u_name like '%"+patientName+"%'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();//�α�ָ���һ��  
            count = rs.getInt(1);//ȡ��������  
            rs.close() ;  
            stmt.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//��ѯ���˵�����
	public int count() {
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from tab_patientinfo";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();//�α�ָ���һ��  
            count = rs.getInt(1);//ȡ��������  
            rs.close() ;  
            stmt.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//ͨ�����֣���ҳ��ѯ���в��˹˿͵���Ϣ
	public ArrayList<PatientInfo> SelectClientInfoByName(int i,int pageSize,String patientName){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<PatientInfo> al = new ArrayList<PatientInfo>();
		String sql = "select * from tab_patientinfo where u_name like '%"+patientName+"%' order by u_id asc limit " + i + "," + pageSize; 
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
		           PatientInfo pi = new PatientInfo();
		           pi.setU_id(rs.getInt("u_id"));
		           pi.setU_name(rs.getString("u_name"));
		           pi.setIdentity(rs.getString("identity"));
		           pi.setPatientId(rs.getString("patientId"));
		           pi.setAdmissionNumber(rs.getString("admissionNumber"));
		           pi.setTestNumber(rs.getString("testNumber"));
		           pi.setGender(rs.getString("gender"));
		           pi.setNation(rs.getString("nation"));
		           pi.setBirthday(rs.getString("birthday"));
		           pi.setBirthArea(rs.getString("birthArea"));
		           al.add(pi);          
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
}
