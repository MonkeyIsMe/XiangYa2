package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.csu.entity.MentalScale;
import com.csu.entity.Report;
import com.csu.utils.JDBCUtil;

public class ScaleManageDAO {
	
	//��ҳ��ѯ��������
	public List<MentalScale> queryByPage(int i,int pageSize){
		Connection conn = JDBCUtil.getConnection();
		List<MentalScale> list  = new ArrayList<MentalScale>();
		String sql = "select * from tab_mentalscale order by updateTime desc limit " + i + "," + pageSize;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_ID(rs.getInt("S_ID"));
				ms.setS_Name(rs.getString("S_NAME"));
				ms.setS_Intro(rs.getString("S_INTRO"));
				ms.setS_Guide(rs.getString("S_GUIDE"));
				ms.setUpdateTime(rs.getString("updateTime"));
				list.add(ms);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//��ѯ������
	public int count() {
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		String sql = "select count(S_ID) from tab_mentalscale order by S_ID asc";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();//�α�ָ���һ��  
            count = rs.getInt(1);//ȡ��������  
            rs.close() ;  
            stmt.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//�������ַ�ҳ��ѯ��������
	public List<MentalScale> queryByScaleName(int i,int pageSize,String scalename){
		Connection conn = JDBCUtil.getConnection();
		List<MentalScale> list  = new ArrayList<MentalScale>();
		String sql = "select * from tab_mentalscale where S_Name like '%"+scalename+"%' order by updateTime desc limit " + i + "," + pageSize;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_ID(rs.getInt("S_ID"));
				ms.setS_Name(rs.getString("S_NAME"));
				ms.setS_Intro(rs.getString("S_INTRO"));
				ms.setS_Guide(rs.getString("S_GUIDE"));
				ms.setUpdateTime(rs.getString("updateTime"));
				list.add(ms);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//�������ֲ�ѯ�����������Ŀ
	public int searchCount(String scalename) {
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		String sql = "select count(S_ID) from tab_mentalscale where S_Name like '%"+scalename+"%' order by S_ID asc";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();//�α�ָ���һ��  
            count = rs.getInt(1);//ȡ��������  
            rs.close() ;  
            stmt.close() ; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//����sid��ѯ�������
	public ArrayList<Object> getScaleInfoBySid(int sid){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Object> list = new ArrayList<Object>();
		String sql = "select * from tab_mentalscale where S_ID="+sid;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
    			list.add(rs.getInt("S_ID"));
    			list.add(rs.getString("S_Name"));
    			list.add(rs.getString("S_Intro"));
    			list.add(rs.getString("S_Guide"));
    			list.add(rs.getDouble("S_StdScroe"));
    			list.add(rs.getInt("S_ReportInfo"));
    			list.add(rs.getInt("S_Value"));
    			list.add(rs.getInt("sk_id"));
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//����һ�ű�ѡ�����������ֺ�id
	public ArrayList<MentalScale> getScaleInfoBySkid(String sk_id){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<MentalScale> list = new ArrayList<MentalScale>();
		String sql = "select s_id,s_name from tab_mentalscale where sk_id = '"+sk_id+"'";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				MentalScale ms = new MentalScale();
				ms.setS_ID(rs.getInt("s_id"));
	    		ms.setS_Name(rs.getString("s_name"));
	    		list.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//����������������ֺ�id
	public ArrayList<MentalScale> getAllScale(){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<MentalScale> list = new ArrayList<MentalScale>();
		String sql = "select s_id,s_name from tab_mentalscale limit 10";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_ID(rs.getInt("s_id"));
	    		ms.setS_Name(rs.getString("s_name"));
	    		list.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//���ݿ����id������������ֺ�id
	public ArrayList<MentalScale> getTopicScale(int topicId){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<MentalScale> list = new ArrayList<MentalScale>();
		String sql = "select s_id,s_name from tab_mentalscale where s_id IN(select s_id from tab_topic_scale where topicId = "+topicId+")";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MentalScale ms = new MentalScale();
				ms.setS_ID(rs.getInt("s_id"));
	    		ms.setS_Name(rs.getString("s_name"));
	    		list.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//����uid��sid�õ�������Ϣ
	public ArrayList<Report> getReport(int uid,int s_id){
		ArrayList<Report> list = new ArrayList<Report>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from tab_report where u_id="+uid+" AND s_id="+s_id;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Report re = new Report();
				re.setSysID(rs.getString("sysID"));
	    		re.setT_time(rs.getString("t_time"));
	    		re.setId(rs.getInt("id"));
	    		list.add(re);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}

	//ͨ��sk_id��С����������Ӧ�������Ŀ��Ŀ
	public int getFidBySkid(int sk_id){
		Connection conn = JDBCUtil.getConnection();
		int count = 0;
		String sql = "select f_id from tab_skind where sk_id = "+sk_id;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
	    		count = rs.getInt("f_id");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//����ɾ��,����Ҫɾ��sid���������ر���
	public boolean deleteScaleBySid(int sid){
		Connection conn = JDBCUtil.getConnection();
		String sel = "select * from tab_report where S_ID= " + sid;
        String sqlrefer = "delete from tab_refer where S_ID = '" + sid + "'";
        String sqlf = "delete from tab_factor where S_ID = '" + sid + "'";
        String sqldelete = "delete from tab_mentalscale where S_ID = '" + sid + "'";
        String sqli = "delete from tab_scaleitem where S_ID = '" + sid + "'";
        String sqli_id = "select I_ID from tab_scaleitem where S_ID = " + sid;
		System.out.println(sel);
		System.out.println(sqlrefer);
		System.out.println(sqlf);
		System.out.println(sqldelete);
		System.out.println(sqli);
		System.out.println(sqli_id);
		try {
			PreparedStatement stmt= conn.prepareStatement(sel);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return false;
			}
			PreparedStatement st = conn.prepareStatement(sqli_id);
			rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
                String delchioce = "delete from tab_choice where I_ID =" + id;
                String delchioce2 = "delete from tab_choice2 where I_ID =" + id;
				System.out.println(delchioce);
				System.out.println(delchioce2);
                PreparedStatement st1 = conn.prepareStatement(delchioce);
				PreparedStatement st2 = conn.prepareStatement(delchioce2);
                st1.executeUpdate();
                st2.executeUpdate();
			}//����߽�ѡ�� ��ѡ�� �����Ŀɾ��
			PreparedStatement st_1 = conn.prepareStatement(sqlrefer);
			PreparedStatement st_2 = conn.prepareStatement(sqlf);
			PreparedStatement st_3 = conn.prepareStatement(sqli);
			PreparedStatement st_4 = conn.prepareStatement(sqldelete);
			st_1.executeUpdate();
			st_2.executeUpdate();
			st_3.executeUpdate();
			st_4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
	}
}
