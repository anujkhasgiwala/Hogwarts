package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hogwarts.model.Teachers;

public class TeacherRepository extends HogwartsConnection {
	public ResultSet getAllTeachers() throws SQLException {
		return connection.prepareStatement("SELECT * FROM teachers").executeQuery();
	}
	
	public ResultSet createTeacher(Teachers teacher) throws SQLException {
		return connection.prepareStatement("INSERT INTO teachers VALUES (" + teacher.getTeacherName() + ", " + teacher.getClassId() + ")").executeQuery();
	}
	
	public ResultSet updateTeacher(int teacherId, Teachers updatedTeacher) throws SQLException {
		return connection.prepareStatement("UPDATE teachers teacher_name = " + updatedTeacher.getTeacherName() + ", class_id = " + updatedTeacher.getClassId() + " WHERE teacher_id = " + updatedTeacher.getTeacherId()).executeQuery();
	}
	
	public ResultSet deleteTeacher(int teacherId) throws SQLException {
		return connection.prepareStatement("DELETE FROM teachers WHERE teacher_id = " + teacherId).executeQuery();
	}
}
