package com.hogwarts.interactor;

import java.sql.SQLException;
import java.util.List;

import com.hogwarts.model.Class;
import com.hogwarts.repository.ClassRepository;

public class ClassInteractor {
	ClassRepository repository;
	
	public ClassInteractor(ClassRepository classRepository) {
		repository = classRepository;
	}

	public List<com.hogwarts.model.Class> getAllClasses() throws SQLException{
		repository.getAllClasses();
		return null;
	}
	
	public void createClass(Class newClass) {
		
	}
	
	public void updateClass(int classId, Class updatedClass) {
		
	}
	
	public void deleteClass(int classId) {
		
	}
}
