package com.encore.bookmanager;

import com.encore.book.Book;

/*
 * BookManager Interface는 다양한 Book 객체를 핸들링하는 템플릿 기능을 가지고 있습니당
 */
public interface BookManager {
	int getNumberOfBooks();
	void insertBook(Book book);
	Book[] getAllBook();
	Book searchBookByIsbn(String isbn);
	Book[] searchBookByTitle(String title);
	Book[] searchBookByPublisher(String publ);
	Book[] searchBookByPrice(double price);
	double getSumPriceOfBooks();
	double getAveragePriceOfBooks();

}
