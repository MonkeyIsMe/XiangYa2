package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.KindManageDAO;

public class TestKindManage {
	
	@Test
	public void getAllFkinds() {
		ArrayList<Object> list = new ArrayList<Object>();
		KindManageDAO kmd = new KindManageDAO();
		list = kmd.getAllFkinds();
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}
	
	@Test
	public void getSkindsByfid() {
		int fid = 6;
		KindManageDAO kmd = new KindManageDAO();
		ArrayList<Object> list = kmd.getSkindsByfid(fid);
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
	}

	@Test
	public void addDl() {
		String name = "test";
		KindManageDAO kmd = new KindManageDAO();
		boolean flag = kmd.addDl(name);
		System.out.println(flag);
	}
	
	@Test
	public void addXl() {
		KindManageDAO kmd = new KindManageDAO();
		int fid = 20;
		String name = "test";
		boolean flag = kmd.addXl(fid, name);
		System.out.println(flag);
	}
	
	@Test
	public void deleteXl() {
		KindManageDAO kmd = new KindManageDAO();
		int sk_id = 114;
		kmd.deleteXl(sk_id);
	}
	
	
	@Test
	public void deleteDl() {
		int f_id = 20;
		KindManageDAO kmd = new KindManageDAO();
		kmd.deleteDl(f_id);
	}
}
