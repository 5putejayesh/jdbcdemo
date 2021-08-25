package comp.demoSerializable;

import java.io.Serializable;

public class Employee implements Serializable {
	private long id;
	private String name;
	private String role;
	private double salary;
	private transient int age; // trasient or static will not serialized as static belong 
								//to class.

	public Employee(long id, String name, String role, double salary, int age) {
		
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.age = age;
		
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", age=" + age + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
