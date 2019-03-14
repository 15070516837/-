package com.yrh.jdbc.util;

import java.sql.*;

public class JDBCUtil {
	public static String url = "jdbc:sqlserver://localhost:1433;databaseName=Student3";
	public static String user = "sa";
	public static String password = "libin520";
	
	//������������
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡConnection�����ݿ⣩����
	public static Connection getConn() {
		try {
			//�������ݿ�
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// �ṩ�رշ���
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
