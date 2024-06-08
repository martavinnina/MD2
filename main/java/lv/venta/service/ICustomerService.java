package lv.venta.service;

import lv.venta.model.Adress;
import lv.venta.model.CustomerAsCompany;
import lv.venta.model.CustomerAsPerson;

public interface ICustomerService {
	
	public abstract CustomerAsPerson insertNewCustomerAsPerson(String name, String surname, String personCode, String phoneNo, Adress adress)
			throws Exception;
	
	public abstract CustomerAsCompany insertNewCustomerAsCompany(String companyRegNo,String phoneNo, String title, Adress adress)
			throws Exception;
	
	public abstract void addAddressToCustomerByCustomerId(int id)
			throws Exception;
	
}
