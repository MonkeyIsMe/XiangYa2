package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.ScaleEditDAO;
import com.csu.entity.Choice;
import com.csu.entity.MentalScale;
import com.csu.entity.Reference;
import com.csu.entity.ScaleItem;

public class TestScaleEdit {
	
	ScaleEditDAO sed = new ScaleEditDAO();
	
	@Test
	public void checkSname() {
		String name = "90ÏîÖ¢×´Çåµ¥";
		boolean flag = sed.checkSname(name);
		System.out.println(flag);
		
	}
	
	@Test
	public void getRefer() {
		int sid = 3;
		int fid = 1;
		ArrayList<Reference> list = sed.getRefer(sid, fid);
		for(Reference refer : list) {
			System.out.println(refer.toString());
		}
	}
	
	@Test
	public void getFactorCount() {
		int sid = 3;
		int count = sed.getFactorCount(sid);
		System.out.println(count);
	}
	
	@Test
	public void getScaleItem() {
		int sid = 3;
		ArrayList<Object> al = sed.getScaleItem(sid);
		for(Object ob : al) {
			System.out.println(ob.toString());
		}
	}
	
	
	@Test
	public void getChoiceCount() {
		int iid = 6;
		int count = sed.getChoiceCount(iid);
		System.out.println(count);
	}
	
	@Test
	public void createNewScale() {
		MentalScale ms = new MentalScale();
		ms.setS_Name("test");
		ms.setS_Guide("test");
		ms.setS_Intro("This is a test");
		sed.createNewScale(ms);
	}
	
	
	@Test
	public void updateScale() {
		MentalScale ms = new MentalScale();
		ms.setS_Name("test");
		ms.setS_Guide("test");
		ms.setS_Intro("This is a test");
		ms.setS_ID(2317);
		ms.setS_ReportInfo(45);
		ms.setS_Remark("remark");
		sed.updateScale(ms);
	}

	
	@Test
	public void getItemByIid() {
		int iid = 10;
		ArrayList<Object> list = sed.getItemByIid(iid);
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}

	
	@Test
	public void getChoiceByIid() {
		int iid = 5;
		ArrayList<Object> list = sed.getChoiceByIid(iid);
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}
	
	@Test
	public void getFactorsBySid() {
		int sid = 3;
		ArrayList<Object> list = sed.getFactorsBySid(sid);
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}
	
	@Test
	public void addScaleItem() {
		ScaleItem si = new ScaleItem();
		si.setI_Content("test");
		si.setI_TYPE("test");
		si.setS_ID(3);
		sed.addScaleItem(si);
	}
	
	@Test
	public void getItemCount() {
		int sid = 2316;
		int count = sed.getItemCount(sid);
		System.out.println(count);
	}
	
	@Test
	public void getFactorsBySidAndFid() {
		int sid = 3;
		int fid = 1;
		ArrayList<Object> list = sed.getFactorsBySidAndFid(sid, fid);
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}

	@Test
	public void addRefer() {
		int sid = 8888;
		int cid = 88;
		Reference refer = new Reference();
		refer.setF_Rid(555);
		refer.setR_Suggestion("test");
		sed.addRefer(sid, cid, refer);
	}

	@Test
	public void addTableChoice() {
		Choice ch = new Choice();
		ch.setI_ID(55891);
		ch.setC_Num(8888);
		ch.setC_SubChoice("b");
		ch.setC_Content("test");
		sed.addTableChoice(ch);
	}

}
