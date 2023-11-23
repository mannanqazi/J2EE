package com.jspider.studentJDBC.operation;

	import java.sql.SQLException;
	import java.util.List;
	import java.util.Scanner;

	public class Main {
		
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
			Operation jdbc = new Operation();
			Scanner scanner = new Scanner(System.in);
			boolean flag = true;
			
			while (flag) {
				System.out.println("Enter 1 to add student" );
				System.out.println("Enter 2 to get all student" );
				System.out.println("Enter 3 to get student by id"  );
				System.out.println("Enter 4 to delete student" );
				System.out.println("Enter 5 to update student" );
				System.out.println("Enter 6 to Exit" );
				System.out.println("Enter your choice" );
				int choice = scanner.nextInt();
				
				switch (choice) {
				case 1:
					Student student = new Student();
					System.out.println("Enter student id.");
					student.setId(scanner.nextInt());
					scanner.nextLine();
					System.out.println("Enter student name.");
					student.setName(scanner.nextLine());
					System.out.println("Enter student email.");
					student.setEmail(scanner.nextLine());
					System.out.println("Enter student age.");
					student.setAge(scanner.nextInt());
					System.out.println("Enter student fees.");
					student.setFees(scanner.nextDouble());
					jdbc.addStudent1(student);
					break;

				case 2:
					List<Student> students = jdbc.getAllStudents();
					for (Student s : students) {
						System.out.println(s);
					}
					break;
				case 3:
					System.out.println("Enter student id.");
					Student s = jdbc.getStudentById(scanner.nextInt());
					System.out.println(s);
					break;
				case 4:
					System.out.println("Enter student id.");
					jdbc.deleteStudent(scanner.nextInt());
					break;
				case 5:
					System.out.println("Enter student id.");
					jdbc.updateStudent(scanner.nextInt(), scanner);
					break;
				case 6:
					System.out.println("Thank you!");
					flag = false;
					break;
				default:
					System.out.println("Invalid choice.");
				}
			}
			scanner.close();
		}


}
