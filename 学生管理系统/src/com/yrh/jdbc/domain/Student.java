package com.yrh.jdbc.domain;

public class Student {
	Integer sno;
	String name;
	double[] score = new double[3];
	private double sum;
	
	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public double[] getScore() {
		return score;
	}

	public void setScore(double[] score) {
		this.score = score;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum=sum;
	}

	public Integer getId() {
		return sno;
	}

	public void setId(Integer id) {
		this.sno = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name  +  "]";
	}

}
