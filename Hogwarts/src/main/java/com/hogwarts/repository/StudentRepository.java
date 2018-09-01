package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hogwarts.model.Students;
import com.hogwarts.model.Teachers;

public class StudentRepository extends HogwartsConnection {
	public void getAllStudents() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM students");
	}
	
	public void createStudent(Students student) throws SQLException {
		ResultSet rs = statement.executeQuery("INSERT INTO students VALUES (" + student.getStudentName() + ", " + student.getClassId() + ")");
	}
	
	public void updateStudent(int studentId, Students updatedStudent) throws SQLException {
		ResultSet rs = statement.executeQuery("UPDATE students student_name = " + updatedStudent.getStudentName() + ", class_id = " + updatedStudent.getClassId() + " WHERE student_id = " + updatedStudent.getStudentId());
	}
	
	public void deleteStudent(int studentId) throws SQLException {
		ResultSet rs = statement.executeQuery("DELETE FROM students WHERE student_id = " + studentId);
	}
}
