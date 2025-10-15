package com.rays.test;

public class Employee {
	
	private String empName ;
	private int salary ;
	
	public Employee() {
	// TODO Auto-generated constructor stub
	}
	public Employee(String empName, int salary) {
		this.empName = empName ;
		this.salary = salary ;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
