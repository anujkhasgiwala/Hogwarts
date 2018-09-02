package com.hogwarts.interactor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hogwarts.model.Books;
import com.hogwarts.repository.BookRepository;

public class BookInteractor {
	BookRepository repository;
	
	public BookInteractor(BookRepository bookRepository) {
		repository = bookRepository;
	}

	public List<Books> getAllBooks() throws SQLException{
		var result = repository.getAllBooks();
		Books bookData = new Books();
		List<Books> books = new ArrayList<Books>();
		while(result.next()) {
			bookData.setClassId(result.getInt("class_id"));
			bookData.setBookId(result.getInt("book_id"));
			bookData.setBookName(result.getString("book_name"));
			books.add(bookData);
		}
		return books;
	}
	
	public void createBook(Books newBook) throws SQLException {
		repository.createBook(newBook);
	}
	
	public void updateBooks(int bookId, Books updatedBook) throws SQLException{
		repository.updateBook(bookId, updatedBook);
	}
	
	public void deleteBooks(int bookId) throws SQLException {
		repository.deleteBook(bookId);
	}
}
