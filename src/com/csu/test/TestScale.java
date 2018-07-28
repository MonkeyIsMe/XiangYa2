package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.ScaleDAO;
import com.csu.entity.MentalScale;
import com.csu.entity.Report;
import com.csu.entity.Uresult;

public class TestScale {
	
	ScaleDAO sd = new ScaleDAO();
	
	@Test
	public void SelectFromTab_Choice() {
		int i_id = 5;
		ArrayList list = sd.SelectFromTab_choice(i_id);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	@Test
	public void SelectFromTab_choice() {
		String mc_num = "1";
		int i_id = 5;
		ArrayList list = sd.SelectFromTab_choice(mc_num, i_id);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	@Test
	public void SelectFromTab_mentalscale() {
		ArrayList<MentalScale> list = sd.SelectFromTab_mentalscale();
		for(MentalScale ms : list) {
			System.out.println(ms.toString());
		}
	}
	
	@Test
	public void SelectFromTab_scaleitem() {
		int s_id = 3;
		ArrayList list = sd.SelectFromTab_scaleitem(s_id);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}


	@Test
	public void InsertToTab_uresult() {
		sd.InsertToTab_uresult(1, 1, 1, "2018-7-17", 1, 1);
	}
	
	@Test
	public void InsertToReport() {
		Report r = new Report();
		r.setU_id(1545646);
		r.setS_id(454);
		r.setT_time("2018-7-28");
		r.setSysID("2014551624");
		sd.InsertToReport(r);
	}

}
