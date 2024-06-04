package com.anudip.hibernate;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anudip.hibernate.config.HibernateUtil;
import com.anudip.hibernate.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Scanner sc = new Scanner(System.in);
	@Override
	public void addEmp() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String empName, surname, address, designation;
		long phone;
		System.out.print("Enter the first Name: ");
		empName = sc.next();
		
		System.out.print("Enter the last Name: ");
		surname = sc.next();
		
		System.out.print("Enter the address: ");
		address = sc.next();
		
		System.out.print("Enter the designation: ");
		designation = sc.next();
		
		System.out.print("Enter the phone number: ");
		phone = sc.nextLong();
		
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setSurname(surname);
		emp.setAddress(address);
		emp.setDesignation(designation);
		emp.setPhone(phone);
		
		session.save(emp);
		tx.commit();
		session.close();
		System.out.println("Employee added successfully");
	}

	@Override
	public void deleteEmp() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.print("Enter the employee id to delete: ");
		int empId = sc.nextInt();
		
		Employee empToDelete = session.get(Employee.class, empId);
		if(empToDelete != null) {
			
			session.delete(empToDelete);
			tx.commit();
			System.out.println("Employee with Id " + empId + " has been deleted.");
		}
		else 
			System.out.println("Employee with Id " + empId + " not found.");
	
		session.close();
	}

	@Override
	public void updateEmp() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.print("Enter the employee id to update: ");
		int empId = sc.nextInt();
		
		Employee empToUpdate = session.get(Employee.class, empId);
		if(empToUpdate != null) {
			
			boolean isUpdating = true;
			while(isUpdating) {
				System.out.println("Select the field to update: ");
				System.out.println("1. First Name: ");
				System.out.println("2. Last Name: ");
				System.out.println("3. Designation: ");
				System.out.println("4. Address: ");
				System.out.println("5. Mobile Number: ");
				System.out.println("6. Exit ");
				
				int choice = sc.nextInt();
				sc.nextLine(); // consume newline
				
				switch (choice) {
			
				case 1:
					System.out.print("Enter the first name: ");
					String firstName = sc.nextLine();
					empToUpdate.setEmpName(firstName);
					break;
					
				case 2:
					System.out.print("Enter the last name: ");
					String lastName = sc.nextLine();
					empToUpdate.setSurname(lastName);
					break;
					
				case 3:
					System.out.print("Enter the designation: ");
					String designation = sc.nextLine();
					empToUpdate.setDesignation(designation);
					break;
					
				case 4:
					System.out.print("Enter the address: ");
					String address = sc.nextLine();
					empToUpdate.setAddress(address);
					break;
					
				case 5:
					System.out.print("Enter the phone number: ");
					long phone = sc.nextLong();
					empToUpdate.setPhone(phone);
					break;
					
				case 6:
					isUpdating = false;
					break;
				
				default:
					System.out.print("Invalid choice. Please select a valid option. ");
					break;
				}
			}
			session.update(empToUpdate);
			tx.commit();
			System.out.println("Employee with Id " + empId + " has been updated.");
		}
		else 
			System.out.println("Employee with Id " + empId + " not found.");
	
		session.close();
	}

	@Override
	public void getEmp() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> employee = session.createQuery("FROM Employee", Employee.class).list();
		session.close();
		
		System.out.println("Employee List: ");
		for(Employee emp: employee) {
			
			System.out.println("Employee Id: " + emp.getEmpId());
			System.out.println("First Name: " + emp.getEmpName());
			System.out.println("Last Name: " + emp.getSurname());
			System.out.println("Designation: " + emp.getDesignation());
			System.out.println("Address: " + emp.getAddress());
			System.out.println("Mobile Number: " + emp.getPhone());
		}
	}

	
}
