package com.csu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.csu.dao.FileDAO;
import com.csu.entity.Fileinfo;

public class TestFile {
	
	@Test
	public void addFile() {
		Fileinfo fi = new Fileinfo();
		FileDAO fd = new FileDAO();
		fi.setFile_desc("test");
		fi.setFile_path("test");
		fi.setFile_uploadTime("2015-05-08 13:29:56");
		fd.addFile(fi);
	}
	
	@Test
	public void getFileByUid() {
		FileDAO fd = new FileDAO();
		int uid = 56;
		ArrayList<Fileinfo> fi = fd.getFileByUid(uid);
		for(Fileinfo file : fi) {
			System.out.println(file.toString());
		}
	}
	
	@Test
	public void deleteFile() {
		int fid = 45;
		FileDAO fd = new FileDAO();
		fd.deleteFile(fid);
	}
}
