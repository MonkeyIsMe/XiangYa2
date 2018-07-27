package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csu.entity.Topic;
import com.csu.utils.JDBCUtil;

public class TopicDAO {
	
	//查询全部的课题
	public ArrayList<Topic> getTopicInfo(){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Topic> list = new ArrayList<Topic>();
		String sql = "select * from tab_topic";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
	    		Topic tp = new Topic();
	    		tp.setTopicId(rs.getInt("topicId"));
	    		tp.setTopicName(rs.getString("topicName"));
	    		list.add(tp);
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
	//根据系统用户的账号来查询一个系统用户的课题
	public ArrayList<Topic> getUserTopic(String account){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Topic> list = new ArrayList<Topic>();
		String sql = "select tt.topicId,tt.topicName from tab_topic tt where tt.topicId not in (select topicId from tab_sysuser_topic where u_account='"+account+"')";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
	    		Topic tp = new Topic();
	    		tp.setTopicId(rs.getInt("topicId"));
	    		tp.setTopicName(rs.getString("topicName"));
	    		list.add(tp);
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
	//查询一个不属于这个系统用户的其他课题
	public ArrayList<Topic> getRestTopic(String account){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Topic> list = new ArrayList<Topic>();
		String sql = "select tt.topicId,tt.topicName from tab_topic tt where tt.topicId not in (select topicId from tab_sysuser_topic where u_account='"+account+"')";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
	    		Topic tp = new Topic();
	    		tp.setTopicId(rs.getInt("topicId"));
	    		tp.setTopicName(rs.getString("topicName"));
	    		list.add(tp);
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//通过登录账户和课题删除一个课题一个系统的用户
	public boolean removeTopic(String account,String topicId){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_sysuser_topic where u_account='"+account+"' AND topicId='"+topicId+"'";
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
	
	public boolean addTopic(String account,String topicId){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_sysuser_topic(u_account,topicId) values('"+account+"','"+topicId+"')";
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
}
