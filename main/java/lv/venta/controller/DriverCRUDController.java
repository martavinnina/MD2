package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
}
