package in.ashokit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepo;
import in.ashokit.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo repo;

	public String upsertBook(Book book) {
		Integer bookId = book.getBookId();
		 repo.save(book);
		if (bookId == null) {

			return "Book Record Inserted..!";
		} else {

			return "Book Record Update...!";
		}
	}

	public List<Book> getBook() {
		List<Book> books = repo.findAll();
		return books;
	}

	public String deleteBook(Book bookId) {
		repo.delete(bookId);
		return "Record delete Successfully..!";
	}

}
