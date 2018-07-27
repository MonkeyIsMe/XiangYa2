package com.csu.utils;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
 
public class JDBCUtil {
 
	private static DataSource dataSource=null;
	static{
		dataSource=new ComboPooledDataSource("mysql");
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			 conn=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
 
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void closeConn(Connection conn){
		try {
			if(conn!=null && conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
	 public ArrayList<Object> getTable(String query) {
	        ResultSetMetaData rsmd;
	        ArrayList<Object> result = new ArrayList<Object>();
	        try {
	            Statement statement = conn.createStatement();
	            rs = statement.executeQuery("SELECT * FROM " + query);
	            rsmd = rs.getMetaData();
	            int ColCount = rsmd.getColumnCount();//
	            while(rs.next()){
	            	ArrayList<Object> newrow = new ArrayList<Object>();
	            	for (int i = 1; i <= ColCount; i++) {
	            		newrow.add(rs.getString(i));
	            	}
	            	result.add(newrow);
	            }
	        } catch (SQLException sqlex) {
	            sqlex.printStackTrace();
	        }
	        return result;
	    }

	    public ArrayList<Object> getTable(String query, int sid) {
	        ResultSetMetaData rsmd;
	        ArrayList<Object> result = new ArrayList<Object>();
	        try {
	            Statement statement = conn.createStatement();
	            rs = statement.executeQuery("SELECT * FROM " + query + " where S_ID = " + sid);
	            rsmd = rs.getMetaData();
	            int ColCount = rsmd.getColumnCount();
	            while(rs.next()){
		            ArrayList<Object> newrow = new ArrayList<Object>();
		            for (int i = 1; i <= ColCount; i++) {
		              newrow.add(rs.getString(i));
		            }
		            result.add(newrow);
	            }
	            return result;
	        } catch (SQLException sqlex) {
	            sqlex.printStackTrace();
	            return null;
	        }
	    }
}
