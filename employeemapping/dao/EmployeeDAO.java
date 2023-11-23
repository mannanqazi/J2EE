package com.jspider.employeemapping.dao;

import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.employeemapping.dto.Company;
import com.jspider.employeemapping.dto.Company;
import com.jspider.employeemapping.dto.Employee;
import com.jspider.employeemapping.dto.Employee;

public class EmployeeDAO {
	 
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;
    
   
    public static void addCompany(Scanner scanner) {
    	
    	openConnection();
    	entityTransaction.begin();
    	
    	Company company = new Company();
    	scanner.nextLine();
    	System.out.println("Enter company name");
    	company.setName(scanner.nextLine());
    	System.out.println("Enter company Address");
    	company.setAddress(scanner.nextLine());
    	
    	entityManager.persist(company);
    	
    	entityTransaction.commit();
    	closeConnection();
    	
    }
    
    public static void addEmployee(Scanner scanner) {
    	
    	openConnection();
    	entityTransaction.begin();
    	
    	
//    	Company company = new Company();
//    	company.setId(2);
//    	company.setName("teco ei");
//    	company.setAddress("moshi");
//    	entityManager.persist(company);

    	
    	Employee employee = new Employee();
    	
    	scanner.nextLine();
    	System.out.println("Enter name");
    	employee.setName(scanner.nextLine());
    	
    	System.out.println("Enter Email");
    	employee.setEmail(scanner.nextLine());
    	
    	System.out.println("Enter Age");
    	employee.setAge(scanner.nextInt());
    	
    	System.out.println("Enter Salary");
    	employee.setSalary(scanner.nextDouble());
    	
    	//employee.setCompany(1);
    	entityManager.persist(employee);
    	
    	entityTransaction.commit();
    	closeConnection();
    	
    }
    
    public static void deleteEmployee() {
    	
    	openConnection();
    	entityTransaction.begin();
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter id to be deleted");
    	int id = scanner.nextInt();
    	Employee employee =  entityManager.find(Employee.class,id);
    	entityManager.remove(employee);
    	
    	entityTransaction.commit();
    	closeConnection();
    }
    
 public static void updateEmployee() {
    	
    	openConnection();
    	entityTransaction.begin();
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter employee id to be updated");
    	int id = scanner.nextInt();
    	Employee employee =  entityManager.find(Employee.class,id);
    	scanner.nextLine();
    	System.out.println("Enter new name");
    	employee.setName(scanner.nextLine());
    	System.out.println("Enter new email");
    	employee.setEmail(scanner.nextLine());
    	System.out.println("Enter new age");
    	employee.setAge(scanner.nextInt());
    	System.out.println("Enter new salary");
    	employee.setSalary(scanner.nextDouble());
    	
    	entityTransaction.commit();
    	closeConnection();
    }
 
    public static void getEmployee() {
 	
    	openConnection();
    	entityTransaction.begin();
 		Scanner scanner = new Scanner(System.in);
 		System.out.println("Enter id to fetch employee");
		int id = scanner.nextInt();
 		Employee employee =  entityManager.find(Employee.class,id);
		System.out.println(employee);
 	
 		entityTransaction.commit();
 		closeConnection();
    }

    
    private static void openConnection() {
    	
    	entityManagerFactory = Persistence.createEntityManagerFactory("employee");
    	entityManager = entityManagerFactory.createEntityManager();
    	entityTransaction = entityManager.getTransaction();
    	
    }
    private static void closeConnection() {
    	if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
    	if (entityManager != null) {
			entityManager.close();
		}
    	if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
    }
    

}
