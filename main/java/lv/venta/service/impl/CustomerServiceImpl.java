package lv.venta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Adress;
import lv.venta.model.CustomerAsCompany;
import lv.venta.model.CustomerAsPerson;
import lv.venta.repo.ICustomerAsCompanyRepo;
import lv.venta.repo.ICustomerAsPersonRepo;
import lv.venta.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerAsPersonRepo customerRepo;
	
	@Autowired
	ICustomerAsCompanyRepo companyRepo;
	
	@Override
	public CustomerAsPerson insertNewCustomerAsPerson(String name, String surname, String personCode, String phoneNo, Adress adress)
			throws Exception {
		
		if (name == null || surname == null ||  personCode == null || phoneNo == null || adress == null)
			throw new Exception("Problems with input params");
		
		//if(customerRepo.existsByPers) 
		//	throw new Exception("This customer as person already exists!");
		
		CustomerAsPerson newCustomerAsPerson = new CustomerAsPerson(name, surname, personCode, phoneNo, adress);
		customerRepo.save(newCustomerAsPerson);
		return newCustomerAsPerson;
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerAsCompany insertNewCustomerAsCompany(String companyRegNo, String phoneNo, String title, Adress adress) throws Exception {
		if (companyRegNo == null || title == null | phoneNo == null || adress == null)
			throw new Exception("Problems with input params");
		
		if(companyRepo.existsByCompanyRegNoAndTitle) 
			throw new Exception("Driver already exists!");
		
		CustomerAsCompany newCustomerAsCompany = new CustomerAsCompany(companyRegNo, phoneNo,title, adress);
		companyRepo.save(newCustomerAsCompany);
		return newCustomerAsCompany;
	}

	
	@Override
	public void addAddressToCustomerByCustomerId(int idC) throws Exception {
		if(idC <= 0) throw new Exception("id should be positive");
		
		if(!customerRepo.existsById(idC) || !companyRepo.existsById(idC))
			throw new Exception("There is no customer with id" + idC);
		
		
		//Driver result = driverRepo.findById(idP).get();
		
		// TODO not finished
		
	}

}
