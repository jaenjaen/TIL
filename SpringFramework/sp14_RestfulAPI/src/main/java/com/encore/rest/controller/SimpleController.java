package com.encore.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.domain.Person;

@RestController
@RequestMapping("/sample")
public class SimpleController {
	
	//http://127.0.0.1:8888/rest/sample/hello
	//->http://127.0.0.1:8888/sample/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Restful Service!";
	}
	
	@GetMapping("/greet")
	public Person sayGreet() {
		Person vo = new Person("김선호","잘생겼다.");
		return vo;
	}
	
	@GetMapping("/allGreet")
	public List<Person> allGreet(){
		List<Person> list = new ArrayList<Person>();
		for(int i=0; i<3; i++){
			
			Person vo = new Person();
			
			vo.setName("김뫄뫄"+i);
			vo.setMsg("뫄뫄씨! 하고 "+i+"번 불렀다.");
			list.add(vo);
		}
		
		return list;
	}
	
	//단순 객체를 쓰는거보다 잘짜여진 Map을 사용하는 횟수가 높음.
	@GetMapping("/sendGreet")
	public Map<Integer,Person> sendGreet(){
		Map<Integer,Person> map= new HashMap<Integer, Person>();
		map.put(1, new Person("김솨솨","배아팡..ㅜㅜ"));
		return map;
	}
	
	
}
