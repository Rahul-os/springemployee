package emp.controllers;

import java.util.List;
import java.util.Optional;

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


import emp.entity.Employee;
import emp.service.EmployeeService;

@RestController
@RequestMapping("/employee") 

public class EmployeeController { 
	@Autowired 
	EmployeeService empservice;
	
	@PostMapping 
	public ResponseEntity<String> addNewemployee(@RequestBody Employee employee){  //data sent from postman will be in employee object.
		int id = empservice.addEmployee(employee);                // from here the control will move to addEmployee method of serImpl
		return new ResponseEntity<String>("employee inserted:"+id,HttpStatus.OK);  //it will display a msg in the postman
	}
	
	@GetMapping("empcode/{employeecode}") //even though the below is deletemapping it dint work when i didnt put "empcode/{employeecode}"
	public ResponseEntity<Optional<Employee>> getEmployeeId (@PathVariable("employeecode") int employeecode){
		Optional<Employee> employee = empservice.getEmployeeById(employeecode);
		return new ResponseEntity<Optional<Employee>>(employee,HttpStatus.OK);
	} 
	
	@DeleteMapping("/{employeecode}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeecode") int employeecode){
		empservice.delete(employeecode);
		return new ResponseEntity<String>("employee record deleted"+employeecode,HttpStatus.OK);
	}
	
	@GetMapping("getallemployees")
	public ResponseEntity<List<Employee>> getAllEmployeesRecords(){
		List<Employee> emplist = empservice.getAllEmployeesRecords();
		return new ResponseEntity<List<Employee>>(emplist , HttpStatus.OK);
	}
	
	@PutMapping 
	
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		empservice.updateEmployee(employee);
		return new ResponseEntity<String> ("updated",HttpStatus.OK);
	}
	
	@GetMapping("/{employeename}")
	public ResponseEntity<List<Employee>> searchByEmpName(@PathVariable("employeename") String name){
		List<Employee> emplist = empservice.searchByEmpName(name);
		return new ResponseEntity<>(emplist,HttpStatus.OK);
 	}

}
