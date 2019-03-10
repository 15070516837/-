package com.yrh.jdbc.dao;

import java.util.List;

import com.yrh.jdbc.domain.Student;

public interface IStudentDao {
	//保存数据
	void save(Student stu);
	//修改数据
	void update(Integer id,Student stu);
	//删除指定学生
	void delete(int id);
	//查询指定学生信息
	Student get(int id);
	//查询全部数据
	List<Student> getAll();
	//降序查询全部数据
	List<Student> getAllAsc(String str);

}
