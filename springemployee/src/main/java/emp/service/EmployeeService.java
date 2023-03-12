package emp.service;

import java.util.List;
import java.util.Optional;

import emp.entity.Employee;

public interface EmployeeService { 
	
	int addEmployee(Employee emp);
	
	Optional<Employee> getEmployeeById(int empid);  
	
	void delete(int id);
	
	 List<Employee> getAllEmployeesRecords();
	 
	void updateEmployee(Employee emp); 
	List<Employee> searchByEmpName(String empname);

}
