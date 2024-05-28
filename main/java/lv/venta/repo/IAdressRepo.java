package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Adress;

public interface IAdressRepo extends CrudRepository<Adress, Integer> {

}
