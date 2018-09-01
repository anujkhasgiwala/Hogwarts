package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hogwarts.model.Books;
import com.hogwarts.model.Teachers;

public class TeacherRepository extends HogwartsConnection {
	public void getAllTeachers() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM teachers");
	}
	
	public void createTeacher(Teachers teacher) throws SQLException {
		ResultSet rs = statement.executeQuery("INSERT INTO teachers VALUES (" + teacher.getTeacherName() + ", " + teacher.getClassId() + ")");
	}
	
	public void updateTeacher(int teacherId, Teachers updatedTeacher) throws SQLException {
		ResultSet rs = statement.executeQuery("UPDATE teachers teacher_name = " + updatedTeacher.getTeacherName() + ", class_id = " + updatedTeacher.getClassId() + " WHERE teacher_id = " + updatedTeacher.getTeacherId());
	}
	
	public void deleteTeacher(int teacherId) throws SQLException {
		ResultSet rs = statement.executeQuery("DELETE FROM teachers WHERE teacher_id = " + teacherId);
	}
}
