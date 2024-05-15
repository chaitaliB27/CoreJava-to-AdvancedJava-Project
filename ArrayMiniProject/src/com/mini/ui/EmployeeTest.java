package com.mini.ui;

import java.util.Arrays;

import java.util.Scanner;
import com.mini.dao.EmployeeDaoImpl;
import com.mini.pojo.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		boolean exit=false;
		boolean flag;
		int empId=101;
		String empName;
		String designation;
		double salary;
		String choice;
		
		Employee e=null;
		EmployeeDaoImpl eimpl=new EmployeeDaoImpl();
		Employee[] emplist=null;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("***********Welcome to SocialEmp************");
		
		while(exit==false) {
			
			System.out.println("\nPlease enter the number as given in option...");
			System.out.println("1-------> Register employee");
			System.out.println("2-------> Show all employees");
			System.out.println("3-------> Search employee by id");
			System.out.println("4-------> Search employee by name");
			System.out.println("5-------> Update employee detail");
			System.out.println("6-------> Delete employee profile");
			System.out.println("7-------> Exit");
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				System.out.print("Enter your name: ");
				empName=sc.nextLine();
				
				System.out.print("Enter your designation: ");
				designation=sc.nextLine();
				
				System.out.print("Enter your salary: ");
				salary=sc.nextDouble();
				sc.nextLine();
				
				empId+=8;  //randomly generated EmpId
				
				e=new Employee(empId, empName, designation, salary); //object of Employee class
				
				flag=eimpl.addEmployee(e); //calling method addEmployee() by passing parameter as e (object of Employee Class)
				if(flag) {
					System.out.println("Employee registered Successfully!!!");
					//System.out.println(Arrays.toString(eimpl.showAllEmployee()));
				}
				else
					System.err.println("Error while adding employee!!!");  //err is for error which shows text in red color.
				break;
				
			case 2:
				emplist=eimpl.showAllEmployee();
				boolean flag2=false;
				for(Employee e1:emplist) {
					if(e1!=null) {
						flag2=true;
						System.out.println(e1);
						System.out.println("_______________________________");
					}
				}
				
				if(flag2==false)
					System.out.println("No employees registered yet!!!");
				
				//System.out.println("*************All employee details***********");
				//System.out.println(Arrays.toString(eimpl.showAllEmployee()));
			
				break;
				
			case 3:
				System.out.print("Enter the id of employee to be searched: ");
				int id=sc.nextInt();
				sc.nextLine();
				
				e=eimpl.searchEmployeeById(id);
				
				if(e!=null) {
					System.out.println("The employee found with given id:-\n"+e);
				}
				else {
					
					System.out.println("Sorry we could not find any employee with this id");
				}
				
				break;
				
			case 4: 
                System.out.println("Enter the name of employee to be searched: ");
                String name = sc.nextLine();
                e = eimpl.searchEmployeeByName(name);
              
                if(e != null){
                	
                	System.out.println("The employee found with given name: \n"+e);
                }
                else{
                	
                	System.out.println("Sorry we could not find any employee with given name.");
                }
                break;
                
			case 5:
				System.out.print("Enter id of employee to be updated: ");
				id=sc.nextInt();
				sc.nextLine();
				
				e=eimpl.searchEmployeeById(id);
				
				if(e!=null) {
					
					System.out.println("****The profile******");
					System.out.println(e);
					
					System.out.println("\nAre you sure you want to update this profile?");
					System.out.println("Answer in yes or no");
					choice=sc.next();
					sc.nextLine();
					
					if(choice.equalsIgnoreCase("yes")) {
						System.out.println("Please select one option as given below: ");
	                    System.out.println("1--->Update employee name");
	                    System.out.println("2--->Update employee designation");
	                    System.out.println("3--->Update employee salary");
	                    System.out.println("4--->Update all details");
	                    System.out.println("5--->Update employee name and designation");
	                    System.out.println("6--->Update employee designation and salary");
	                    System.out.println("7--->Update employee name and salary");
	                  
	                    int selection = sc.nextInt();
	                    sc.nextLine();
	                  
	                    switch(selection){
	                    
		                      case 1: 
		                      System.out.println("Enter your name: ");
		                      e.setEmpName(sc.nextLine());
		                      break;
		                    
		                      case 2:
		                      System.out.println("Enter your designation:");
		                      e.setDesignation(sc.nextLine());
		                      break;
		                    
		                      case 3:
		                      System.out.println("Enter your salary:");
		                      e.setSalary(sc.nextDouble());
		                      break;
		                    
		                      case 4:
		                      System.out.println("Enter your name: ");
		                      e.setEmpName(sc.nextLine());
		                    
		                      System.out.println("Enter your designation:");
		                      e.setDesignation(sc.nextLine());
		                    
		                      System.out.println("Enter your salary:");
		                      e.setSalary(sc.nextDouble());
		                      break;
		                    
		                      case 5:
		                      System.out.println("Enter your name: ");
		                      e.setEmpName(sc.nextLine());
		                    
		                      System.out.println("Enter your designation:");
		                      e.setDesignation(sc.nextLine());
		                      break;
		                    
		                      case 6:
		                      System.out.println("Enter your designation:");
		                      e.setDesignation(sc.nextLine());
		                    
		                      System.out.println("Enter your salary:");
		                      e.setSalary(sc.nextDouble());
		                      break;
		                    
		                      case 7:
		                      System.out.println("Enter your name: ");
		                      e.setEmpName(sc.nextLine());
		                    
		                      System.out.println("Enter your salary:");
		                      e.setSalary(sc.nextDouble());
		                      break;
	                    }
						
						flag=eimpl.updateEmployee(e);
						if(flag)
							System.out.println("Employee updated successfully");
						else
							System.out.println("Error while updating employee profile!!");
					}
					else
						System.out.println("No problem. Please continue browsing!!");
				}
				else
					System.out.println("No employee of this id found!!");
				
				break;
			
			case 6:
				/*System.out.println("Enter the Id of employee to be deleted: ");
				empId = sc.nextInt();
				sc.nextLine();
				
				
				  flag = eimpl.deleteEmployee(empId); 
				  
				  if(flag) {
				  
					  System.out.println("Employee deleted successfully!!!");
					  //System.out.println(Arrays.toString(eimpl.showAllEmployee())); 
					  
				  } 
				  else
					  System.err.println("Error while deleting employee!!!");
				 */
				
				e=eimpl.searchEmployeeById(empId);
				
				if(e!=null) {
					
					System.out.println("******The profile********");
					System.out.println("Enter the Id of employee to be deleted: ");
					empId = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Are you sure you want to delete this Profile?");
					System.out.println("Answer in yes or no");
					choice=sc.next();
					sc.nextLine();
					
					if(choice.equalsIgnoreCase("yes")) {
						
						flag=eimpl.deleteEmployee(empId);
						
						if(flag)
							System.out.println("Employee deleted successfully");
						else
							System.out.println("Error while deleting employee!!");
					}
					else
						System.out.println("No problem. Please continue browsing!!");
				}
				else
					System.out.println("No employee of this id found!!");
				
				break;
			
			case 7:
				exit=true;
				
				System.out.println("Thank you...\nvisit again soon...!");
				break;
			}
		}

	}

}
