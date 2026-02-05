package com.studentanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_db", "root", "pg123")) {
			while(true) {
				System.out.println("\n1. Add Student: ");
				System.out.println("2. Delete Student: ");
				System.out.println("3. View All Students: ");
				System.out.println("4. Get Student By ID: ");
				System.out.println("5. Update Student: ");
				System.out.println("6. Exit: ");
				
				System.out.println("Enter your choice: ");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1: System.out.println("Add Student: ");
				int n = sc.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter id: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter name: ");
					String name = sc.nextLine();
					System.out.println("Enter marks: ");
					int marks = sc.nextInt();
					System.out.println("Enter CGPA: ");
					double cgpa = sc.nextDouble();
					service.addStudent(connection, new Student(id, name, marks, cgpa));
					System.out.println("Student added successfully!");
				}
				break;
				
				case 2: System.out.println("Delete Student: ");
				
				int removeStudent = sc.nextInt();
				service.removeStudent(connection, removeStudent);
				System.out.println("User removed Successfully!");
				break;
				
				case 3: System.out.println("View All Students: ");
				System.out.println("All Students: ");
				service.viewAllStudents(connection);
				break;
				case 4: System.out.println("Get Student By ID: ");
				System.out.println("Enter student id to search: ");
				int studentId = sc.nextInt();
				service.getStudentById(connection, studentId);
				break;
				
				case 5: System.out.println("Update Student: ");
				System.out.println("Enter student id to update: ");
				int updateId = sc.nextInt();
				System.out.println("Enter student marks to update: ");
				int updateMarks = sc.nextInt();
				service.updateStudent(connection, updateId, updateMarks);
				break;
				
				case 6: System.out.println("Exiting.... ");
				System.exit(0);
				
				default: System.out.println("Invalid input: ");
				
				}
			
			
			}
	} catch(SQLException e) {
		System.out.println("Error: " + e.getMessage());
	} catch(StudentNotFoundException e) {
		System.out.println("Error: " + e.getMessage());
		
	} finally {
		sc.close();
	}

  }	
}
