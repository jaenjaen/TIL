package com.encore.service;

import com.encore.vo.Movie;

public interface MovieMgr {
	void add(Movie movie);
	Movie[] search();
	Movie[] search(String title);
	Movie[] searchDirector(String name);
	Movie[] searchGenre(String genre);
	void delete(String title);
	int getSize();
}
