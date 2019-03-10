package com.yrh.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yrh.jdbc.dao.IStudentDao;
import com.yrh.jdbc.domain.Student;
import com.yrh.jdbc.util.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {

	public void save(Student stu) {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into cj values(?,?,?,?)";
		String sql1 = "insert into Student values(?)";
		// 获取数据库的执行程序
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			// 对第一个sql语句进行连接
			st = conn.prepareStatement(sql);
			st.setDouble(1, stu.getScore()[0]);
			st.setDouble(2, stu.getScore()[1]);
			st.setDouble(3, stu.getScore()[2]);
			st.setDouble(4, stu.getSum());

			// 对第二个sql语句进行拼接
			st1 = conn.prepareStatement(sql1);
			st1.setString(1, stu.getName());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(sql);
			int Update = st.executeUpdate();
			int Update1 = st1.executeUpdate();
			System.out.println(Update);
			System.out.println(Update1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道流
			JDBCUtil.close(conn, st, null);
		}
	}

	@Override
	public void update(Integer sno, Student stu) {
		Connection conn = JDBCUtil.getConn();

		String sql = "update  Student set name=? where cj=?";
		String sql1 = "update  cj set language=?,mathe=?,english=?,sum=? where ID=?";

		// 获取数据库的执行程序
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, stu.getName());
			st.setInt(2, sno);

			st1 = conn.prepareStatement(sql1);
			st1.setDouble(1, stu.getScore()[0]);
			st1.setDouble(2, stu.getScore()[1]);
			st1.setDouble(3, stu.getScore()[2]);
			st1.setDouble(4, stu.getSum());
			st1.setInt(5, sno);
			int Update = st.executeUpdate();
			int Update1 = st1.executeUpdate();
			System.out.println(Update);
			System.out.println(Update1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道流
			JDBCUtil.close(conn, st, null);
		}

	}

	@Override
	public void delete(int sno) {
		Connection conn = JDBCUtil.getConn();

		String sql = "delete Student where cj=?";
		String sql1 = "delete cj where ID=?";
		// 获取数据库的执行程序
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, sno);

			st1 = conn.prepareStatement(sql1);
			st1.setInt(1, sno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(sql);
			int Update = st.executeUpdate();
			int Update1 = st1.executeUpdate();
			System.out.println(Update1);
			System.out.println(Update);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道流
			JDBCUtil.close(conn, st, null);
		}

	}

	@Override
	public Student get(int ID) {
		Connection conn = JDBCUtil.getConn();

		String sql = "select * from Student s,cj c where s.cj=c.ID and cj=?";

		// 获取数据库的执行程序
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;
		Student stu = null;
		try {
			System.out.println(sql);
			rs = st.executeQuery();
			stu = new Student();

			if (rs.next()) {
				stu.setName(rs.getString("name"));

				stu.setId(rs.getInt("ID"));
				// 创建一个成绩数组
				double[] score = new double[3];
				score[0] = rs.getDouble("language");
				score[1] = rs.getDouble("mathe");
				score[2] = rs.getDouble("english");
				stu.setScore(score);

				stu.setSum(rs.getDouble("sum"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道流
			JDBCUtil.close(conn, st, rs);
		}
		return stu;
	}

	@Override
	public List<Student> getAll() {
		Connection conn = JDBCUtil.getConn();

		String sql = "select * from Student s,cj c where s.cj=c.ID ";
		// 获取数据库的执行程序
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		try {
			System.out.println(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));

				stu.setId(rs.getInt("ID"));
				// 创建一个成绩数组
				double[] score = new double[3];
				score[0] = rs.getDouble("language");
				score[1] = rs.getDouble("mathe");
				score[2] = rs.getDouble("english");
				stu.setScore(score);

				stu.setSum(rs.getDouble("sum"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道流
			JDBCUtil.close(conn, st, rs);
		}
		return list;

	}

	@Override
	public List<Student> getAllAsc(String str) {
		Connection conn = JDBCUtil.getConn();
		// 获取数据库的执行程序
		Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select * from Student s,cj c where s.cj=c.ID order by " + str + " desc";
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		try {
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));

				stu.setId(rs.getInt("ID"));
				// 创建一个成绩数组
				double[] score = new double[3];
				score[0] = rs.getDouble("language");
				score[1] = rs.getDouble("mathe");
				score[2] = rs.getDouble("english");
				stu.setScore(score);

				stu.setSum(rs.getDouble("sum"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道流
			JDBCUtil.close(conn, st, rs);
		}
		return list;
	}

}
