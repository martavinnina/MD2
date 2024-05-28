package lv.venta.service.impl;

import org.springframework.stereotype.Service;

import lv.venta.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void insertNewCustomerAsPerson(String name, String surname, String personCode, String phoneNo)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertNewCustomerAsCompany(String companyRegNo, String phoneNo, String title) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAddressToCustomerByCustomerId(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
