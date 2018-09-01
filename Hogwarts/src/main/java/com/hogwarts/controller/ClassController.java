package com.hogwarts.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
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
	
	@POST
	@Path("/classes")
	@Produces("application/json")
	public Response createClass(Class newClass) {
		interactor.createClass(newClass);
		return Response.ok().build(); //convert it to created
	}
	
	@PUT
	@Path("/classes/{classId}")
	@Produces("application/json")
	public void updateClass(int classId, Class updatedClass) {
		interactor.updateClass(classId, updatedClass);
		//add response code
	}
	
	@DELETE
	@Path("/classes/{classId}")
	public void deleteClass(int classId) {
		interactor.deleteClass(classId);
		//add status code
	}
}
