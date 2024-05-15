package com.mini.ui;

import java.util.Scanner;

import com.mini.dao.*;
import com.mini.pojo.*;

public class EmployeeTest2 {

	public static void main(String[] args) {
		boolean exit=false, logout=true;
		boolean flag;
		int empId=101, id;
		String empName;
		String designation;
		double salary;
		String choice;
		String username;
		String password;
		
		Employee e=null;
		EmployeeDaoImpl eimpl=new EmployeeDaoImpl();
		Employee[] emplist=null;
		
		
		Scanner sc=new Scanner(System.in);
		while(logout) {
			
			System.out.println("Enter 1 to Login");
			System.out.println("Enter 2 to Register");
			int i=sc.nextInt();
			sc.nextLine();
			
			if(i==1) {
				LoginDaoImpl limpl=eimpl.makeObject();  //Creating LoginDaoImpl object here 
				
				System.out.print("Enter username: ");
				username=sc.nextLine();
				
				System.out.print("Enter password: ");
				password=sc.nextLine();
				
				if(limpl.adminLogin(username, password)) {
					System.out.println("You have logged in as admin!!!");
					while(exit==false) {
						
						System.out.println("1-----> Show all employees");
						System.out.println("2-----> Delete an employee profile");
						System.out.println("3-----> Logout");
						int option=sc.nextInt();
						sc.nextLine();
						
						switch(option) {
						case 1:
							emplist=limpl.empList;
							
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
								
							break;
						case 2:
							
							System.out.print("Enter id of employee to be deleted: ");
							id=sc.nextInt();
							sc.nextLine();
							
							e=eimpl.searchEmployeeById(id);
							
							if(e!=null) {
								
								System.out.println("****The profile******");
								System.out.println(e);
								
								System.out.println("Are you sure you want to delete this profile?");
								System.out.println("Answer in yes or no");
								choice=sc.next();
								sc.nextLine();
								
								if(choice.equalsIgnoreCase("yes")) {
									
									flag=eimpl.deleteEmployee(id);
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
						case 3:
							exit=true;
							System.out.println("You have logged out successfully!!!");
							break;
						}
					}
				}
				else if(limpl.employeeLogin(username, password)) {
					System.out.println("*********Welcome to SocialEmp*********");
					exit=false;
					while(exit==false) {
						System.out.println("\nPlease enter the number as given in option...");
						
						System.out.println("1--------> Show all employees");
						System.out.println("2--------> Search employee by id");
						System.out.println("3-------> Search employee by name");
						System.out.println("4--------> Update employee detail");
						System.out.println("5--------> Delete employee profile");
						System.out.println("6--------> Exit");
						
						int option=sc.nextInt();
						sc.nextLine();
						
						switch(option) {
						
						case 1:
							emplist=limpl.empList;
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
								break;
													
						case 2:
							System.out.print("Enter the id of employee to be searched: ");
							id=sc.nextInt();
							sc.nextLine();
							
							e=eimpl.searchEmployeeById(id);
							
							if(e!=null) {
								System.out.println("The employee found with given id:-\n"+e);
							}
							else {
								
								System.out.println("Sorry we could not find any employee with this id");
							}
							
							break;
						
						case 3:
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
						case 4:
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
									System.out.print("Enter your name: ");
									empName=sc.nextLine();
									
									System.out.print("Enter your designation: ");
									designation=sc.nextLine();
									
									System.out.print("Enter your salary: ");
									salary=sc.nextDouble();
									sc.nextLine();
									
									e.setDesignation(designation);
									e.setEmpName(empName);
									e.setSalary(salary);
									
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
						
						case 5:
							System.out.print("Enter id of employee to be deleted: ");
							id=sc.nextInt();
							sc.nextLine();
							
							e=eimpl.searchEmployeeById(id);
							
							if(e!=null) {
								
								System.out.println("****The profile******");
								System.out.println(e);
								
								System.out.println("Are you sure you want to delete this profile?");
								System.out.println("Answer in yes or no");
								choice=sc.next();
								sc.nextLine();
								
								if(choice.equalsIgnoreCase("yes")) {
									
									flag=eimpl.deleteEmployee(id);
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
							
						case 6:
							exit=true;
							System.out.println("You have logged out successfully!! Thankyou visit again soon!!!");
							break;
						
						}
					}
				}
				else
					System.out.println("Credentials do not match!! Please try again!!!");
			}
			else if(i==2) {
				System.out.print("Enter your name: ");
				empName=sc.nextLine();
				
				System.out.print("Enter your designation: ");
				designation=sc.nextLine();
				
				System.out.print("Enter your salary: ");
				salary=sc.nextDouble();
				sc.nextLine();
				
				empId+=9;
				
				System.out.print("Enter username: ");
				username=sc.nextLine();
				
				System.out.print("Enter password: ");
				password=sc.nextLine();
				
				e=new Employee(empId, empName, designation, salary, username, password);
				
				flag=eimpl.addEmployee(e);
				if(flag) {
					System.out.println("Employee registered successfully!!!");
					
				}
				else
					System.err.println("Error while adding employee!!!");
				
			}
			else
				System.out.println("Please enter 1 or 2 only!!!");
		}

	}
}
