package com.yrh.jdbc.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.yrh.jdbc.dao.IStudentDao;
import com.yrh.jdbc.dao.impl.StudentDaoImpl;
import com.yrh.jdbc.domain.Student;

public class StudentDaoTest {
//bbb
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		IStudentDao dao = new StudentDaoImpl();// 获取接口对象
		Manager man = new Manager(scan,dao);
		List<Student> studentAll = dao.getAll();// 获取数据库的所以的学生数据
		man.display(studentAll);// 显示所以数据
		while (true) {
			System.out.println("1.新增学生");
			System.out.println("2.修改信息");
			System.out.println("3.删除学生");
			System.out.println("4.降序查看");
			System.out.println("5.退出");
			System.out.println("请输入对应操作");
			int exe = scan.nextInt();
			if (exe == 1) {
				Student stu = man.setStudent();
				// 将学生信息填写到数据库
				dao.save(stu);
				man.display(dao.getAll());// 显示所以数据
			} else if (exe == 2) {
				System.out.println("请输入您要修改的学生编号");
				int index = scan.nextInt();
				// 显示要修改的学生信息
				Student stu = dao.get(index);
				man.display(stu);
				Student stu1 = man.setStudent();

				// 将修改数据库的学生信息
				dao.update(index, stu1);
				man.display(dao.getAll());// 显示所以数据
			} else if (exe == 3) {
				System.out.print("请输入您要删除的学生编号:");
				int index = scan.nextInt();
				// 将删除对应数据库的学生信息
				dao.delete(index);
				man.display(dao.getAll());// 显示所以数据
			} else if (exe == 4) {
				System.out.println("1.按照课程一");
				System.out.println("2.按照课程二");
				System.out.println("3.按照课程三");
				System.out.println("4.按照总分");
				System.out.println("5.返回上层");
				System.out.print("请选择排序条件(降序)：");
				int check = scan.nextInt();
				List<Student> stus = man.Desc(check);
				if(stus!=null) {
					man.display(stus);
				}
			} else if (exe == 5) {
				System.exit(0);
			} else {
				System.out.println("操作错误");
			}
		}

	}

}
