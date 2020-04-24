package com.encore.bookmanager;

import com.encore.book.Book;
/**
 * 
 * @author JAEEUN LEE
 * @version Singletone 적용
 * @version BookManager interface templet 제공
 *
 */

public class BookManagerimp1 implements BookManager {
	private int numberOfBooks;
	static Book[] bs;
	static int bidx;
	
	private static BookManagerimp1 bookmanager = new BookManagerimp1();
	
	private  BookManagerimp1() {
		bs = new Book[100];
	}
	
	public static BookManagerimp1 getInstance() {
		return bookmanager;
	}
	
	public int getNumberOfBooks() {	
		return bidx;
	}
	
	public void insertBook(Book book) {
		bs[bidx++] = book;
	}
	
	public Book[] getAllBook() {
		return bs;
	}
	
	public Book searchBookByIsbn(String isbn) {
		Book book = null;
		for(Book b : bs) {
			if(b != null) if(b.getIsbn().equals(isbn)) book = b;
			}
		return book;
	}
	
	public Book[] searchBookByTitle(String title) {
		Book[] bks = new Book[bidx];
		int idx = 0;
		
		for(Book b: bs) {
			if(b != null) {
				if(b.getTitle().equals(title)) bks[idx++] = b;
			}
		}
		return bks;
	}
	
	public Book[] searchBookByPublisher(String publ) {
		Book[] bks = new Book[bidx];
		int idx = 0;
		
		for(Book b: bs) {
			if(b != null) {
				if(b.getPublisher().equals(publ)) bks[idx++] = b;
			}
		}
		return bks;
	}
	
	public Book[] searchBookByPrice(double price) {
		Book[] bks = new Book[bidx];
		int idx = 0;
		
		for(Book b: bs) {
			if(b != null) {
				if(b.getPrice() == price) bks[idx++] = b;
			}
		}
		return bks;
	}
	
	public double getSumPriceOfBooks() {
		double tot = 0.0;
		for(Book b:bs) if(b != null) tot += b.getPrice();
		return tot;
	}
	
	public double getAveragePriceOfBooks() {
		double avg = 0.0;
		avg = getSumPriceOfBooks()/getNumberOfBooks();
		return avg;
	}
}
