package com.encore.spring.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//MultiPartfile이랑 Form정보
public class MultifileVO {
	private String userName;
	private	List<MultipartFile> file; //변수명 중요!! 무조건 input tag내의 name으로!!
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public List<MultipartFile> getFile() {return file;}
	public void setFile(List<MultipartFile> file) {this.file = file;}
	
}
