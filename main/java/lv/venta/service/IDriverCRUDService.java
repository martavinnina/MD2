package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Driver;



public interface IDriverCRUDService {
	public abstract ArrayList<Driver>selectAllDriver()
	        throws Exception;
	
	public abstract Driver selectDriverById(int idP)
	        throws Exception;
	
	public abstract void deleteDriverById(int idP)
	        throws Exception;
	
	public abstract void insertNewDriver(String name, String surname, String personCode, String licenseNo, float experienceInYears)
	     throws Exception;
	
	public abstract void updateDriverById(int idP, String name, String surname, String personCode, String licenseNo, float experienceInYears)
		     throws Exception;
}
