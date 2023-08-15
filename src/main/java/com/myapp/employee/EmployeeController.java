package com.myapp.employee;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empser;
	@PostMapping(value="/add")
	public String addEmployee(@RequestBody Employee e) {
		return empser.addEmployee(e);
	}
	
	@GetMapping(value="/getvalue/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empser.getEmployee(id);
	}
	@PostMapping(value="/addlist")
	public String addlist(@RequestBody List<Employee>e){
		return empser.addlist(e);
	}
	@GetMapping(value="/getall")
	public List<Employee> getEmployeeList() {
		return empser.getEmployeeList();
	}
	@DeleteMapping(value="/deleteRow/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empser.deleteEmployee(id);
	}
	@PutMapping(value="/update")
	public String updateEmployee(Employee e) {
		return empser.updateEmployee(e);
	}
	@DeleteMapping(value="/deleteAllRow")
	public String deleteAllEmployee() {
		return empser.deleteAllEmployee();
	}
	@GetMapping(value="getById/{id}")
	public List<Employee> getById(int id)  {
		return empser.getById(id);
	}
	@GetMapping(value="/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) throws NameNotFoundException {
		return empser.getByName1(name);
	}
	@GetMapping(value="/getByAge/{age}")
	public List<Employee> getByAge(@PathVariable int age) throws AgeNotFoundException{
		return empser.getByAge1(age);
	}
	@GetMapping(value="/getBySalary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empser.getBySalary(salary);
	}
	@GetMapping(value="/getNamesOnly")
	public List<String> getByNamesOnly() {
		return empser.getByNamesOnly();
	}
	/*@GetMapping(value="/increaseSalary")
	public List<Employee> increaseSalary() {
		return empser.increaseSalary();
	}*/
	@GetMapping(value="getsalary/{salary}")
	public List<Employee> getEmployeesBySalary(@PathVariable int salary) {
		return empser.getEmployeesBySalary(salary);
	}
	@GetMapping(value="getname/{name}")
	public List<Employee> getEmployeesBySalary(@PathVariable String name) {
		return empser.getEmployeesByName(name);
	}
	@GetMapping(value="maxSalary")
	public List<Employee> getmaxSalary() {
		return empser.getMaxSalary();
	}
	@PostMapping(value="/addage")
	public String addEmployee1(@RequestBody Employee e) throws AgeNotEligibleExceptions {
		return empser.addEmployee1(e);
	}
	@GetMapping(value="/getSalary/{salary}")
	public List<Employee> getSalary(@RequestBody int salary) throws SalaryNotFoundException {
		return empser.getSalary(salary);
	}
	//RestTemplate rest=new RestTemplate();
	
	
	
}