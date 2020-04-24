package com.encore.service;

/**
 * @author JAEEUN LEE
 */
import com.encore.vo.Movie;
public class MovieMgrImp implements MovieMgr{
	private Movie[ ] movies;
	private int index;
	
	//싱글톤...MovieMgr을 mgr이름으로 객체 생성...getInstance로 생성한 객체를 받아온다.
	private static MovieMgrImp mgr = new MovieMgrImp();
	
	private MovieMgrImp() {
		movies = new Movie[100];
	}
	
	public static MovieMgrImp getInstance() {
		return mgr;
	}
	
	public void add(Movie m) {
		movies[index++] = m;
	}
	
	public Movie[] search() {
		Movie[] mvs = new Movie[index];
		for (int  i=0; i<index ;i++) mvs[i] = movies[i];
		return mvs;
	}
	
	public Movie[] search(String title) {
		Movie[] mvs = new Movie[index];
		int temp = 0;
		
		for(Movie m: movies) {
			if (m == null) continue;
			if (m.getTitle().contains(title)) mvs[temp++] = m;
		}
		//null값 추리기
		Movie[] returnMovie = new Movie[temp];
		for(int i =0; i<temp;i++) {
			returnMovie[i] = mvs[i];
		}
		return returnMovie;
	}

	public Movie[] searchDirector(String name) {
		int size = 0;
		
		for(int i=0; i<index; i++) {
			if(movies[i].getDirector().contains(name)) size++;
		}
		
		Movie[] nMovie = new Movie[size];
		for(int i=0; i<index; i++) {
			if(movies[i].getDirector().contains(name)) {
				nMovie[--size]=movies[i];
			}	}
	
		return nMovie;
	}

	public Movie[] searchGenre(String genre) {
int size = 0;
		
		for(int i=0; i<index; i++) {
			if(movies[i].getGenre().contains(genre)) size++;
		}
		
		Movie[] nMovie = new Movie[size];
		for(int i=0; i<index; i++) {
			if(movies[i].getGenre().contains(genre)) {
				nMovie[--size]=movies[i];
			}	}
	
		return nMovie;
	}

	public void delete(String title) {
		for(int i =0; i<index;i++) {
			if(movies[i].getTitle().equals(title)) {
				for(int j=i; j<index;j++) {
					swap(movies[i],movies[j]);
				}
			}
		}
		movies[index--] = null;
	}
	
	public int getSize() {
		return index;
	}
	
	private void swap(Movie a, Movie b) {
		Movie temp = null;
		
		temp = a;
		a = b;
		b = temp;
	}
}







