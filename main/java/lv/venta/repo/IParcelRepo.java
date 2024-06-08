package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lv.venta.model.City;
import lv.venta.model.Parcel;

public interface IParcelRepo extends CrudRepository<Parcel, Integer>{

	ArrayList<Parcel> findByPriceLessThan(float sizePrice);

	ArrayList<Parcel> findByDriverIdP(int idP);

	ArrayList<Parcel> findByCustomerAsPersonIdC2(int idC2);

	// ArrayList<Parcel> findByCity(@Param("parcelCity") int city);

}
