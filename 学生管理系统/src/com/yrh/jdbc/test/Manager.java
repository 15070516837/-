package com.yrh.jdbc.test;

import java.util.List;
import java.util.Scanner;

import com.yrh.jdbc.dao.IStudentDao;
import com.yrh.jdbc.domain.Student;

public class Manager {
	Scanner scan;
	IStudentDao dao;
	public Manager(Scanner scan,IStudentDao dao) {
		this.scan=scan;
		this.dao=dao;
	}
	
	//��дѧ����Ϣ
	public Student setStudent() {
		Student stu =new Student();
		//��дѧ����Ϣ
		System.out.print("������ѧ��������");
		stu.setName(scan.next());
		double[] score=new double[3];
		System.out.println("�������ѧ��3�Ƴɼ���");
		for(int i=0;i<score.length;i++) {
			score[i]=scan.nextDouble();
		}
		stu.setScore(score);
		double sum=0;//��¼3���ܷ�
		for(int i=0;i<score.length;i++) {
			sum+=score[i];
		}
		stu.setSum(sum);
		return stu;
	}
	
	// ��ʾ������Ϣ�ɼ��ķ���
	public void display(List<Student> stus) {
		System.out.println("���\t����\t�γ�1\t�γ�2\t�γ�3\t�ܷ�");
		for (int i = 0; i < stus.size(); i++) {
			System.out.println(stus.get(i).getSno() + "\t" + stus.get(i).getName() + "\t" + stus.get(i).getScore()[0] + "\t"
					+ stus.get(i).getScore()[1] + "\t" + stus.get(i).getScore()[2] + "\t" + stus.get(i).getSum());
		}
	}
	public void display(Student stu) {
		System.out.println("���\t����\t�γ�1\t�γ�2\t�γ�3\t�ܷ�");
		
			System.out.println(stu.getSno() + "\t" + stu.getName() + "\t" + stu.getScore()[0] + "\t"
					+ stu.getScore()[1] + "\t" + stu.getScore()[2] + "\t" + stu.getSum());
		
	}
	public List<Student> Desc(int check){
		if(check==1) {
			return dao.getAllAsc("language");
		}if(check==2) {
			return dao.getAllAsc("mathe");
		}if(check==3) {
			return dao.getAllAsc("english");
		}if(check==4) {
			return dao.getAllAsc("sum");
		}else {
			return null;
		}
	}
}
