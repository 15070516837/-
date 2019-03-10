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
	
	//填写学生信息
	public Student setStudent() {
		Student stu =new Student();
		//填写学生信息
		System.out.print("请输入学生姓名：");
		stu.setName(scan.next());
		double[] score=new double[3];
		System.out.println("请输入该学生3科成绩：");
		for(int i=0;i<score.length;i++) {
			score[i]=scan.nextDouble();
		}
		stu.setScore(score);
		double sum=0;//记录3科总分
		for(int i=0;i<score.length;i++) {
			sum+=score[i];
		}
		stu.setSum(sum);
		return stu;
	}
	
	// 显示所有信息成绩的方法
	public void display(List<Student> stus) {
		System.out.println("编号\t姓名\t课程1\t课程2\t课程3\t总分");
		for (int i = 0; i < stus.size(); i++) {
			System.out.println(stus.get(i).getSno() + "\t" + stus.get(i).getName() + "\t" + stus.get(i).getScore()[0] + "\t"
					+ stus.get(i).getScore()[1] + "\t" + stus.get(i).getScore()[2] + "\t" + stus.get(i).getSum());
		}
	}
	public void display(Student stu) {
		System.out.println("编号\t姓名\t课程1\t课程2\t课程3\t总分");
		
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
