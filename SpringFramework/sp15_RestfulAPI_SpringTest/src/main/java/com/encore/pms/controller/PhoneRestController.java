package com.encore.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@RestController
public class PhoneRestController {
	
	@Autowired
	private IPhoneService service;
	
	@GetMapping("/phone/{num}") //selectOne
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			
			Phone selected = service.select(phone);
			return new ResponseEntity(selected,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	/*
	 * GetMapping("/phone") //select All
	 * PostMapping("/phone") //insert
	 * convention 맞춰서 넣어야한다. 
	 */
	
	@GetMapping("/phone")
	public ResponseEntity select(){
		try {
			List<Phone> list = service.select();
			return new ResponseEntity(list,HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			int result = service.insert(phone);
			return new ResponseEntity(HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			//받아올 때 string으로 받아서 그걸 list로 변환
			int result = service.delete(Arrays.asList(num));
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	/*
	 * update 예시
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		int result = service.update(phone);
		if(result>0) return new ResponseEntity(HttpStatus.OK);
		else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	*/
}
