package com.dao;

import java.util.List;

import com.entity.Employee;

public interface Dao {

	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
	int ceateEmployee(Employee employee);
	int updateEmployee(Employee employee);
}
