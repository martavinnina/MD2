package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.City;
import lv.venta.model.Parcel;

public interface IParcelService {

	//i
	public abstract ArrayList<Parcel>selectAllParcelsByCustomerAsPersonId(int idC2)
	        throws Exception;
	//ii
	public abstract ArrayList<Parcel>selectAllParcelsDeliveredByDriverId(int idP)
	        throws Exception;
	//iii
	public abstract ArrayList<Parcel>selectAllParcelsPriceLessThan(float sizePrice)
	        throws Exception;
	
	//iv
	public abstract ArrayList<Parcel>selectAllParcelsDeliveredToCity(City city)
	        throws Exception;
	
	//v
	public abstract void insertNewParcelByCustomerCodeAndDriverId(String customerCode, int idP)
			 throws Exception;
	
	//vi
	public abstract void changeParcelDriverByParcelIdPaAndDriverId(int idPa, int idDr)
			 throws Exception;
	
	//vii
	public abstract void calculateIncomeOfParcelsByCustomerId(int id)
			throws Exception;
	
	//viii
		public abstract void calculateHowManyParcelsNeedToDeliverToday()
				throws Exception;
	
}
