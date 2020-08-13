package com.encore.rest.service;

import java.util.List;

import com.encore.rest.vo.Book;

//여기는 Select만 있는게 좋고 delete는 없는게 좋음
//근데 그러면 controller에서  dao를 autowired해야하기 때문애 그냥 여기서 delete씀..
public interface BookService {
	List<Book> getAllBook() throws Exception;
	Book getBook(String isbn) throws Exception;
	boolean insertBook(Book book)throws Exception;
	boolean updateBook(Book book)throws Exception;
	boolean deleteBook(String isbn)throws Exception;
}
