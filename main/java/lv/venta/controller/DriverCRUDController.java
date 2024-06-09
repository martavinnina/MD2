package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Driver;
import lv.venta.service.IDriverCRUDService;

@Controller
@RequestMapping("/driver")
public class DriverCRUDController {

	@Autowired
	private IDriverCRUDService driverService;
	
	@GetMapping("/all") //localhost:8080/driver/all
	public String selectAllDriver(Model model) {
		
		try {
			model.addAttribute("mydata", driverService.selectAllDriver());
			model.addAttribute("msg", "All drivers");
			return "driver-all-show-page"; //parādam course all show page
		} 
		
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
		
	}
	
	@GetMapping("/one") // localhost:8080/driver/one?id=2
	public String selectDriverById(@RequestParam("id") int id, Model model) {
		try
		{
			model.addAttribute("mydata", driverService.selectDriverById(id));
			return "driver-one-show-page";// tiek parādīta driver-one-show-page.html lapa
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}

	}
	
	@GetMapping("/delete/{id}")//localhost:8080/driver/delete/2
	public String deleteDriverById(@PathVariable("id") int id, Model model) {
		
		try {
			driverService.deleteDriverById(id);
			model.addAttribute("mydata", driverService.selectAllDriver());
			model.addAttribute("msg", "All drivers");
			return "driver-all-show-page";// tiek parādīta product-all-show-page.html lapa
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
		
	}
	
	@GetMapping("/insert") //localhost:8080/driver/insert
	public String insertNewDriver(Model model) {
		model.addAttribute("driver", new Driver());//noklusējuma produkts tiks padots uz lapu
		return "driver-insert-page";//tiek parādīta product-insert-page.html lapa
	}
	
	@PostMapping("/insert")
	public String postDriverInsert(@Valid Driver driver, BindingResult result) {
		if(result.hasErrors()) {
			return "driver-insert-page";
		}
		else
		{
			try {
				driverService.insertNewDriver(driver.getName(), driver.getSurname(),driver.getPersonCode(), driver.getLicenseNo(), driver.getExperienceInYears());
				return "redirect:/driver/all";
			} catch (Exception e) {
			
				return "redirect:/error";
			}
		}
	}
	
	
	@GetMapping("/update")//localhost:8080/driver/update?id=2
	public String updateDriverById(@RequestParam("id") int id, Model model) {
		
		try {
			Driver updatedDriver = driverService.selectDriverById(id);
			model.addAttribute("driver", updatedDriver);
			model.addAttribute("id", id);
			return "driver-update-page";//tiks parādīta product-update-page.html lapa ar atrasto produktu
			
			
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
	}
	
	
	@PostMapping("/update")
	public String postDriverUpdateById(@Valid Driver driver, 
			BindingResult result, @RequestParam("id") int id, Model model) {
		
	if(result.hasErrors()) {
		model.addAttribute("id", id);
		return "driver-update-page";//tiks parādīta product-update-page.html lapa ar atrasto produktu	
	}
	else
	{
		try
		{
			driverService.updateDriverById(id,driver.getName(), driver.getSurname(), 
				driver.getPersonCode(), driver.getLicenseNo(), driver.getExperienceInYears());
			return "redirect:/driver/all"; 
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
		
	}
	
}
}

