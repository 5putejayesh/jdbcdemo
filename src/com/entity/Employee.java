package com.entity;

public class Employee {
	
	private int emp_Id;
	private String emp_Name;
	private String emp_Salary;
	
	public Employee(){
		
	}
	public Employee(int emp_Id, String emp_Name, String emp_Salary) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_Salary = emp_Salary;
	}

	public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_Salary() {
		return emp_Salary;
	}

	public void setEmp_Salary(String emp_Salary) {
		this.emp_Salary = emp_Salary;
	}

	@Override
	public String toString() {
		return  emp_Id + "\t"+emp_Name+"\t"+emp_Salary;
	}
	
	
	
}
