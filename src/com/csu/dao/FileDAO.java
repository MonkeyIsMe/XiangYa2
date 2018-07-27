package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.csu.entity.Fileinfo;
import com.csu.utils.JDBCUtil;

public class FileDAO {
	
	//添加一个文件信息
	public boolean addFile(Fileinfo file){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_fileinfo(file_name,file_type,file_desc,file_uploadTime,userID,sysuserID) " +
    			"values('"+file.getFile_name()+"','"+file.getFile_type()+"','"+file.getFile_desc()+"','"+file.getFile_uploadTime()+"','"+file.getUserID()+"','"+file.getSysuserID()+"')";
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
	
	//根据用户id查询用户相关的文件信息
	public ArrayList<Fileinfo> getFileByUid(int uid){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Fileinfo> fileList = new ArrayList<Fileinfo>();
    	String sql = "select * from tab_fileinfo where userID ="+uid;
    	System.out.println(sql);
    	try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			Fileinfo file = new Fileinfo();
    			file.setFile_desc(rs.getString("File_desc"));
    			file.setFile_id(rs.getInt("File_id"));
    			file.setFile_name(rs.getString("File_name"));
    			file.setFile_type(rs.getString("File_type"));
    			file.setSysuserID(rs.getString("SysuserID"));
    			file.setFile_uploadTime(rs.getString("File_uploadTime"));
    			fileList.add(file);   			
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return fileList;
		
	}
	
	//根据文件id删除一个文件
	public boolean deleteFile(int fid){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_fileinfo where file_id="+fid;
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
