package com.csu.entity;

import org.json.JSONObject;

//�ļ���Ϣ���ñ���Ҫ������Ҫ������ļ�
public class Fileinfo {
	private int file_id;
	private String file_name; //�ļ�����
	private String file_desc; //�ļ�����
	private String file_type; //�ļ�����
	private String file_uploadTime; //�ļ��ϴ�ʱ��
	private String file_path; //�ļ�����λ��
	private int userID; //����ļ������ĸ�����
	private String sysuserID; //�ļ�˭�ϴ���
	
	
	public int getFile_id() {
		return file_id;
	}
	
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	
	public String getFile_name() {
		return file_name;
	}
	
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	public String getFile_desc() {
		return file_desc;
	}
	
	public void setFile_desc(String file_desc) {
		this.file_desc = file_desc;
	}
	
	public String getFile_type() {
		return file_type;
	}
	
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	
	public String getFile_uploadTime() {
		return file_uploadTime;
	}
	
	public void setFile_uploadTime(String file_uploadTime) {
		this.file_uploadTime = file_uploadTime;
	}
	
	public String getFile_path() {
		return file_path;
	}
	
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getSysuserID() {
		return sysuserID;
	}
	
	public void setSysuserID(String sysuserID) {
		this.sysuserID = sysuserID;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("file_id", this.file_id);
		jo.put("file_name", this.file_name);
		jo.put("file_desc", this.file_desc);
		jo.put("file_type", this.file_type);
		jo.put("file_uploadTime", this.file_uploadTime);
		jo.put("file_path", this.file_path);
		jo.put("userID", this.userID);
		jo.put("sysuserID", this.sysuserID);
		return jo;
	}

	public String toString() {
		return this.toJSON().toString(); 
	}
	
	/*
	 * private int file_id;
	private String file_name; //�ļ�����
	private String file_desc; //�ļ�����
	private String file_type; //�ļ�����
	private String file_uploadTime; //�ļ��ϴ�ʱ��
	private String file_path; //�ļ�����λ��
	private int userID; //����ļ������ĸ�����
	private String sysuserID; //�ļ�˭�ϴ���
	 */
}
