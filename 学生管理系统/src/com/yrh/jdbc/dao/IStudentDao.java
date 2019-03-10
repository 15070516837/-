package com.yrh.jdbc.dao;

import java.util.List;

import com.yrh.jdbc.domain.Student;

public interface IStudentDao {
	//��������
	void save(Student stu);
	//�޸�����
	void update(Integer id,Student stu);
	//ɾ��ָ��ѧ��
	void delete(int id);
	//��ѯָ��ѧ����Ϣ
	Student get(int id);
	//��ѯȫ������
	List<Student> getAll();
	//�����ѯȫ������
	List<Student> getAllAsc(String str);

}
