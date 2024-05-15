package com.anudip.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anudip.Entity.Department;
import com.anudip.Exception.IdNotFoundException;
import com.anudip.Repository.DepatmentRepository;
import com.anudip.Service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepatmentRepository drepo;
	@Override
	public Department addDepartments(Department department) {
		return drepo.save(department);
	}

	@Override
	public Department getDepartmentsDetail(int did) {
		return drepo.findById(did).orElseThrow(()-> new IdNotFoundException("Department id is incorrect"));
	}

	@Override
	public Department updateDepartmentsDetail(Department department, int did) {
		Department updatedDepartment = drepo.findById(did).orElseThrow(()-> new IdNotFoundException("Department id is incorrect"));

		//set new values
		updatedDepartment.setDid(department.getDid());
		updatedDepartment.setDeptName(department.getDeptName());
		updatedDepartment.setOnOfEmpl(department.getOnOfEmpl());
		updatedDepartment.setLabNo(department.getLabNo());
		updatedDepartment.setDphone(department.getDphone());
		updatedDepartment.setDeptHODName(department.getDeptHODName());
		drepo.save(updatedDepartment);
		return updatedDepartment;
	}

	@Override
	public void deleteDepartmentsDetail(int did) {
		drepo.findById(did).orElseThrow(()-> new IdNotFoundException("Department id is incorrect"));
		drepo.deleteById(did);
		
	}
	
	@Override
	public List<Department> getAllDepartment() {
		return drepo.findAll();
	}
}
