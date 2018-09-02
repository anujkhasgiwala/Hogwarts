package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassRepository extends HogwartsConnection {

	public ResultSet getAllClasses() throws SQLException {
		return connection.prepareStatement("SELECT * FROM classes").executeQuery();		
	}
	
	public ResultSet getClassByTeacher(int teacherId) throws SQLException {
		return connection.prepareStatement("SELECT * FROM classes where classId = (select classId from teachers where teacher_id = )"+teacherId).executeQuery();		
	}
	
	public ResultSet getClassByBook(int bookId) throws SQLException {
		return connection.prepareStatement("SELECT * FROM classes where classId = (select classId from books where book_id = )"+bookId).executeQuery();
	}
	
	public ResultSet getClassByStudent(int studentId) throws SQLException {
		return connection.prepareStatement("SELECT * FROM classes where classId = (select classId from students where student_id = )"+studentId).executeQuery();
	}
	
	public ResultSet createClass(com.hogwarts.model.Class newClass) throws SQLException {
		return connection.prepareStatement("INSERT INTO classes VALUES (" + newClass.getClassName() + ")").executeQuery();
	}
	
	public ResultSet updateClass(int classId, com.hogwarts.model.Class updatedClass) throws SQLException {
		return connection.prepareStatement("UPDATE classes class_name = " + updatedClass.getClassName()+ " WHERE class_id = " + updatedClass.getClassId()).executeQuery();
	}
	
	public ResultSet deleteClass(int classId) throws SQLException {
		return connection.prepareStatement("DELETE FROM classes WHERE class_id = " + classId).executeQuery();
	}
}
