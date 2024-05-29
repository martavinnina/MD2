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

@Service //Obligati!!
public class DriverCRUDServiceImpl implements IDriverCRUDService{
	
	
	@Autowired 
	private IDriverRepo driverRepo;
	
	
	
	@Override
	public ArrayList<Driver> selectAllDriver() throws Exception {
		if (driverRepo.count()==0)
			throw new Exception("Driver list is empty");
		
		return (ArrayList<Driver>) driverRepo.findAll();
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
		driverRepo.deleteById(idP);
	}
	

	@Override
	public Driver insertNewDriver(String name, String surname, String personCode, String licenseNo,
			float experienceInYears) throws Exception {
		
		if (name == null || surname == null || personCode == null || experienceInYears < 0)
			throw new Exception("Problems with input params");
		
		//Driver foundDriver = driverRepo.findByNameAndSurnameAndPersonCode(name,surname,personCode);
		
		if(driverRepo.existsByNameAndSurnameAndPersonCode) 
			throw new Exception("Driver already exists!");
		
		Driver newDriver = new Driver(name, surname, personCode, licenseNo, experienceInYears);
		return newDriver;
	}

	
	@Override
	public void updateDriverById(int idP, String name, String surname, String personCode, String licenseNo,
			float experienceInYears) throws Exception {
		
		Driver updateDriver = selectDriverById(idP);
		if(name != null) updateDriver.setName(name);
		if(surname != null) updateDriver.setSurname(surname);
		if(personCode != null) updateDriver.setPersonCode(personCode);
		if(licenseNo != null) updateDriver.setLicenseNo(licenseNo);
		if(experienceInYears > 0) updateDriver.setLicenseNo(licenseNo);
		driverRepo.save(updateDriver);
		
	}

}
