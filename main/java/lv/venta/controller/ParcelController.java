package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Parcel;
import lv.venta.service.IParcelService;

@Controller
@RequestMapping("/parcel")
public class ParcelController {

	@Autowired
	private IParcelService parcelService;
	
	
	@GetMapping("/price/{sizePrice}")//localhost:8080/parcel/price/
	public String selectAllParcelsPriceLessThan(@PathVariable("sizePrice") float sizePrice,
			Model model) {
		
		try
		{
			ArrayList<Parcel> parcelFilter 
			= parcelService.selectAllParcelsPriceLessThan(sizePrice);
			model.addAttribute("mydata", parcelFilter);
			model.addAttribute("msg", "Parcels filtered by price: " + sizePrice + " eur");
			return "parcel-all-show-page";// tiek parādīta product-all-show-page.html lapa

		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	
	}
	
	
}
