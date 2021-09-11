package com.jdbcdemo;

import java.util.List;
import java.util.Scanner;

import com.dao.Dao;
import com.empdao.EmployeeDao;
import com.model.Employee;

public class EmployeeApp {

	public static EmployeeDao getEmpService() {
		return new EmployeeDao();
	}

	public static void main(String[] args) {

		Dao empDAO = getEmpService();
		int id;
		String name;
		String salary;
		Employee employee;
		List<Employee> allEmployee;

		/*
		 * System.out.println(empDAO.getEmployee(1)); System.out.println();
		 * List<Employee> allEmployee = empDAO.getAllEmployees();
		 * 
		 * allEmployee.forEach((e) -> System.out.println(e));
		 * 
		 * employee = new Employee(3, "Abhi", "1500000");
		 * 
		 * System.out.println(empDAO.ceateEmployee(employee) > 0 ? "inserted" :
		 * "not inserted");
		 */

		Scanner scanner = new Scanner(System.in);
		char ch;
		do {
			System.out.println("Employee Curd Operations: ");
			System.out.println("1.Create  Employee");
			System.out.println("2.Get  Employee");
			System.out.println("3.Update Employee by ID");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Emp Id");
				id = scanner.nextInt();
				System.out.println("Enter Emp Name");
				name = scanner.next();
				System.out.println("Enter Emp Salary");
				salary = scanner.next();
				employee = new Employee(id, name, salary);

				empDAO.ceateEmployee(employee);
				break;
			case 2:
				System.out.println("\t 1.For Specific Employee By ID");
				System.out.println("\t 2.For All Employee");
				int ch1 = scanner.nextInt();
				switch (ch1) {
				case 1:
					System.out.println("Enter ID: ");
					id = scanner.nextInt();
					employee = empDAO.getEmployee(id);
					System.out.println(employee != null ? employee : "Not a valid ID");
					break;
				case 2:
					allEmployee = empDAO.getAllEmployees();
					allEmployee.forEach((emp) -> System.out.println(emp));
					break;
				default:
					break;
				}
				break;
			case 3:
				System.out.println("enter ID to update Employee: ");
				id = scanner.nextInt();
				employee = new Employee();

				System.out.println("enter new name for id :" + id);
				name = scanner.next();

				System.out.println("enter new salary for id :" + id);
				salary = scanner.next();

				employee.setEmp_Id(id);
				employee.setEmp_Name(name);
				employee.setEmp_Salary(salary);
				System.out.println(empDAO.updateEmployee(employee) > 0 ? "Updated" : "Not a valid Employee iD");
				break;
			default:
				break;
			}
			System.out.println("Do you want to continue (Type y or n)");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		scanner.close();
	}

}
