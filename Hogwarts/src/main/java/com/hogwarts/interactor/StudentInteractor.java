package com.hogwarts.interactor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hogwarts.model.Students;
import com.hogwarts.repository.StudentRepository;

public class StudentInteractor {
	StudentRepository repository;
	
	public StudentInteractor(StudentRepository studentRepository) {
		repository = studentRepository;
	}

	public List<Students> getAllStudents() throws SQLException{
		var result = repository.getAllStudents();
		Students studentData = new Students();
		List<Students> students = new ArrayList<Students>();
		while(result.next()) {
			studentData.setClassId(result.getInt("class_id"));
			studentData.setStudentId(result.getInt("student_id"));
			studentData.setStudentName(result.getString("student_name"));
			students.add(studentData);
		}
		return students;
	}
	
	public void createStudent(Students newStudent) throws SQLException {
		repository.createStudent(newStudent);
	}
	
	public void updateStudents(int studentId, Students updatedStudent) throws SQLException{
		repository.updateStudent(studentId, updatedStudent);
	}
	
	public void deleteStudents(int studentId) throws SQLException {
		repository.deleteStudent(studentId);
	}
}
