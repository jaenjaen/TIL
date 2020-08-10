package com.encore.spring.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadDataVO {
	private String userName;
	private MultipartFile uploadFile; // form의 이름으로 변수명 지정 해야함 꼭!!!!!!
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public MultipartFile getUploadFile() {return uploadFile;}
	public void setUploadFile(MultipartFile uploadFile) {this.uploadFile = uploadFile;}
	
}
