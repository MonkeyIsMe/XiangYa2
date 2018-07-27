package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Fkind;
import com.csu.utils.JDBCUtil;

public class KindManageDAO {
	
	public ArrayList<Object> getAllFkinds(){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Object> list = new ArrayList<Object>();
		String sql = "select * from tab_fkind";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Fkind fk = new Fkind();
				fk.setF_id(rs.getInt("f_id"));
				fk.setName(rs.getString("name"));
				list.add(fk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//根据sid查询病情种类
	public ArrayList<Object> getSkindsByfid(int fid){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Object> list = new ArrayList<Object>();
    	String sql = "select * from tab_skind where f_id =" + fid;
    	System.out.println(sql);
    	try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				ArrayList<Object> sub = new ArrayList<Object>();
				sub.add(rs.getInt("sk_id"));
				sub.add(rs.getString("name"));
				list.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	return list;
	}
	
	//新增大类
	public boolean addDl(String name) {
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_fkind(name) values('" + name + "')";
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
	
	
	//新增小类
	public boolean addXl(int fid,String name){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_skind(f_id,name) values("+fid+",'" + name + "')";
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
	
	//删除大类
	public boolean deleteDl(int f_id){
		Connection conn = JDBCUtil.getConnection();
		String sql1 = "delete from tab_skind where f_id="+f_id;
    	String sql2 = "delete from tab_fkind where f_id="+f_id;
    	System.out.println(sql1);
    	System.out.println(sql2);
    	try {
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.execute();
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//删除小类
	public boolean deleteXl(int sk_id){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_skind where sk_id="+sk_id;
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
}
