package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRepository extends HogwartsConnection {

	public ResultSet getAllClasses() throws SQLException {
		return statement.executeQuery("SELECT * FROM classes");		
	}
	
	public void getClassByTeacher(int teacherId) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT class_id FROM teachers WHERE teacher_id = " + teacherId);
	}
	
	public void createClass(com.hogwarts.model.Class newClass) throws SQLException {
		ResultSet rs = statement.executeQuery("INSERT INTO classes VALUES (" + newClass.getClassName() + ")");
	}
	
	public void updateClass(int classId, com.hogwarts.model.Class updatedClass) throws SQLException {
		ResultSet rs = statement.executeQuery("UPDATE classes class_name = " + updatedClass.getClassName()+ " WHERE class_id = " + updatedClass.getClassId());
	}
	
	public void deleteClass(int classId) throws SQLException {
		ResultSet rs = statement.executeQuery("DELETE FROM classes WHERE class_id = " + classId);
	}
}
