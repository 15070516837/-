package com.yrh.jdbc.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.yrh.jdbc.dao.IStudentDao;
import com.yrh.jdbc.dao.impl.StudentDaoImpl;
import com.yrh.jdbc.domain.Student;

public class StudentDaoTest {
//aaa
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		IStudentDao dao = new StudentDaoImpl();// ��ȡ�ӿڶ���
		Manager man = new Manager(scan,dao);
		List<Student> studentAll = dao.getAll();// ��ȡ���ݿ�����Ե�ѧ������
		man.display(studentAll);// ��ʾ��������
		while (true) {
			System.out.println("1.����ѧ��");
			System.out.println("2.�޸���Ϣ");
			System.out.println("3.ɾ��ѧ��");
			System.out.println("4.����鿴");
			System.out.println("5.�˳�");
			System.out.println("�������Ӧ����");
			int exe = scan.nextInt();
			if (exe == 1) {
				Student stu = man.setStudent();
				// ��ѧ����Ϣ��д�����ݿ�
				dao.save(stu);
				man.display(dao.getAll());// ��ʾ��������
			} else if (exe == 2) {
				System.out.println("��������Ҫ�޸ĵ�ѧ�����");
				int index = scan.nextInt();
				// ��ʾҪ�޸ĵ�ѧ����Ϣ
				Student stu = dao.get(index);
				man.display(stu);
				Student stu1 = man.setStudent();

				// ���޸����ݿ��ѧ����Ϣ
				dao.update(index, stu1);
				man.display(dao.getAll());// ��ʾ��������
			} else if (exe == 3) {
				System.out.print("��������Ҫɾ����ѧ�����:");
				int index = scan.nextInt();
				// ��ɾ����Ӧ���ݿ��ѧ����Ϣ
				dao.delete(index);
				man.display(dao.getAll());// ��ʾ��������
			} else if (exe == 4) {
				System.out.println("1.���տγ�һ");
				System.out.println("2.���տγ̶�");
				System.out.println("3.���տγ���");
				System.out.println("4.�����ܷ�");
				System.out.println("5.�����ϲ�");
				System.out.print("��ѡ����������(����)��");
				int check = scan.nextInt();
				List<Student> stus = man.Desc(check);
				if(stus!=null) {
					man.display(stus);
				}
			} else if (exe == 5) {
				System.exit(0);
			} else {
				System.out.println("��������");
			}
		}

	}

}
