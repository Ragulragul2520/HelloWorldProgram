package com.myapp.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class StudentService {
	@Autowired
	StudentDao studDao;
	@ExceptionHandler
	public String addDetail(Student s) throws AgeNotEligibleException {
		try {
			if(s.getAge()<=18) {
				throw new AgeNotEligibleException("Age must be above 18");
			}
			else{
				return studDao.addDetail(s);
			}
		}
		catch (AgeNotEligibleException ae){
				return ae.getMessage();
		}
		
	
	}
	public List<Student> getDetailList() {
		return studDao.getDetailList();
	}
	public Student getDetail(int id) {
		return studDao.getDetail(id);
	}
	public String deleteDetail(int id) {
		return studDao.deleteDetail(id);
	}

}
