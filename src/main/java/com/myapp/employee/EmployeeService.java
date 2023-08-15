package com.myapp.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public Employee getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	public String addlist(List<Employee> e) {
		return empDao.addlist(e);
	}

	public List<Employee> getEmployeeList() {
		return empDao.getEmployeeList();
	}

	public String deleteEmployee(int id) {
		return empDao.deleteEmployee(id);
	}

	public String updateEmployee(Employee e) {
		return empDao.updateEmployee(e, 0);
	}

	public String deleteAllEmployee() {
		return empDao.deleteAllEmployee();
	}

	public List<Employee> getById(int id) {
		List<Employee> byId = empDao.getByEmployee();
		return byId.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
	}

	public List<Employee> getByName(String name) {
		List<Employee> byName = empDao.getByEmployee();
		return byName.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	public List<Employee> getByAge(int age) {
		List<Employee> byage = empDao.getByEmployee();
		return byage.stream().filter(x -> x.getAge() == age).collect(Collectors.toList());
	}

	public List<Employee> getBySalary(int salary) {
		List<Employee> bySalary = empDao.getByEmployee();
		return bySalary.stream().filter(x -> x.getSalary() == salary).collect(Collectors.toList());
	}

	public List<String> getByNamesOnly() {
		List<Employee> namesOnly = empDao.getByEmployee();
		return namesOnly.stream().filter(x -> x.getGender().equalsIgnoreCase("female")).map(y -> y.getName())
				.collect(Collectors.toList());
	}

	/*public List<Employee> increaseSalary() {
		List<Employee> salary=empDao.getByEmployee();
		return salary.stream().map(x->
								{if(x.getAge()>=30 && x.getAge()<=35) {
									x.setSalary(x.getSalary()+x.getSalary()*10/100);
								}
								if(x.getAge()>=36 && x.getAge()<=40) {
									x.setSalary(x.getSalary()+x.getSalary()*15/100);
								}
								if(x.getAge()>=41 && x.getAge()<=50) {
									x.setSalary(x.getSalary()+x.getSalary()*20/100);
								}}).collect(Collectors.toList());
	}	*/
	public List<Employee> getEmployeesBySalary(int salary) {
		return empDao.getEmployeesBySalary(salary);
	}
	public List<Employee> getEmployeesByName(String name) {
		return empDao.getEmployeesByName(name);
	}
	public List<Employee> getMaxSalary() {
		return empDao.getMaxSalary();
	}
	@ExceptionHandler
	public String addEmployee1(Employee e) throws AgeNotEligibleExceptions {
		try{
			if(e.getAge()<18) {
		
			throw new AgeNotEligibleExceptions("Age below 18 is not eligible");
		}
		else {
			return empDao.addEmployee1(e);
		}
		}
		catch(AgeNotEligibleExceptions ae) {
			return ae.getMessage();
		}
	}
	
	public List<Employee> getByName1(String name) throws NameNotFoundException {
		List<Employee> byname=empDao.getByEmployee();
		List<Employee> checkIsThereName=byname.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if(checkIsThereName.isEmpty()) {
			throw new NameNotFoundException("There is no data in this name");
		}
		else {
			return checkIsThereName;
		}
	}
	public List<Employee> getByAge1(int age) throws AgeNotFoundException {
		List<Employee> byAge=empDao.getByEmployee();
		List<Employee> checkIsAge=byAge.stream().filter(x->x.getAge()==age).collect(Collectors.toList());
		if(checkIsAge.isEmpty()) {
			throw new AgeNotFoundException("No data found in this age");
		}
		else {
			return checkIsAge;
		}
	}
	public List<Employee> getSalary(int salary) throws SalaryNotFoundException {
		List<Employee> bySalary=empDao.getByEmployee();
		List<Employee> checkBySalary=bySalary.stream().filter(x->x.getSalary()==salary).collect(Collectors.toList());
		if(checkBySalary.isEmpty()) {
			throw new SalaryNotFoundException("No data found in this salary");
		}
		else {
			return checkBySalary;
		}
	}
		
}
