package com.mini.dao;

import com.mini.pojo.Employee;   

public interface EmployeeDao {
	
	public boolean addEmployee(Employee e);   //Employee's object store employee details in this method
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(int empId);
	/*
	 * searchEmployeeById will return whole object(All information of Employee) of class having user-given ID
	 * So its returntype will be its class i.e. Employee.
	 */
	public Employee searchEmployeeById(int empId);
	/*
	 * showAllEmployee will return All information of All Employeesi.e. whole Array.
	 * So its returntype will be Array which stores all objects of class i.e. Employee [].
	 */
	public Employee [] showAllEmployee();
}
