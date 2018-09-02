package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hogwarts.model.Students;

public class StudentRepository extends HogwartsConnection {
	public ResultSet getAllStudents() throws SQLException {
		return connection.prepareStatement("SELECT * FROM students").executeQuery();
	}
	
	public ResultSet createStudent(Students student) throws SQLException {
		return connection.prepareStatement("INSERT INTO students VALUES (" + student.getStudentName() + ", " + student.getClassId() + ")").executeQuery();
	}
	
	public ResultSet updateStudent(int studentId, Students updatedStudent) throws SQLException {
		return connection.prepareStatement("UPDATE students student_name = " + updatedStudent.getStudentName() + ", class_id = " + updatedStudent.getClassId() + " WHERE student_id = " + updatedStudent.getStudentId()).executeQuery();
	}
	
	public ResultSet deleteStudent(int studentId) throws SQLException {
		return connection.prepareStatement("DELETE FROM students WHERE student_id = " + studentId).executeQuery();
	}
}
