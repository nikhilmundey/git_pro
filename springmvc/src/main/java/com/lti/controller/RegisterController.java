package com.lti.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.Customer;
import com.lti.service.CustomerService;

@Controller
public class RegisterController {
	
	
	/**
	 * Following are the different ways to access data and transfer control
	 */
//1.	public String register(HttpServletRequest request){ }
		
//2.	public String register(@RequestParam("name") String name, @RequestParam("email") String email){
//		return null;
//	}
	
	/**
	 * 
	 * Spring MVC has a feature to automatically save the input details in an object
	 * 
	 */
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="register.lti", method=RequestMethod.POST)
		public String register(Customer customer, @RequestParam("profilePic") MultipartFile m)
		{
			System.out.println(m.getOriginalFilename());
			
			String path = "d:/upload/";
			String finalpath = path + m.getOriginalFilename();
			
			
			try {
				m.transferTo(new File(finalpath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			customer.setProfile_pic(m.getOriginalFilename());
			customerService.register(customer);
			return "confirmation.jsp";
		
		}
	
	
	
	
}


