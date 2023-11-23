package com.jspider.employeemapping.main;

import java.util.Iterator;
import java.util.Scanner;

import com.jspider.employeemapping.dao.EmployeeDAO;
import com.jspider.employeemapping.dto.Company;




public class EmolpyeeMain {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println(" 1. Add Company");
			System.out.println(" 2. Add Employee");
			System.out.println(" 3. delete Employee");
			System.out.println(" 4. update Employee");
			System.out.println(" 5. get employee");
			System.out.println(" 6. to Exit ");
			
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("how many company you want to add");
				int m = scanner.nextInt();
				for (int i = 0; i <= m; i++) {
					EmployeeDAO.addCompany(scanner);
					System.out.println("added company");
				}
				break;
				
			case 2:
				System.out.println("Enter how many employees want you add");
				int n = scanner.nextInt();
				for(int i = 1 ; i <= n; i++) {
					EmployeeDAO.addEmployee(scanner);
					System.out.println(n +" Employee added");
					break;
				}
			case 3:
				EmployeeDAO.deleteEmployee();
				System.out.println("Deleted employee");
				break;
				
			case 4:
				EmployeeDAO.updateEmployee();
				System.out.println("updated employee");
				break;
			
			case 5:
				EmployeeDAO.getEmployee();
				System.out.println("1 row(s) affected");
				break;
			
			case 6:
				System.out.println("Thank you ");
				flag = false;
				break;
			default:
				break;
			}
		}
		//scanner.close();
			
	}
}
