package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.City;
import lv.venta.model.Driver;
import lv.venta.model.Parcel;
import lv.venta.repo.ICustomerAsCompanyRepo;
import lv.venta.repo.ICustomerAsPersonRepo;
import lv.venta.repo.IDriverRepo;
import lv.venta.repo.IParcelRepo;
import lv.venta.service.IParcelService;

@Service //Obligati!!
public class ParcelServiceImpl implements IParcelService{

	@Autowired
	IParcelRepo parcelRepo;
	
	@Autowired
	ICustomerAsPersonRepo customerRepo;
	
	@Autowired
	ICustomerAsCompanyRepo companyRepo;
	
	@Autowired 
	private IDriverRepo driverRepo;
	
	@Override
	public ArrayList<Parcel> selectAllParcelsByCustomerIdC2(int idC2) throws Exception {
		
		if(idC2 <= 0) throw new Exception("id should be positive");
		
		if(!customerRepo.existsById(idC2)) //izveidota funkcija, kas atbilst tikai customerAsPerson
			throw new Exception("There is no customerAsPerson with id" + idC2);
		
		if (parcelRepo.count()==0)
			throw new Exception("parcel list is empty");
		
		ArrayList<Parcel> result = parcelRepo.findByCustomerAsPersonIdC2(idC2);
		return result;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredByDriverIdP(int idP) throws Exception {
		if(idP <= 0) throw new Exception("id should be positive");
		
		if(!driverRepo.existsById(idP)) //izveidota funkcija, kas atbilst tikai customerAsPerson
			throw new Exception("There is no driver with id" + idP);
		
		if (parcelRepo.count()==0)
			throw new Exception("parcel list is empty");
		
		ArrayList<Parcel> result = parcelRepo.findByDriverIdP(idP);
		return result;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsPriceLessThan(float sizePrice) throws Exception {
		if(sizePrice < 0 || sizePrice > 10000 ) throw new Exception("The limit of price is wrong");
		
		ArrayList<Parcel> result = parcelRepo.findByPriceLessThan(sizePrice);
		
		return result;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredToCity(City city) throws Exception {
		
		if(city == null ) throw new Exception("Problems with input params");
		
		if (parcelRepo.count()==0)
			throw new Exception("parcel list is empty");
		
		
		return null;
	}

	@Override
	public void insertNewParcelByCustomerCodeAndDriverIdP(String customerCode, int idP) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeParcelDriverByParcelIdPaAndDriverIdP(int idPa, int idDr) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateIncomeOfParcelsByCustomerId(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateHowManyParcelsNeedToDeliverToday() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
