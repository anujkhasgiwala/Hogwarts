package com.hogwarts.controller;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.hogwarts.interactor.ClassInteractor;
import com.hogwarts.model.Class;
import com.hogwarts.repository.ClassRepository;

@Path("/classes")
public class ClassController {
	ClassInteractor interactor;

	public ClassController() {
		interactor = new ClassInteractor(new ClassRepository());
	}
	
	@GET
	@Path("/getClasses")
	@Produces("application/json")
	public Response getAllClasses() {
		try {
			return Response.ok(interactor.getAllClasses()).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/getClasses/{teacherId}")
	@Produces("application/json")
	public Response getClassByTeacher(int teacherId) {
		try {
			return Response.ok(interactor.getClassByTeacher(teacherId)).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/getClasses/{bookId}")
	@Produces("application/json")
	public Response getClassByBook(int bookId) {
		try {
			return Response.ok(interactor.getClassByBook(bookId)).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("/getClasses/{studentId}")
	@Produces("application/json")
	public Response getClassByStudent(int studentId) {
		try {
			return Response.ok(interactor.getClassByStudent(studentId)).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/classes")
	@Produces("application/json")
	public void createClass(Class newClass) {
		try {
			interactor.createClass(newClass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/classes/{classId}")
	@Produces("application/json")
	public void updateClass(int classId, Class updatedClass) {
		try {
			interactor.updateClass(classId, updatedClass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("/classes/{classId}")
	public void deleteClass(int classId) {
		try {
			interactor.deleteClass(classId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
