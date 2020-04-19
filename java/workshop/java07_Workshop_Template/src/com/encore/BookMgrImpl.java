package com.encore;

import java.util.ArrayList;

public class BookMgrImpl implements BookMgr{
	private ArrayList<Book> books = null;
	
	private static BookMgrImpl mgr = new BookMgrImpl();
	private BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	public static BookMgrImpl getInstance() {
		return  mgr;
	}
	
	
	@Override
	public void addBook(Book b) {
		books.add(b);
	}

	@Override
	public ArrayList<Book> getAllBook() {
		return books;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		Book book = null;
		
		for(Book b: books) {
			if(b.getIsbn().equals(isbn)) book = b;
		}
		
		return book;
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> bs = new ArrayList<>();
		for(Book b: books) {
				if(b.getTitle().equals(title)) bs.add(b);
				}
		
		return bs;
	}

	@Override
	public ArrayList<Book> onlySearchBook() {
		ArrayList<Book> bs = new ArrayList<>();
		for(Book b: books) {
			if(!(b instanceof Magazine)) bs.add(b);
		}
		return bs;
	}

	@Override
	public ArrayList<Book> onlySearchMagazin() {
		ArrayList<Book> bs = new ArrayList<>();
		for(Book b: books) {
			if((b instanceof Magazine)) bs.add(b);
		}
		return bs;
	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo(int year) {
		ArrayList<Book> magazine = onlySearchMagazin();
		ArrayList<Book> bs = new ArrayList<>();
		for(Book b: magazine) {
			if(((Magazine)b).getYear() == year) bs.add(b);
		}
		return bs;
	}

	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		ArrayList<Book> bs = new ArrayList<>();
		for(Book b: books) {
			if(b.getPublisher().equals(publish)) bs.add(b);
		}
		return bs;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		ArrayList<Book> bs = new ArrayList<>();
		for(Book b: books) {
			if(b.getPrice() <= price) bs.add(b);
		}
		return bs;
	}

	@Override
	public int getTotalPrice() {
		int tot = 0;
		for(Book b: books) {
			tot += b.getPrice();
		}
		return tot;
	}
	@Override
	public int getAvgPrice() {
		int avg = getTotalPrice()/books.size();
		return avg;
	}
}
