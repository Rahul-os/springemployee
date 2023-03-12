package emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emp.entity.Employee;
import emp.exceptions.EmployeeNotFoundException;
import emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	@Autowired 
	EmployeeRepository emprep ;

	@Override
	public int addEmployee(Employee emp) {
		
		emprep.save(emp);
		return emp.getEmpcode();
	}

	@Override
	public Optional<Employee> getEmployeeById(int empcode) {
		
		Optional<Employee> emp = emprep.findById(empcode);
		if(emp.isEmpty())
			throw new EmployeeNotFoundException();
		return emp;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub 
		emprep.deleteById(id);
		
	}

	@Override
	public List<Employee> getAllEmployeesRecords() {
		// TODO Auto-generated method stub
		return emprep.findAll();
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		 emprep.save(emp);
		 
	}

	@Override
	public List<Employee> searchByEmpName(String empname) {
		// TODO Auto-generated method stub
		return emprep.searchByEmpName(empname);
	}

	
	
	
	

}
