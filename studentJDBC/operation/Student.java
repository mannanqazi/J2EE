package com.jspider.studentJDBC.operation;

public class Student {
		
		private int id;
		private String name;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public double getFees() {
			return fees;
		}
		public void setFees(double fees) {
			this.fees = fees;
		}
		private String email;
		private int age;
		private double fees;
		
		@Override
		public String toString() {
			return "student1 [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", fees=" + fees + "]";
		}
		public void addStudent1(Student student) {
			// TODO Auto-generated method stub
			
		}


}
