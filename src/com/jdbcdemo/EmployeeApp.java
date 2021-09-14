package com.jdbcdemo;

import java.util.List;
import java.util.Scanner;

import com.dao.Dao;
import com.entity.Employee;
import com.service.empdao.EmployeeDao;

public class EmployeeApp {
	Dao empDAO = getEmpService();
	Employee employee;
	List<Employee> allEmployee;

	public static EmployeeDao getEmpService() {
		return new EmployeeDao();
	}

	public void saveEmployee(Employee employee) {
		int createEmployee = empDAO.createEmployee(employee);

		if (createEmployee > 0)
			System.out.println("Employee created.");
		else
			System.out.println("Employee not created.");
	}

	public void getEmployee(int id) {
		employee = empDAO.getEmployee(id);
		System.out.println(employee != null ? employee : "Not a valid ID");
	}

	public void getAllEmployee() {

		allEmployee = empDAO.getAllEmployees();
		allEmployee.forEach((emp) -> System.out.println(emp));

	}

	public void updateEmployee(Employee employee) {
		System.out.println(empDAO.updateEmployee(employee) > 0 ? "Updated" : "Not a valid Employee Id");
	}

	public static void main(String[] args) {

		Dao empDAO = getEmpService();
		EmployeeApp employeeApp = new EmployeeApp();
		int id;
		String name;
		String salary;

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

				employeeApp.saveEmployee(new Employee(id, name, salary));
				break;
			case 2:
				System.out.println("\t 1.For Specific Employee By ID");
				System.out.println("\t 2.For All Employee");
				int ch1 = scanner.nextInt();
				switch (ch1) {
				case 1:
					System.out.println("Enter ID: ");
					id = scanner.nextInt();
					employeeApp.getEmployee(id);
					break;
				case 2:
					employeeApp.getAllEmployee();
					break;
				default:
					break;
				}
				break;
			case 3:
				System.out.println("enter ID to update Employee: ");
				id = scanner.nextInt();

				System.out.println("enter new name for id :" + id);
				name = scanner.next();

				System.out.println("enter new salary for id :" + id);
				salary = scanner.next();

				employeeApp.updateEmployee(new Employee(id, name, salary));
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
