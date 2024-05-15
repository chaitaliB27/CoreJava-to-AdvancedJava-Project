package com.anudip.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.Entity.Department;
import com.anudip.Service.DepartmentService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/HospitalManagementSystem/Department")
public class DepartmentController {
	@Autowired
	DepartmentService ds;
	@PostMapping("/departments")

	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
		return new ResponseEntity<Department>(ds.addDepartments(department),
				HttpStatus.CREATED);
	}
	@GetMapping("/departments/{did}")

	public ResponseEntity<Department> getDepartment(@PathVariable("did") int did){
			return new ResponseEntity<Department>(ds.getDepartmentsDetail(did),HttpStatus.OK);
		}
	@DeleteMapping("/departments/{did}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("did") int did){
		ds.deleteDepartmentsDetail(did);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}
	 @PutMapping("/departments/{did}")
	public ResponseEntity<Department> editDepartment(@Valid @PathVariable("did") int did, @RequestBody Department department){
		return new ResponseEntity<Department>(ds.updateDepartmentsDetail(department, did), HttpStatus.OK);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartment(){
		return ds.getAllDepartment();
	}
}
