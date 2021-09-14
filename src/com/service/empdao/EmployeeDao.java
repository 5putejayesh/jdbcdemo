package com.service.empdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.JDBCUtil;
import com.dao.Dao;
import com.entity.Employee;

public class EmployeeDao implements Dao {
	PreparedStatement preparedStatement;

	@Override
	public Employee getEmployee(int id) {

		String sql = "select * from jdbc_employees where emp_id=?";
		try (Connection connection = JDBCUtil.getConnection()) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return getEmpFromResultSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmpFromResultSet(ResultSet resultSet) throws SQLException {
		Employee employee = new Employee();
		employee.setEmp_Id(resultSet.getInt(1));
		employee.setEmp_Name(resultSet.getString(2));
		employee.setEmp_Salary(resultSet.getString(3));
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		String sql = "select * from jdbc_employees order by emp_id";
		try (Connection connection = JDBCUtil.getConnection()) {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = getEmpFromResultSet(resultSet);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public int createEmployee(Employee employee) {
		String sql = "insert into jdbc_employees (emp_id,emp_name,emp_salary)  values(?,?,?)";
		try (Connection connection = JDBCUtil.getConnection()) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getEmp_Id());
			preparedStatement.setString(2, employee.getEmp_Name());
			preparedStatement.setString(3, employee.getEmp_Salary());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update jdbc_employees set emp_name=?,emp_salary=? where emp_id=?";
		try (Connection connection = JDBCUtil.getConnection()) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getEmp_Name());
			preparedStatement.setString(2, employee.getEmp_Salary());
			preparedStatement.setInt(3, employee.getEmp_Id());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
