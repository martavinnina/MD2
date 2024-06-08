package lv.venta.repo;

import lv.venta.model.Driver;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface IDriverRepo extends CrudRepository<Driver, Integer>{

	boolean existsByNameAndSurnameAndPersonCode = false;

	boolean existsByIdP(int idP);

	Driver findById(int idP)throws Exception;

	//Driver findByNameAndSurnameAndPersonCode(String name, String surname, String personCode);

}
