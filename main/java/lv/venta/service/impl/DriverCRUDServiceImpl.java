package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.model.Driver;
import lv.venta.service.IDriverCRUDService;

@Service
public class DriverCRUDServiceImpl implements IDriverCRUDService{

	@Override
	public ArrayList<Driver> selectAllDriver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Driver> selectDriverById(int idP) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Driver> deleteDriverById(int idP) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewDriver(String name, String surname, String personCode, String licenseNo,
			float experienceInYears) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDriverById(int idP, String name, String surname, String personCode, String licenseNo,
			float experienceInYears) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
