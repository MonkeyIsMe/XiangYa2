package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.csu.utils.JDBCUtil;

public class SetTopicScaleDAO {
	
	//添加一个课题与量表对应关系
	public boolean setTopicScale(int topicId,int scaleId){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_topic_scale(S_ID,topicId) values("+scaleId+","+topicId+")";
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
	
	//移除一个课题与量表对应关系
	public boolean removeTopicScale(int topicId,int scaleId){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_topic_scale where S_ID="+scaleId+" AND topicId="+topicId;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
