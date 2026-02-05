package com.studentanagement;

public class Student {
	private int id;
	private String name;
	private int marks;
	private double cgpa;
	
	public Student(int id, String name, int marks, double cgpa) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.cgpa = cgpa;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public double getCgpa() {
		return cgpa;
	}
	
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
}
