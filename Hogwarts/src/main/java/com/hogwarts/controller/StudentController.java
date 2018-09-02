package com.hogwarts.controller;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.hogwarts.interactor.StudentInteractor;
import com.hogwarts.model.Students;
import com.hogwarts.repository.StudentRepository;

public class StudentController {
	StudentInteractor interactor;

	public StudentController() {
		interactor = new StudentInteractor(new StudentRepository());
	}
	
	@GET
	@Path("/getbooks")
	@Produces("application/json")
	public Response getAllbooks() {
		try {
			return Response.ok(interactor.getAllStudents()).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/bookes")
	@Produces("application/json")
	public void createStudent(Students newStudent) {
		try {
			interactor.createStudent(newStudent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/bookes/{bookId}")
	@Produces("application/json")
	public void updateStudent(int bookId, Students updatedStudent) {
		try {
			interactor.updateStudents(bookId, updatedStudent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("/bookes/{bookId}")
	public void deleteStudent(int bookId) {
		try {
			interactor.deleteStudents(bookId)	;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
