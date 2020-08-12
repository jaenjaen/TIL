package com.encore.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.domain.Greeting;

//Spring 4.3이상 사용 가능 요청하는 주소의 Convention이 굉장히 중요하다
@RestController
public class GreetingController {
	/*
	 * PostMapping을 못하는 이유? Restful은 화면이 없어서 값을 받아서 처리할 수 없으니까 (와꾸-폼 이 없으니까 확인못함)
	 * 그래서 Postman을 받아 사용함
	 */
	
	//필드 추가
	private static final String TEMPLATE = "HI! ,%s";
	private final AtomicLong counter = new AtomicLong(); //autoincrement효과
	
	//http://127.0.0.1:8888/rest/greet
	//RestController에 View 넘기면 안됨.
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "RestfulAPI");
	}
	
	/*
	 * @PathVariable은 파라미터를 URL 경로에 포함시키는 방법이다.
	 * {}를 이용해서 매핑되는 URL 경로에 작성해주면 @PathVariable으로 작성된 파라미터에 자동으로 Mapping
	 * {} 안의 이름과 파라미터명이 동일해야함 별 여러개 매 우 중 요
	 */
	//http://127.0.0.1:8888/greet/33
	@GetMapping("greet/{id}")
	public String showSample(@PathVariable int id) {
		return "Hello! Restful API! Welcome"+id+"!";
	}
	
	//http://127.0.0.1:8888/rest/greet2?name=hi
	@GetMapping("/greet2")
	public Greeting sayGreet2(@RequestParam(value="name", required=false, defaultValue="V2") String name) {
		
		return new Greeting(counter.incrementAndGet(),String.format(TEMPLATE, name));
	}
	
	
	
	
}//~
