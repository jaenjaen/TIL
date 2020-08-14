package com.encore.emp.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@Api(tags= {"Encore HRM"})
public class EmployeeController {

	@Autowired
	private EmpService service;
	
	@ApiOperation(value="모든 사원의 정보 반환", response=List.class)
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() throws Exception{
		List<EmployeeDto> emps = service.findAllEmployees();
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps,HttpStatus.OK);
	}
	
	@ApiOperation(value="모든 사원의 수를 반환", response=Integer.class)
	@GetMapping("/getEmployeesTotal")
	public ResponseEntity getEmployeesTotal() throws Exception{
		int total = service.getEmployeesTotal();
		if (total == 0) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(total,HttpStatus.OK);
	}
	
	@ApiOperation(value="사원아이디로 사원을 찾음", response=EmployeeDto.class)
	@GetMapping("/findEmployeeById/{id}")
	public ResponseEntity findEmployeeById(@PathVariable int id) throws Exception{
		EmployeeDto emp = service.findEmployeeById(id);
		if(emp == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emp,HttpStatus.OK);
	}
	
	@ApiOperation(value="사원이름으로 사원을 찾음", response=EmployeeDto.class)
	@GetMapping("/findLikeEmployees/{name}")
	public ResponseEntity findLikeEmployees(@PathVariable String name) throws Exception{
		List<EmployeeDto> emps = service.findLikeEmployees(name);
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps,HttpStatus.OK);
	}
	
	
	@ApiOperation(value="특정한 매니저에 소속된 사원들을 찾음", response=EmployeeDto.class) //collection의 generic
	@GetMapping("/findEmployeesByManagerId/{managerId}")
	public ResponseEntity findEmployeesByManagerId(@PathVariable int managerId) throws Exception{
		List<EmployeeDto> emps = service.findEmployeesByManagerId(managerId);
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps,HttpStatus.OK);
	}
	
	@ApiOperation(value="사원추가", response=EmployeeDto.class)
	@PostMapping("/addEmployees")
	public ResponseEntity addEmployees(@RequestBody EmployeeDto dto) throws Exception{
		service.addEmployee(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(value="사원수정", response=EmployeeDto.class)
	@PutMapping("/updateEmployee")
	public ResponseEntity updateEmployee(@RequestBody EmployeeDto dto) throws Exception{
		service.updateEmployee(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(value="사원삭제", response=EmployeeDto.class)
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity delete(@PathVariable int id) throws Exception{
		service.deleteEmployee(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
