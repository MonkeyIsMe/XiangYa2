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
	
	//��ѯȫ���Ŀ���
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
	
	
	//����ϵͳ�û����˺�����ѯһ��ϵͳ�û��Ŀ���
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
	
	
	//��ѯһ�����������ϵͳ�û�����������
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
	
	//ͨ����¼�˻��Ϳ���ɾ��һ������һ��ϵͳ���û�
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
