package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Result;
import com.csu.utils.JDBCUtil;

public class ResultDAO {
	
	
	//增加记录
	public boolean addResult(Result re){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_result(recordId,itemId,result,introduction,remark)" +
				"values(?,?,?,?,?)";
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, re.getRecordId());
			stmt.setInt(2, re.getItemId());
			stmt.setString(3, re.getResult());
			stmt.setString(4, re.getIntroduction());
			stmt.setString(5, re.getRemark());
			System.out.println(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//根据记录的id查询一个结果信息
	public ArrayList<Result> queryResultsByRecordId(int rid){
		ArrayList<Result> resultList = new ArrayList<Result>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from tab_result where recordId=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setInt(1, rid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Result result = new Result();
				result.setId(rs.getInt("id"));
				result.setRecordId(rs.getInt("recordId"));
				result.setItemId(rs.getInt("itemId"));
				result.setResult(rs.getString("result"));
				result.setIntroduction(rs.getString("introduction"));
				result.setRemark(rs.getString("remark"));
				resultList.add(result);
			}
			System.out.println(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return resultList;
	}
}
