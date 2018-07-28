package com.csu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csu.entity.Choice;
import com.csu.entity.Choice2;
import com.csu.entity.Factor;
import com.csu.entity.MentalScale;
import com.csu.entity.Reference;
import com.csu.entity.ScaleItem;
import com.csu.utils.JDBCUtil;

public class ScaleEditDAO {
	
	//增加一新的测量
	public boolean createNewScale(MentalScale ms){
		Connection conn = JDBCUtil.getConnection();
		String sql =  "insert into tab_mentalscale(S_Name, S_Intro,S_Guide, S_StdScroe,S_FullScore,S_ReportInfo,S_TYPE2,S_TYPE3,S_TYPE4,S_Remark,S_Value,S_Formula,sk_id,updateTime) " + " values('"+ ms.getS_Name() + "', '" + ms.getS_Intro() + "', '" + ms.getS_Guide() + "', " + ms.getS_StdScroe() + ","+null + ","+ ms.getS_ReportInfo() + "," + null + "," + null + "," + null + "," + null +","+ ms.getS_Formula()+",'',"+ms.getSk_id()+",now())";
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
	
	
	//根据名字判断一个量表是否存在
	public boolean checkSname(String sname){
		boolean isExist = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from tab_mentalscale where s_name='"+sname+"'";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				isExist = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return isExist;
		}
		return isExist;
	}
	
