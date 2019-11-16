package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.Customer;
import com.lti.repository.CustomRepo;


//again insted of @Component we will use @Service
@Service
public class CustomerService {

	@Autowired
	private CustomRepo customRepo;
	
	@Autowired
	private SendMailService sendMailService;
	
	public void register(Customer customer)
	{
		customRepo.add(customer);
	//	sendMailService.send(customer.getEmail(), "Thankyou", "Email By Spring");
	}
}
