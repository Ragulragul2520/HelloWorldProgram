package com.myapp.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository studRepo;
	
	public String addDetail(Student s) {
		studRepo.save(s);
		return "Added Successfully";
	}
	public List<Student> getDetailList() {
		return studRepo.findAll();
	}
	public Student getDetail(int id) {
		return studRepo.findById(id).get();
	}
	public String deleteDetail(int id) {
		studRepo.deleteById(id);
		return "Deleted Successfully";
	}

}
