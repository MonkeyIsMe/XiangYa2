package com.csu.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.csu.dao.ScaleManageDAO;
import com.csu.entity.MentalScale;
import com.csu.entity.Report;

public class TestScaleManage {
	
	ScaleManageDAO smd = new ScaleManageDAO();
	
	@Test
	public void queryByPage() {
		List<MentalScale> list = smd.queryByPage(0, 5);
		for(MentalScale ms : list) {
			System.out.println(ms.toString());
		}
	}
	
	@Test
	public void count() {
		int ans = smd.count();
		System.out.println(ans);
	}
	
	
	@Test 
	public void queryByScaleName() {
		int i = 0;
		int pageSize = 8;
		String sname = "量表";
		List<MentalScale> scale = smd.queryByScaleName(i, pageSize, sname);
		for(MentalScale ms : scale) {
			System.out.println(ms.toString());
		}
	}
	
	@Test
	public void searchCount() {
		String sname = "量表";
		int ans = smd.searchCount(sname);
		System.out.println(ans);
	}
	
	@Test
	public void getScaleInfoBySid() {
		int sid = 14;
		ArrayList<Object> list = smd.getScaleInfoBySid(sid);
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}

	@Test
	public void getScaleInfoBySkid() {
		String sk_id = "22";
		ArrayList<MentalScale> ms = smd.getScaleInfoBySkid(sk_id);
		for(MentalScale mental : ms) {
			System.out.println(mental.toString());
		}
	}

	@Test
	public void getAllScale() {
		ArrayList<MentalScale> ms = smd.getAllScale();
		for(MentalScale mental : ms) {
			System.out.println(mental.toString());
		}
	}
	
	@Test
	public void getTopicScale() {
		int topicId = 8;
		ArrayList<MentalScale> mental = smd.getTopicScale(topicId);
		for(MentalScale ms : mental) {
			System.out.println(ms.toString());
		}
	}

	
	@Test
	public void getReport() {
		int uid = 1;
		int s_id = 85;
		ArrayList<Report> list = smd.getReport(uid, s_id);
		for(Report re : list) {
			System.out.println(re.toString());
		}
	}
	
	@Test
	public void getFidBySkid() {
		int sk_id = 20;
		int count = smd.getFidBySkid(sk_id);
		System.out.println(count);
	}
}
