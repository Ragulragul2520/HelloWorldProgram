package com.myapp.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	@Query(value="SELECT * from employee_details where salary>=?",nativeQuery=true)
	public List<Employee> getEmployeesBySalary(int salary);
	
	@Query(value="select * from employee_details where name like %?",nativeQuery=true)
	public List<Employee> getEmployeesByName(String name);
	
	@Query(value="select select max(salary) from employee_details",nativeQuery=true)
	public List<Employee> getMaxSalary();
}
