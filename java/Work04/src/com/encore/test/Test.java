package com.encore.test;

import com.encore.book.Book;
import com.encore.bookmanager.BookManagerimp1;
import com.encore.magazine.Magazine;

public class Test {
	
	public static void printBooks(Book[] bs) {
		for(Book b : bs) if (b!=null) System.out.println(b.getDetail());
	}
	public static void main(String[] args) {
		
		BookManagerimp1 manager = BookManagerimp1.getInstance();
		
		manager.insertBook(new Book("1234","자바 프로그래밍","박은종","이지스퍼블리싱",12500.0,"손쉬운 자바 입문"));
		manager.insertBook(new Magazine("4321", "보그", "두산매거진 편집부", "두산매거진", 6100.0, "보그5월호", 2020, 5));
		manager.insertBook(new Book("2345","부자의 언어","이한이","윌북",9200.0,"어떻게 살아야 부자가 될까"));
		manager.insertBook(new Magazine("4322", "엘르", "엘르", "허스트중앙", 4000.0, "엘르8월호", 2020, 8));
		manager.insertBook(new Magazine("4323", "더블유코리아","두산매거진 편집부", "두산매거진", 5700.0, "더블유 코리아 5월호", 2020, 5));
		manager.insertBook(new Book("1236","점프투파이썬","박응용","이지스퍼블리싱",12500.0,"재밌는 프로그래밍!"));
		
		System.out.println("모든 책 불러오기*********");
		printBooks(manager.getAllBook());
		System.out.println();
		
		System.out.println("책의 수량*********");
		System.out.println(manager.getNumberOfBooks()+"권");
		System.out.println();
		
		System.out.println("isbn으로 도서검색*********");
		Book isbnBook = manager.searchBookByIsbn("4321");
		System.out.println(isbnBook.getDetail());
		System.out.println();
		
		System.out.println("Title로 도서검색*********");
		Book[] titleBook = manager.searchBookByTitle("부자의 언어");
		printBooks(titleBook);
		System.out.println();
		
		System.out.println("Publisher로 도서검색*********");
		Book[] pbBook = manager.searchBookByPublisher("이지스퍼블리싱");
		printBooks(pbBook);
		System.out.println();
		
		System.out.println("가격으로 도서검색*********");
		Book[] priceBook = manager.searchBookByPrice(12500.0);
		printBooks(priceBook);
		System.out.println();
		
		System.out.println("도서 총액*********");
		double bookTotal = manager.getSumPriceOfBooks();
		System.out.println(bookTotal+"원");
		System.out.println();
		
		System.out.println("도서의 평균가*********");
		double bookAvg = manager.getAveragePriceOfBooks();
		System.out.println(bookAvg+"원");
		System.out.println();
	}

}
