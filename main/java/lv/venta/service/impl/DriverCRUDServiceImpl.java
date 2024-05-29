package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Driver;
import lv.venta.repo.IAdressRepo;
import lv.venta.repo.ICustomerAsCompanyRepo;
import lv.venta.repo.ICustomerAsPersonRepo;
import lv.venta.repo.IDriverRepo;
import lv.venta.repo.IParcelRepo;
import lv.venta.service.IDriverCRUDService;

@Service
public class DriverCRUDServiceImpl implements IDriverCRUDService{
	
	@Autowired
	private IAdressRepo adressRepo;
	
	
	@Autowired
	private ICustomerAsPersonRepo customerRepo;
	
	@Autowired
	private IDriverRepo driverRepo;
	
	@Autowired
	private IParcelRepo parcelRepo;
	
	
	@Override
	public ArrayList<Driver> selectAllDriver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver selectDriverById(int idP) throws Exception {
		if(idP <= 0) throw new Exception("id should be positive");
		
		if(!driverRepo.existsById(idP))
			throw new Exception("There is no driver with id" + idP);
		
		 Driver result = driverRepo.findById(idP).get();
		return result;
	}

	
	@Override
	public void deleteDriverById(int idP) throws Exception {
		if(idP <= 0) throw new Exception("id should be positive");
		
		if(!driverRepo.existsById(idP))
			throw new Exception("There is no driver with id" + idP);
		driverRepo.
		//Driver result = driverRepo.deleteById(idP);
		//return result;
	     
	}
	

	@Override
	public void insertNewDriver(String name, String surname, String personCode, String licenseNo,
			float experienceInYears) throws Exception {
		
		/* Driver driver = driverRepo.findByLicenseNo(licenseNo);
		 if (driver == null) {
			 
		 }
		// TODO Auto-generated method stub
		
		*/
	}

	@Override
	public void updateDriverById(int idP, String name, String surname, String personCode, String licenseNo,
			float experienceInYears) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
