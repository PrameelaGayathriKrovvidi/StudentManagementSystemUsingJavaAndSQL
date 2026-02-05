package com.studentanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class StudentService {
	
	public void addStudent(Connection connection, Student s) throws SQLException {
		String sql = "INSERT INTO students(id, name, marks, cgpa) values(?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getMarks());
			ps.setDouble(4, s.getCgpa());
			ps.executeUpdate();
		
		}	
	}
	
	public void removeStudent(Connection connection, int studentId) throws SQLException, StudentNotFoundException {
		String sql = "DELETE from students where id = ?";
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, studentId);
			int rows = ps.executeUpdate();
			if (rows == 0) {
			    throw new StudentNotFoundException("Student Not Found");
			}
		}
	}
	
	public void viewAllStudents(Connection connection) throws SQLException {
		String sql = "SELECT id, name, marks, cgpa from students";
		try(PreparedStatement s = connection.prepareStatement(sql);
				ResultSet set = s.executeQuery()){
			while(set.next()) {
				System.out.println(set.getInt("id") + " | " + set.getString("name") + " | " + set.getInt("marks") + " | " + set.getDouble("cgpa"));
			}
			
		}
	}
	
	public void getStudentById(Connection connection, int studentId) throws SQLException, StudentNotFoundException {
		String sql = "SELECT * from students where id = ?";
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, studentId);
			try (ResultSet rs = ps.executeQuery()) {
				if(!rs.next()) {
					throw new StudentNotFoundException("Student not found with ID: " + studentId);
				}
				
				do {
					System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("marks") + " | " + rs.getDouble("cgpa"));

				} while(rs.next());
			}
			
		}
	}
	
	public void updateStudent(Connection connection, int studentId, int marks) throws SQLException, StudentNotFoundException {
		String sql = "update Students set marks = ? where id = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, marks);
			ps.setInt(2, studentId);
			
			int rows = ps.executeUpdate();
			if(rows == 0) {
				throw new StudentNotFoundException("Student not found with ID: " + studentId + " to update data");
			}
			
		}
	}
	

}
