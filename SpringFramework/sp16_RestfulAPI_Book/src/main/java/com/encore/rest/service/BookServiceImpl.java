package com.encore.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.rest.dao.BookDAO;
import com.encore.rest.vo.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;
	
	@Override
	public List<Book> getAllBook() throws Exception {
		return bookDao.getAllBook();
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return bookDao.getBook(isbn);
	}

	@Override
	public boolean insertBook(Book book) throws Exception {
		return bookDao.insertBook(book);
	}

	@Override
	public boolean updateBook(Book book) throws Exception {
		return bookDao.updateBook(book);
	}

	@Override
	public boolean deleteBook(String isbn) throws Exception {
		return bookDao.deleteBook(isbn);
	}

}
