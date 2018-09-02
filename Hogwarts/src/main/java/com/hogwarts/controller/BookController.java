package com.hogwarts.controller;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.hogwarts.interactor.BookInteractor;
import com.hogwarts.model.Books;
import com.hogwarts.repository.BookRepository;

public class BookController {
	BookInteractor interactor;

	public BookController() {
		interactor = new BookInteractor(new BookRepository());
	}
	
	@GET
	@Path("/getbooks")
	@Produces("application/json")
	public Response getAllbooks() {
		try {
			return Response.ok(interactor.getAllBooks()).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/bookes")
	@Produces("application/json")
	public void createBook(Books newBook) {
		try {
			interactor.createBook(newBook);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/bookes/{bookId}")
	@Produces("application/json")
	public void updateBook(int bookId, Books updatedBook) {
		try {
			interactor.updateBooks(bookId, updatedBook);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Path("/bookes/{bookId}")
	public void deleteBook(int bookId) {
		try {
			interactor.deleteBooks(bookId)	;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
