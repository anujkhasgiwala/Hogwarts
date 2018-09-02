package com.hogwarts.interactor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hogwarts.model.Class;
import com.hogwarts.repository.ClassRepository;

public class ClassInteractor {
	ClassRepository repository;
	
	public ClassInteractor(ClassRepository classRepository) {
		repository = classRepository;
	}

	public List<com.hogwarts.model.Class> getAllClasses() throws SQLException{
		var result = repository.getAllClasses();
		Class classData = new Class();
		List<Class> classes = new ArrayList<Class>();
		while(result.next()) {
			classData.setClassId(result.getInt("class_id"));
			classData.setClassName(result.getString("class_name"));
			classes.add(classData);
		}

		return classes;
	}
	
	public com.hogwarts.model.Class getClassByTeacher(int teacherId) throws SQLException{
		var result = repository.getClassByTeacher(teacherId);
		Class classData = new Class();
		classData.setClassId(result.getInt("class_id"));
		classData.setClassName(result.getString("class_name"));
		
		return classData;
	}
	
	public com.hogwarts.model.Class getClassByBook(int bookId) throws SQLException{
		var result = repository.getClassByBook(bookId);
		Class classData = new Class();
		classData.setClassId(result.getInt("class_id"));
		classData.setClassName(result.getString("class_name"));
		
		return classData;
	}
	
	public com.hogwarts.model.Class getClassByStudent(int studentId) throws SQLException{
		var result = repository.getClassByStudent(studentId);
		Class classData = new Class();
		classData.setClassId(result.getInt("class_id"));
		classData.setClassName(result.getString("class_name"));
		
		return classData;
	}
	
	public void createClass(Class newClass) throws SQLException {
		repository.createClass(newClass);
	}
	
	public void updateClass(int classId, Class updatedClass) throws SQLException{
		repository.updateClass(classId, updatedClass);
	}
	
	public void deleteClass(int classId) throws SQLException {
		repository.deleteClass(classId);
	}
}
