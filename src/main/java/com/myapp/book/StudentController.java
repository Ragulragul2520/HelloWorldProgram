package com.myapp.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/studentadmin")
public class StudentController {
	@Autowired
	StudentService studSer;
	
	@PostMapping(value="/addDetail")
	public String addDetail(@RequestBody Student s) throws AgeNotEligibleException {
		System.out.println("Git Hub");
		return studSer.addDetail(s);
	}
	@GetMapping(value="/getDetailList")
	public List<Student> getDetailList() {
		return studSer.getDetailList();
	}
	@GetMapping(value="/getDetail/{id}")
	public Student getDetail(@PathVariable int id) {
		return studSer.getDetail(id);
	}
	@DeleteMapping(value="/deleteDetail/{id}")
	public String deleteDetail(@PathVariable int id) {
		return studSer.deleteDetail(id);
	}
}
