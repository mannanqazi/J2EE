package com.jspider.studentJDBC.operation;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class Operation {
		
		private static Connection connection;
		private static PreparedStatement preparedStatement;
		private static ResultSet resultSet;
		private static String query;
		
		  public void addStudent1(Student student){
			  
			  try {
			  connection = openConnection1();
			  query = "INSERT INTO student VALUES(?,?,?,?,?)";
			  preparedStatement = connection.prepareStatement(query);
			  preparedStatement.setInt(1,student.getId());
			  preparedStatement.setString(2,student.getName());
			  preparedStatement.setString(3,student.getEmail());
			  preparedStatement.setInt(4,student.getAge());
			  preparedStatement.setDouble(5,student.getFees());
			  int row = preparedStatement.executeUpdate();
			  System.out.println(row + "row(s) affected");
			  
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection1();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			  
		  }
		  
		  
	///to fetch the all records
		public void addStudent(Student student) {
			
			try {
				
				connection = openConnection1();
				query = "INSERT INTO student VALUES(?,?,?,?,?)";
				
				} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

		public List<Student> getAllStudents() throws SQLException {
			ArrayList<Student> list = new ArrayList<>();

			try {
				connection = openConnection1();
				query = "SELECT * FROM student";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Student student = new Student();
					student.setId(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setEmail(resultSet.getString(3));
					student.setAge(resultSet.getInt(4));
					student.setFees(resultSet.getDouble(5));
					list.add(student);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection1();
			}
			return list;

		}
		

		public Student getStudentById(int id) {
			
			Student student = new Student();
			
			try {
			 connection = openConnection1();
			 query = "SELECT * FROM student where id = ?";
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setInt(1, id);
			 resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setAge(resultSet.getInt(4));
				student.setFees(resultSet.getDouble(5));
				
			}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection1();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return student;
			
		}

		public void deleteStudent(int id) {
			
			try {
				connection = openConnection1();
				query = "DELETE FROM student WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				int row = preparedStatement.executeUpdate();
				System.out.println(row + " row(s) affected ");
				System.out.println();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					closeConnection1();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
			
		}

		public void updateStudent(int id, Scanner scanner) {
			
			try {
				connection = openConnection1();
				query = "UPDATE student SET name = ? ,email = ? ,age = ?, fees = ? WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				scanner.nextLine();
				System.out.println("Enter student name");
				preparedStatement.setString(1, scanner.nextLine());
				System.out.println("Enter student email");
				preparedStatement.setString(2, scanner.nextLine());
				System.out.println("Enter student Age");
				preparedStatement.setInt(3, scanner.nextInt());
				System.out.println("Enter student fees");
				preparedStatement.setDouble(4, scanner.nextDouble());
				System.out.println("Enter student id");
				preparedStatement.setInt(5, scanner.nextInt());
				int row = preparedStatement.executeUpdate();
				System.out.println(row + " row(s) affected");
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			
		}
		
		private Connection openConnection1() throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localHost:3306/weja3","root","root");
		}
		
		private void closeConnection1() throws SQLException {
			
			if (resultSet != null) {
				resultSet.close();
				
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
			
		}
		


}
