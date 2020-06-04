package book.model;

import java.util.Date;

public class BookVo {
	private String isbn;
	private String title;
	private String kinds;
	private String country;
	private String release;
	private String publisher;
	private String writer;
	private int price;
	private String unit;
	private String desc;
	
	
	
	public BookVo(String isbn, String title, String kinds, String writer) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.kinds = kinds;
		this.writer = writer;
	}

	public BookVo(String isbn, String title, String kinds, String country, String release, String publisher,
			String writer, int price, String unit, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.kinds = kinds;
		this.country = country;
		this.release = release;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
		this.unit = unit;
		this.desc = desc;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "BookVo [isbn=" + isbn + ", title=" + title + ", kinds=" + kinds + ", country=" + country + ", release="
				+ release + ", publisher=" + publisher + ", writer=" + writer + ", price=" + price + ", unit=" + unit
				+ ", desc=" + desc + "]";
	}
}
