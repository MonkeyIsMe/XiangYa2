package com.csu.test;

import org.junit.Test;

import com.csu.dao.SetTopicScaleDAO;

public class TestSetTopicScale {
	
	@Test
	public void setTopicScale(){
		int topicId = 10;
		int scaleId = 5;
		SetTopicScaleDAO stsd = new SetTopicScaleDAO();
		stsd.setTopicScale(topicId, scaleId);
	}
	
	@Test
	public void removeTopicScale() {
		int topicId = 10;
		int scaleId = 5;
		SetTopicScaleDAO stsd = new SetTopicScaleDAO();
		stsd.removeTopicScale(topicId, scaleId);
	}
}
