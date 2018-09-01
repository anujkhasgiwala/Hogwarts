package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hogwarts.model.Books;

public class BookRepository extends HogwartsConnection{
	public void getAllBooks() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM books");
	}
	
	public void createBook(Books book) throws SQLException {
		ResultSet rs = statement.executeQuery("INSERT INTO books VALUES (" + book.getBookName() + ", " + book.getClassId() + ")");
	}
	
	public void updateBook(int bookId, Books updatedBook) throws SQLException {
		ResultSet rs = statement.executeQuery("UPDATE books book_name = " + updatedBook.getBookName() + ", class_id = " + updatedBook.getClassId() + " WHERE book_id = " + updatedBook.getBookId());
	}
	
	public void deleteBook(int bookId) throws SQLException {
		ResultSet rs = statement.executeQuery("DELETE FROM books WHERE book_id = " + bookId);
	}
}
