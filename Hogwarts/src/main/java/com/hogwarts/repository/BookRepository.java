package com.hogwarts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hogwarts.model.Books;

public class BookRepository extends HogwartsConnection{
	public ResultSet getAllBooks() throws SQLException {
		return connection.prepareStatement("SELECT * FROM books").executeQuery();
	}
	
	public ResultSet createBook(Books book) throws SQLException {
		return connection.prepareStatement("INSERT INTO books VALUES (" + book.getBookName() + ", " + book.getClassId() + ")").executeQuery();
	}
	
	public ResultSet updateBook(int bookId, Books updatedBook) throws SQLException {
		return connection.prepareStatement("UPDATE books book_name = " + updatedBook.getBookName() + ", class_id = " + updatedBook.getClassId() + " WHERE book_id = " + updatedBook.getBookId()).executeQuery();
	}
	
	public ResultSet deleteBook(int bookId) throws SQLException {
		return connection.prepareStatement("DELETE FROM books WHERE book_id = " + bookId).executeQuery();
	}
}
