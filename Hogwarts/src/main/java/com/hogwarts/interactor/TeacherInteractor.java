package com.hogwarts.interactor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hogwarts.model.Teachers;
import com.hogwarts.repository.TeacherRepository;

public class TeacherInteractor {
	TeacherRepository repository;
	
	public TeacherInteractor(TeacherRepository teacherRepository) {
		repository = teacherRepository;
	}

	public List<Teachers> getAllTeachers() throws SQLException{
		var result = repository.getAllTeachers();
		Teachers teacherData = new Teachers();
		List<Teachers> teachers = new ArrayList<Teachers>();
		while(result.next()) {
			teacherData.setClassId(result.getInt("class_id"));
			teacherData.setTeacherId(result.getInt("teacher_id"));
			teacherData.setTeacherName(result.getString("teacher_name"));
			teachers.add(teacherData);
		}
		return teachers;
	}
	
	public void createTeacher(Teachers newTeacher) throws SQLException {
		repository.createTeacher(newTeacher);
	}
	
	public void updateTeachers(int teacherId, Teachers updatedTeacher) throws SQLException{
		repository.updateTeacher(teacherId, updatedTeacher);
	}
	
	public void deleteTeachers(int teacherId) throws SQLException {
		repository.deleteTeacher(teacherId);
	}
}
