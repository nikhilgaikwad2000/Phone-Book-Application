package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Book;

public interface BookService {

	public String upsertBook (Book book);
	
	public List<Book> getBook();
	
	public String deleteBook(Book bookId);
	
}
