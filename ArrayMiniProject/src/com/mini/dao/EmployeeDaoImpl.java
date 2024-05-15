package com.mini.dao;

import com.mini.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	//we create Employee type array, coz we are storing objects of Employee type in this.
	Employee [] empList=new Employee[50];
	int index=0;
	
	@Override
	public boolean addEmployee(Employee e) {
		
		if(index<50) {
			
			empList[index]=e;
			index++; 
			
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		
		for(int i=0; i<empList.length; i++) {
			
			if(empList[i].getEmpId()==e.getEmpId()) {
				
				empList[i]=e;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		/*for(Employee emp:empList) {
			
			if(emp!=null) {
				
				int id = emp.getEmpId();  //getting empId from empList
				if(id==empId) {   //if user input empId matches the previously stored empId.
					
					Employee[] newEmpList = new Employee[empList.length];  //created newEmpList array of Employee type whose size is equal to empList
					
					for(int i=0; i<empList.length; i++) {
						
						if(empList[i]!=emp) {   //if Employee object at index i in the empList array is not equal to a specific emp object
							
							newEmpList[i] = empList[i];   //Copying objects of empList to newEmpList excluding matching empId.
						}
					}
					empList = newEmpList;
					return true;
				}
			}
		}*/
		
		for(int i=0; i<empList.length; i++) {
			Employee emp=empList[i];
			
			if(emp!=null) {
				int id=emp.getEmpId();
				if( id==empId) {
				
					empList[i]=null;
					return true;
				}
			
			}
		}
		return false;
	}

	@Override
	public Employee searchEmployeeById(int empId) {
		for(Employee emp:empList) {
			
			if(emp!=null) {
				int id=emp.getEmpId();	//getting the id of the employee object recieved from array
				if( id==empId) {	//checking if the object has the same id as the user given id
				
					return emp;	//if they match we are returning that employee object
				}
			
			}
		}
		return null;
	}

	@Override
	public Employee[] showAllEmployee() {
		
		return empList;
	}

	public Employee searchEmployeeByName(String name) {
		for(Employee emp : empList){
			
            if(emp != null){
            	
                if(emp.getEmpName().equalsIgnoreCase(name)){
                	
                    return emp;
                }
            }
        }
		return null;
	}

	public LoginDaoImpl makeObject() {
	
		return new LoginDaoImpl(empList);
	}

	
}
