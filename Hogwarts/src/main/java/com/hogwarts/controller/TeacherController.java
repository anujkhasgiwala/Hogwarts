package com.hogwarts.controller;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.hogwarts.interactor.TeacherInteractor;
import com.hogwarts.model.Teachers;
import com.hogwarts.repository.TeacherRepository;

public class TeacherController {
	TeacherInteractor interactor;

	public TeacherController() {
		interactor = new TeacherInteractor(new TeacherRepository());
	}
	
	@GET
	@Path("/getteachers")
	@Produces("application/json")
	public Response getAllteachers() {
		try {
			return Response.ok(interactor.getAllTeachers()).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/teacheres")
	@Produces("application/json")
	public void createTeacher(Teachers newTeacher) {
		try {
			interactor.createTeacher(newTeacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/teacheres/{teacherId}")
	@Produces("application/json")
	public void updateTeacher(int teacherId, Teachers updatedTeacher) {
		try {
			interactor.updateTeachers(teacherId, updatedTeacher);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("/teacheres/{teacherId}")
	public void deleteTeacher(int teacherId) {
		try {
			interactor.deleteTeachers(teacherId)	;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
