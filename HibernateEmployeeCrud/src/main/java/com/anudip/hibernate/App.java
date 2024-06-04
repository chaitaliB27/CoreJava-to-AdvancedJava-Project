package com.anudip.hibernate;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	char a;
        EmployeeDaoImpl daoImpl = new EmployeeDaoImpl();
        do {
        	
        	Scanner sc = new Scanner(System.in);
        	System.out.println("Employee Registration");
        	System.out.println("1. Add employee");
        	System.out.println("2. Show employee");
        	System.out.println("3. Delete employee");
        	System.out.println("4. Update employee");
        	System.out.print("Enter the choice: ");
        	int ch = sc.nextInt();
        	switch (ch) {
        	
			case 1:
				daoImpl.addEmp();
				break;
				
			case 2:
				daoImpl.getEmp();
				break;
				
			case 3:
				daoImpl.deleteEmp();
				break;
	
			case 4:
				daoImpl.updateEmp();
				break;

			case 5:
				System.exit(0);
				break;
				
			}
        	System.out.print("Do you want to continue Y/N: ");
			a = sc.next().charAt(0);
			
        }
        while(a=='Y' || a=='y');
        System.out.println("Thanks");
        
    }
}
