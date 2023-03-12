package emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import emp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{ 
	
	//custom usedefined method
	
	@Query(value = "select e from Employee e where e.empname like %?1% ")
	

	List<Employee> searchByEmpName(String name);

}
