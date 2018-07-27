package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Factor;
import com.csu.entity.MentalScale;
import com.csu.entity.PatientInfo;
import com.csu.entity.SysUser;
import com.csu.entity.Unit;
import com.csu.utils.JDBCUtil;

public class PrintInforDAO {
	
	//得到一个病人的信息
	public PatientInfo getPatientInfo(int u_id){
		Connection conn = JDBCUtil.getConnection();
		PatientInfo pi = new PatientInfo();
		String sql = "select * from tab_patientinfo where U_ID='" + u_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
	        	  pi.setU_name(rs.getString("u_name"));
	        	  pi.setBirthday(rs.getString("birthday"));
	        	  pi.setGender(rs.getString("gender"));
	        	  pi.setNation(rs.getString("nation"));             
	          }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return pi;
	}
	
	//得到所有的路径
	public ArrayList getU_iconpath(){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_unit";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Unit unit = new Unit();
				unit.setU_ICONPATH(rs.getString("U_ICONPATH"));
				al.add(unit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	//根据sid获得病人的报告信息（名字，报告）
	public ArrayList getReportInfo(String s_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select S_Name, S_ReportInfo from tab_mentalscale where S_ID='" + s_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_Name(rs.getString("S_Name"));
				ms.setS_ReportInfo(rs.getInt("S_ReportInfo"));
				al.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	//查找报告的影响因子
	public ArrayList<Factor> getFactor(String s_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Factor> fac = new ArrayList<Factor>();
		String sql = "select * from tab_factor where S_ID='" + s_id + "' order by F_SNum";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Factor fa = new Factor();
				fa.setF_Balance(rs.getFloat("F_Balance"));
				fa.setF_Content(rs.getString("F_Content"));
				fa.setF_Den(rs.getDouble("F_Den"));
				fa.setF_Formula(rs.getString("F_Formula"));
				fa.setF_SNum(rs.getInt("F_SNum"));
				fac.add(fa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fac;
	}
	
	public ArrayList<SysUser> SelectU_depart(String u_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<SysUser> al = new ArrayList<SysUser>();
		String sql = "select U_DEPART from tab_sysuser where U_NAME in(select U_CREATER from tab_user where U_ID = '" + u_id + "')";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				SysUser su = new SysUser();
				su.setDept_id(rs.getInt("U_DEPART"));
				al.add(su);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
}
