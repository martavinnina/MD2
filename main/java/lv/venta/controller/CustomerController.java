package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.model.CustomerAsCompany;
import lv.venta.model.CustomerAsPerson;
import lv.venta.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	
	@GetMapping("/insert/person") //localhost:8080/customer/insert/person
	public String insertNewCustomerAsPerson(Model model) {
		model.addAttribute("customerAsPerson", new CustomerAsPerson());
		return "customer-person-insert-page";
	}
	
	@PostMapping("/insert/person")
	public String postPersonInsert(@Valid CustomerAsPerson customerAsPerson, BindingResult result) {
		if(result.hasErrors()) {
			return "customer-person-insert-page"; 
		}
		else
		{
			try {
				customerService.insertNewCustomerAsPerson(customerAsPerson.getName(), customerAsPerson.getSurname(),customerAsPerson.getPersonCode(), customerAsPerson.getPhoneNo(), customerAsPerson.getAdress());
				return "redirect:/driver/all"; //testam
			} catch (Exception e) {
			
				return "redirect:/error";
			}
		}
	}
	
	
	@GetMapping("/insert/company") //localhost:8080/customer/insert/company
	public String insertNewCustomerAsCompany(Model model) {
		model.addAttribute("customerAsCompany", new CustomerAsCompany());
		return "customer-company-insert-page";
	}
	
	@PostMapping("/insert/company")
	public String postCompanyInsert(@Valid CustomerAsCompany customerAsCompany, BindingResult result) {
		if(result.hasErrors()) {
			return "customer-company-insert-page"; 
		}
		else
		{
			try {
				customerService.insertNewCustomerAsCompany(customerAsCompany.getTitle(), customerAsCompany.getPhoneNo(), customerAsCompany.getCompanyRegNo(), customerAsCompany.getAdress());
				return "redirect:/customer"; //testam
			} catch (Exception e) {
			
				return "redirect:/error";
			}
		}
	}
	
	
	
}
