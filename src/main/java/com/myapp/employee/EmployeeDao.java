package com.myapp.employee;

import java.util.List;

//import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	
	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully added";
	}
	
	public Employee getEmployee(int id) {
		
		return empRepo.findById(id).get();
	}
	public String addlist(List<Employee>e) {
		empRepo.saveAll(e);
		return "Succesfully added";
	}
	public List<Employee> getEmployeeList() {
		return empRepo.findAll();
	}
	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "Deleted Successfully";
	}
	public String updateEmployee(Employee e,int id) {
		empRepo.save(e);
		return "Updated Successfully";
	}
	public String deleteAllEmployee() {
		empRepo.deleteAll();
		return "Deleted Successfully";
	}
	public List<Employee> getByEmployee() {
		return empRepo.findAll();
	}
	public List<Employee> getEmployeesBySalary(int salary) {
		return empRepo.getEmployeesBySalary(salary);
	}
	public List<Employee> getEmployeesByName(String name) {
		return empRepo.getEmployeesByName(name);
	}
	public List<Employee> getMaxSalary() {
		return empRepo.getMaxSalary();
	}
	public String addEmployee1(Employee e) {
		empRepo.save(e);
		return "Successfully added";
	}

}
