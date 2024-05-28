package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.model.City;
import lv.venta.model.Parcel;
import lv.venta.service.IParcelService;

@Service
public class ParcelServiceImpl implements IParcelService{

	@Override
	public ArrayList<Parcel> selectAllParcelsByCustomerId(int idC) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredByDriverId(int idP) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsPriceLessThan(float price) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Parcel> selectAllParcelsDeliveredToCity(City city) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewParcelByCustomerCodeAndDriverId(String customerCode, int idP) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeParcelDriverByParcelIdAndDriverId(int idPa, int idDr) throws Exception {
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