	//更新一张量表
	public boolean updateScale(MentalScale ms){
		Connection conn = JDBCUtil.getConnection();
		String sql = "update tab_mentalscale set S_Name= '" + ms.getS_Name() 
		+ "' , S_Intro = '" + ms.getS_Intro() + "' , S_Guide = '" + ms.getS_Guide() + "'"
				+ " , S_StdScroe = '" + ms.getS_StdScroe()+ "' , S_ReportInfo = '" 
		+ ms.getS_ReportInfo()+ "' , S_Value = '"+ms.getS_Value()+"',sk_id ="+ms.getSk_id()+","
				+ "updateTime = now() ,S_TYPE2 = '"+ms.getS_TYPE2()+"' "
						+ "where S_ID = '" + ms.getS_ID() + "' ";
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
	
	//得到一张参考数据表
	public ArrayList<Reference> getRefer(int sid,int fid){
		Connection conn = JDBCUtil.getConnection();
		ArrayList<Reference> list = new ArrayList<Reference>();
		String sql = "select * from tab_refer " + " where S_ID = '" + sid + "' and  F_Num= '" + fid + "' ";
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 while(rs.next()){
				  Reference refer = new Reference();
				  refer.setF_Rid(rs.getInt("F_Rid"));
				  refer.setR_Age1(rs.getInt("R_Age1"));
				  refer.setR_Age2(rs.getInt("R_Age2"));
				  refer.setR_Score1(rs.getInt("R_Score1"));
				  refer.setR_Score2(rs.getInt("R_Score2"));
				  refer.setR_Sex(rs.getString("R_Sex"));
				  refer.setR_Suggestion(rs.getString("R_Suggestion"));
				  list.add(refer);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//添加一张参考数据表
	public boolean addRefer(int sid,int cid,Reference refer){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_refer(S_ID, F_Num, F_Rid, R_Score1, R_Score2, R_Sex,R_Age1, R_Age2, R_Suggestion) " + " values('" + sid + "', '" + cid + "', '" + refer.getF_Rid() + "', '" + refer.getR_Score1() + "', '" + refer.getR_Score2() + "', '" + refer.getR_Sex()+ "', '" + refer.getR_Age1() + "', '" + refer.getR_Age2() + "', '" + refer.getR_Suggestion() + "')";
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
	
	//根据sid查询影响影子数目
	public int getFactorCount(int sid){
		int cnt = 0;
		Connection conn = JDBCUtil.getConnection();
		String sql = "select count(*) from tab_factor where S_ID="+sid;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				cnt = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	//根据sid获得全部的所有结果
	public ArrayList<Object> getScaleItem(int sid){
		ArrayList<Object> al = new ArrayList<Object>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from tab_scaleitem where S_ID="+sid;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
	    		ArrayList<Object> sub = new ArrayList<Object>();
	    		sub.add(rs.getInt("I_ID"));
	    		sub.add(rs.getInt("S_ID"));
	    		sub.add(rs.getString("I_Content"));
	    		sub.add(rs.getInt("I_Factor"));
	    		sub.add(rs.getString("I_TYPE"));
	    		al.add(sub);
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return al;
	}
	
	//根据id查询一个题目的所有的选项的数目
	public int getChoiceCount(int iid){
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		String sql="select count(*) from tab_choice where I_ID ="+iid;
		System.out.println(sql);
		try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			 if(rs.next()){
				 count = rs.getInt("count(*)");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//根据id删除选项
	public boolean deleteChoice(int i_id){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_choice where I_ID = '" + i_id + "'";
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
	
	//根据id删除子选项
	public boolean deleteSubChoice(int i_id){
		Connection conn = JDBCUtil.getConnection();
		String sql = "delete from tab_choice2 where I_ID = '" + i_id + "'";
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
	
	//更新一个影响因子表
	public boolean updateFactor(Factor fa){
		Connection conn = JDBCUtil.getConnection();
		String sql = "update tab_factor set F_Content= '" + fa.getF_Content() + "' , F_Info = '" + fa.getF_Info() + "' , F_Balance = '" + fa.getF_Balance() + "' , F_Den = '" + fa.getF_Den() + "' , F_Formula = '" + fa.getF_Formula() + "' where S_ID = '" + fa.getS_ID() + "' and  F_SNum= '" + fa.getF_SNum() + "' ";
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
	
	//添加一个选项
	public boolean addTableChoice(Choice ch){
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into tab_choice(I_ID, C_Num, C_SubChoice, C_Content, C_Score) " + " values('" + ch.getI_ID() + "', '" + ch.getC_Num() + "', '" + ch.getC_SubChoice() + "', '" + ch.getC_Content() + "', '" + ch.getC_Score() + "'" + ")";
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
	
	
	//添加一个子选项
	 public boolean addSubChoice(Choice2 ch){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "insert into tab_choice2(I_ID, C_Num, C_SubNum, C_Content, C_Score) " + " values('" + ch.getI_ID() + "', '" + ch.getC_Num() + "', '" + ch.getC_SubNum() + "', '" + ch.getC_Content() + "', '" + ch.getC_Score() + "'" + ")";
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
	 
	 //删除一个项目
	 public boolean deleteItem(int iid){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "select * from tab_tresult where I_ID = '" + iid + "'";
         String sqldelete = "delete from tab_scaleitem where I_ID = '" + iid + "'";
         String choicedel = "delete from tab_choice where I_ID = '" + iid + "'";
         String sub_choicedel = "delete from tab_choice2 where I_ID = '" + iid + "'";
         System.out.println(sql);
         System.out.println(sqldelete);
         System.out.println(choicedel);
         System.out.println(sub_choicedel);
         try {
			PreparedStatement stmt1 = conn.prepareStatement(sql);
			stmt1.execute();
			stmt1 = conn.prepareStatement(sqldelete);
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.execute();
			PreparedStatement stmt3 = conn.prepareStatement(sql);
			stmt3 = conn.prepareStatement(choicedel);
			stmt3.execute();
			PreparedStatement stmt4 = conn.prepareStatement(sql);
			stmt4 = conn.prepareStatement(sub_choicedel);
			stmt4.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 return true;
	 }
	 
	 //更新一个量表主题
	 public boolean updateScaleItem(ScaleItem si){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "update tab_scaleitem set I_Content= '" + si.getI_Content() + "' , I_Factor = '" + si.getI_Factor() + "' where I_ID = '" + si.getI_ID() + "' and  S_ID= '" + si.getS_ID() + "' ";
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
	 
	 //根据id查询一个全部量表主题
	 public ArrayList<Object> getItemByIid(int iid){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Object> list = new  ArrayList<Object>();
		 String sql = "select I_Content,I_Factor from tab_scaleitem where I_ID ="+iid;
		 try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 if(rs.next()){
				 list.add(rs.getString("I_Content"));
				 list.add(rs.getInt("I_Factor"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 System.out.println(sql);
		 return list;
	 }
	 
	 //根据id查询所有的选项
	 public ArrayList<Object> getChoiceByIid(int iid){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Object> list = new  ArrayList<Object>();
		 String sql = "select * from tab_choice where I_ID = "+iid+" order by C_Num asc";
		 System.out.println(sql);
		 try {
			PreparedStatement stmt= conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ArrayList<Object> sub = new ArrayList<Object>();
				sub.add(rs.getInt("C_Num"));
				sub.add(rs.getString("C_Content"));
				sub.add(rs.getInt("C_Score"));
				sub.add(rs.getString("C_SubChoice"));
				list.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return list;
	 }
	 
	 //根据sid找到所有的影响因子
	 public ArrayList<Object> getFactorsBySid(int sid){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Object> list = new ArrayList<Object>();
		 String sql = "select * from tab_factor where S_ID="+sid;
		 System.out.println(sql);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ArrayList<Object> sub = new ArrayList<Object>();
				sub.add(rs.getInt("S_ID"));    //量表号
				  sub.add(rs.getInt("F_SNum"));   //因子编号
				  sub.add(rs.getString("F_Content"));  //内容
				  sub.add(rs.getString("F_Info"));   //备注
				  sub.add(rs.getFloat("F_Balance"));  //平衡因子
				  sub.add(rs.getFloat("F_Den"));  // 分母
				  sub.add(rs.getInt("F_ONum"));// 排序号
				  sub.add(rs.getString("F_TYPE"));   //备注
				  list.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return list;
	 }
	 
	 //增加一个测量主题
	 public boolean addScaleItem(ScaleItem si){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Object> list = new ArrayList<Object>();
		 String sql = "insert into tab_scaleitem(I_ID,S_ID, I_Content,I_Factor, I_TYPE) " + " values(" + null + ", '" + si.getS_ID() + "', '" + si.getI_Content() + "', '" + si.getI_Factor() + "', '" + null + "')";
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 return true;
	 }
	 
	 //查找某id测量主题的数目
	 public int getItemCount(int sid){
		 Connection conn = JDBCUtil.getConnection();
		 int count = 0;
		 String sql = "select count(*) from tab_scaleitem where S_ID="+sid;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
	    		count = rs.getInt("count(*)");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	 }
	 
	 //查询sid从i+1到pagesize的问题
	 public List<Object> queryByPage(int i,int pageSize,int sid){
		 Connection conn = JDBCUtil.getConnection();
		 List<Object> al = new ArrayList<Object>();
		 String sql = "select * from tab_scaleitem where S_ID="+sid+" order by I_ID desc limit " + i + "," + pageSize;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
	    		ArrayList<Object> sub = new ArrayList<Object>();
	    		sub.add(rs.getInt("I_ID"));
	    		sub.add(rs.getInt("S_ID"));
	    		sub.add(rs.getString("I_Content"));
	    		sub.add(rs.getInt("I_Factor"));
	    		sub.add(rs.getString("I_TYPE"));
	    		al.add(sub);
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return al;
	 }
	 
	 //根据sid和fid查询影响因子
	 public ArrayList<Object> getFactorsBySidAndFid(int sid,int fid){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Object> list = new ArrayList<Object>();
		 String sql = "select * from tab_factor " + " where S_ID = '" + sid + "' and  F_SNum= '" + fid + "' order by F_SNum asc";
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){			
				  list.add(rs.getInt("S_ID"));    //量表号
				  list.add(rs.getInt("F_SNum"));   //因子编号
				  list.add(rs.getString("F_Content"));  //内容
				  list.add(rs.getString("F_Info"));   //备注
				  list.add(rs.getFloat("F_Balance"));  //平衡因子
				  list.add(rs.getFloat("F_Den"));  // 分母
				  list.add(rs.getInt("F_ONum"));// 排序号
				  list.add(rs.getString("F_TYPE"));   //备注
				  list.add(rs.getString("F_Formula"));   //备注
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return list;
	 }
	 
	 //根据id和cnum的数值统计所有子选项的数目
	 public int getSubChoiceCount(int iid,int cnum){
		 Connection conn = JDBCUtil.getConnection();
		 int count = 0;
		 String sql="select count(*) from tab_choice2 where I_ID ="+iid+" and C_Num="+cnum;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				 count = rs.getInt("count(*)");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	 }
	 
	 //根据id和cnum的数值统计所有子选项的对象
	 public ArrayList<Object> getSubChoiceByIid(int iid,int cnum){
		 Connection conn = JDBCUtil.getConnection();
		 ArrayList<Object> list = new  ArrayList<Object>();
		 String sql = "select * from tab_choice2 where I_ID = "+iid+" and C_Num="+cnum+" order by C_SubNum asc";
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 while(rs.next()){
				 ArrayList<Object> sub = new  ArrayList<Object>();
				 sub.add(rs.getInt("C_SubNum"));
				 sub.add(rs.getString("C_Content"));
				 sub.add(rs.getInt("C_Score"));
				 list.add(sub);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return list;
	 }
	 
	 public int getCidBySid(int sid){
		 Connection conn = JDBCUtil.getConnection();
		 int count = 0;
		 String sql = "select COUNT(*) FROM tab_factor where S_ID = " + sid;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			String f = rs.getString(1);
			count = new Integer(Integer.parseInt(f));
			count++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	 }
	 
	 public boolean deleteFactor(int sid,int snum){
		 Connection conn = JDBCUtil.getConnection();
		 String referdelete="delete from tab_refer where F_Num = '" + snum + "' and S_ID = '" + sid + "'";
	     String sqldelete = "delete from tab_factor where F_SNum = '" + snum + "' and S_ID = '" + sid + "'";
	     String updata = "update tab_factor set F_SNum = F_SNum -1 where F_SNum > " + snum + " and S_ID = " + sid;
	     String uprefer = "update tab_refer set F_Num = F_Num -1 where F_Num > " + snum + " and S_ID = " + sid;
		 System.out.println(referdelete);
		 System.out.println(sqldelete);
		 System.out.println(updata);
		 System.out.println(uprefer);
		 try {
			PreparedStatement stmt1 = conn.prepareStatement(referdelete);
			stmt1.executeUpdate();
			PreparedStatement stmt2 = conn.prepareStatement(sqldelete);
			stmt2.executeUpdate();
			PreparedStatement stmt3 = conn.prepareStatement(updata);
			stmt3.executeUpdate();
			PreparedStatement stmt4 = conn.prepareStatement(uprefer);
			stmt4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	     return true;
	 }
	 
	 public boolean updateRefer(int sid,int fid,List<Reference> list){
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "select * from tab_refer where S_ID='" + sid + "'and F_Num='" + fid + "'";
		 String sqldelete = "delete from tab_refer where S_ID='" + sid + "'and F_Num='" + fid + "'";
		 System.out.println(sql);
		 System.out.println(sqldelete);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			PreparedStatement pt = conn.prepareStatement(sqldelete);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				pt.executeUpdate();
			}
			for(int i = 0 ; i < list.size(); i++) {
				Reference refer = list.get(i);
				if(refer.getR_Suggestion().equals("")||refer.getR_Suggestion()==null||refer.getR_Suggestion()==""){
					break;
				}
				else {
					this.addRefer(sid, fid, refer);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	 }
	 
	 public boolean addFactor(int sid,String content,String info,double balence,double div,String formula){
		 int cid = 0;
		 Connection conn = JDBCUtil.getConnection();
		 String sql = "select COUNT(*) FROM tab_factor where S_ID = " + sid;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.first();
            String f = rs.getString(1);
            cid = new Integer(Integer.parseInt(f));
            cid++;
            String inf = "insert into tab_factor(S_ID, F_SNum, F_Content,F_Info, F_Balance, F_Den, F_ONum, F_TYPE,F_Formula) " + " values('" + sid + "', '" + cid + "', '" + content + "', '" + info + "', '" + balence + "', '" + div + "', " + null + ", " + null + ",'"+formula+"')";
            System.out.println(inf);
            PreparedStatement pt = conn.prepareStatement(inf);
            pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 return true;
	 }
	 
	 public HashMap<Integer, List<Choice2>> getSubByIid(int iid){
		 Connection conn = JDBCUtil.getConnection();
		 HashMap<Integer, List<Choice2>> hm = new HashMap<Integer, List<Choice2>>();
		 String sql = "select * from tab_choice2 where I_ID = "+iid;
		 System.out.println(sql);
		 try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int cnum = rs.getInt("C_Num");
				List<Choice2> al = hm.get(cnum);
				if(al == null) {
					al = new ArrayList<Choice2>();
					hm.put(cnum, al);
				}
				Choice2 ch = new Choice2();
				ch.setC_SubNum(rs.getInt("C_SubNum"));
				ch.setC_Content(rs.getString("C_Content"));
				ch.setC_Score(rs.getInt("C_Score"));
				al.add(ch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 return hm;
	 }
}
