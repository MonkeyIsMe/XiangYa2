 package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Choice;
import com.csu.entity.Choice2;
import com.csu.entity.MentalScale;
import com.csu.entity.Report;
import com.csu.entity.ScaleItem;
import com.csu.entity.Uresult;
import com.csu.utils.JDBCUtil;

public class ScaleDAO {
	
	
	public boolean InsertToTab_uresult(int u_id  ,int s_id,int temp_iid,String dt, int a,int b){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_uresult values ('" + u_id + "','" + s_id + "','" + temp_iid + "','" + dt + "','" + a + "','" + b+ "')";
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
	
	public boolean InsertToTab_tresult(int u_id  ,int s_id,int a ,String datetime,int b, int c){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_tresult values ('" + u_id + "','" + s_id + "','" + a + "','" + datetime + "','" + b + "','" + c + "',0)";
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
	 
	public boolean InsertToReport(Report re){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_report(u_id,s_id,t_time,sysID) values ('" + re.getU_id() + "','" + re.getS_id() + "','" +  re.getT_time() + "','"+re.getSysID()+"')";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	//被选择的选项
	public ArrayList SelectFromTab_choice(int i_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_choice where I_ID='" + i_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Choice ch = new Choice();
				ch.setC_Content(rs.getString("C_Content"));
				ch.setC_Num(rs.getInt("C_Num"));
				al.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList SelectFromTab_choice(String mc_num,int i_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_choice where C_Num='" + mc_num + "' and I_ID = '" + i_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Choice ch = new Choice();
				ch.setC_SubChoice(rs.getString("C_SubChoice"));
				ch.setC_Score(rs.getInt("C_Score"));
				al.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	
	public ArrayList SelectFromTab_choice2(String C_Num,int i_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_choice2 where C_Num='" + C_Num + "' and I_ID = '" + i_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Choice2 ch = new Choice2();
				ch.setC_Content(rs.getString("C_Content"));
				ch.setC_SubNum(rs.getInt("C_SubNum"));
				al.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList SelectFromTab_choice2(int i_id,int C_Num,int C_SubNum){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_choice2 where I_ID = '" + i_id + "' and C_Num= '" +C_Num + "' and C_SubNum = '" + C_SubNum + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Choice2 ch = new Choice2();
				ch.setC_Score(rs.getInt("C_Score"));
				al.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList SelectFromTab_mentalscale1(int s_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select S_Name from tab_mentalscale where S_ID='" + s_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_Name(rs.getString("S_Name"));
				al.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList<MentalScale> SelectFromTab_mentalscale(){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<MentalScale> al = new ArrayList<MentalScale>();
		String sql ="select * from tab_mentalscale order by s_usesum DESC,s_name";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				MentalScale m = new MentalScale();
				m.setS_ID(rs.getInt("S_ID"));
				m.setS_Name(rs.getString("S_NAME"));
				al.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList SelectFromTab_mentalscale(String s_name){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_mentalscale where S_Name='" + s_name + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 while(rs.next()){
				 MentalScale ms = new MentalScale();
				 ms.setS_ID(rs.getInt("S_ID"));
				 al.add(ms);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	
	public boolean DeleteFromTab_uresult(int s_id,int u_id){
		Connection conn = JDBCUtil.getConnection();
		String sql="delete from tab_uresult where S_ID='" + s_id + "'and U_ID='" + u_id + "'";
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
	
	public boolean UpdateTab_mentalscale(String s_id ){
		Connection conn = JDBCUtil.getConnection();
		String sql = "UPDATE tab_mentalscale SET S_UseSum=S_UseSum+1 where S_ID=" + s_id + ";";
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
	
	public ArrayList SelectFromTab_uresult(int s_id,int u_id ){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_uresult where S_ID='" + s_id + "'and U_ID='" + u_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Uresult u = new Uresult();
				u.setC_Num(rs.getInt("C_Num"));
				u.setC_SubNum(rs.getInt("C_SubNum"));
				al.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList SelectFromTab_scaleitem(int s_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList al = new ArrayList();
		String sql = "select * from tab_scaleitem where S_ID='" + s_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ScaleItem si = new ScaleItem();
				si.setI_ID(rs.getInt("I_ID"));
				si.setI_Content(rs.getString("I_Content"));
				si.setI_Factor(rs.getInt("I_Factor"));
				al.add(si);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	public ArrayList<MentalScale> SelectFromTab_mentalscale2(String s_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<MentalScale> al = new ArrayList<MentalScale>();
		String sql = "select * from tab_mentalscale where S_ID = '" + s_id + "'";
		System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_Guide(rs.getString("S_Guide"));
				ms.setS_Intro(rs.getString("S_Intro"));
				ms.setS_Name(rs.getString("S_Name"));
				al.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
}
