package lv.venta.service;


public interface ICustomerService {
	
	public abstract void insertNewCustomerAsPerson(String name, String surname, String personCode, String phoneNo)
			throws Exception;
	
	public abstract void insertNewCustomerAsCompany(String companyRegNo,String phoneNo, String title)
			throws Exception;
	
	public abstract void addAddressToCustomerByCustomerId(int id)
			throws Exception;
	
}
