package com.myapp.employee;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/carget")
public class GetCars {
	RestTemplate rest=new RestTemplate();
	@GetMapping(value="/getcars")
	public List<Car> getCarViaEmployee(){
		String url="http://localhost:8080/car/getvalues";
		ResponseEntity<List<Car>> response=rest.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Car>>(){});
		List<Car> value=response.getBody();
		return value;
	}
}

