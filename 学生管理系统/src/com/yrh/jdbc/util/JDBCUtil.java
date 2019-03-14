package com.yrh.jdbc.util;

import java.sql.*;

public class JDBCUtil {
	public static String url = "jdbc:sqlserver://localhost:1433;databaseName=Student3";
	public static String user = "sa";
	public static String password = "libin520";
	
	//加载驱动程序
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取Connection（数据库）对象
	public static Connection getConn() {
		try {
			//连接数据库
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 提供关闭方法
	public static void close(Connection conn,Statement st,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
