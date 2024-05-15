package com.anudip.Service;

import java.util.List;

import com.anudip.Entity.Department;

public interface DepartmentService {
   Department addDepartments(Department department);
	
	//method to fetch Students detail based on sid from db table
	Department getDepartmentsDetail(int did);
	
	//method to modify Students detail based on sid from db table
	Department updateDepartmentsDetail(Department department, int did);
	
	//method to remove Students detail based on sid from db table
	void deleteDepartmentsDetail(int did);
	
	List<Department> getAllDepartment();
}
