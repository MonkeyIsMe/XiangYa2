package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.TopicDAO;
import com.csu.entity.Topic;

public class TestTopic {
	
	
	@Test
	public void getTopicInfo() {
		TopicDAO td = new TopicDAO();
		ArrayList<Topic> to = td.getTopicInfo();
		for(Topic topic :to) {
			System.out.println(topic.toString());
		}
	}
	
	@Test
	public void getUserTopic() {
		String account = "124712104";
		TopicDAO td = new TopicDAO();
		ArrayList<Topic> to = td.getUserTopic(account);
		for(Topic topic :to) {
			System.out.println(topic.toString());
		}
	}
	
	@Test
	public void getRestTopic() {
		String account = "124712104";
		TopicDAO td = new TopicDAO();
		ArrayList<Topic> to = td.getRestTopic(account);
		for(Topic topic :to) {
			System.out.println(topic.toString());
		}
	}
	
	@Test
	public void addTopic() {
		String account = "124712105";
		String topicId = "9";
		TopicDAO td = new TopicDAO();
		td.addTopic(account, topicId);
	}
	
	@Test
	public void removeTopic() {
		String account = "124712105";
		String topicId = "9";
		TopicDAO td = new TopicDAO();
		td.removeTopic(account, topicId);
	}
}
