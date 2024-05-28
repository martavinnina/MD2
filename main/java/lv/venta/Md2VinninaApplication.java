package lv.venta;



import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Adress;
import lv.venta.model.City;
import lv.venta.model.CustomerAsCompany;
import lv.venta.model.CustomerAsPerson;
import lv.venta.model.Driver;
import lv.venta.model.Parcel;
import lv.venta.model.ParcelSize;
import lv.venta.repo.IAdressRepo;
import lv.venta.repo.ICustomerAsCompanyRepo;
import lv.venta.repo.ICustomerAsPersonRepo;
import lv.venta.repo.IDriverRepo;
import lv.venta.repo.IParcelRepo;


@SpringBootApplication
public class Md2VinninaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Md2VinninaApplication.class, args);
	}
	@Bean
	public CommandLineRunner testDatabaseLayer(IAdressRepo adressRepo, ICustomerAsCompanyRepo companyRepo, 
			ICustomerAsPersonRepo customerRepo, IDriverRepo driverRepo, IParcelRepo parcelRepo)
	{
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				Adress ad1 = new Adress(City.Ventspils, 11, "Robežu");
				Adress ad2 = new Adress(City.Riga, 6, "Pulkveža");
				Adress ad3 = new Adress(City.Dobele, 10, "Zaļā");
				adressRepo.save(ad1);
				adressRepo.save(ad2);
				adressRepo.save(ad3);
				
				
				CustomerAsCompany cas1 = new CustomerAsCompany("12345679", "28615197","Ziedi&pušķi", ad2);
				CustomerAsCompany cas2 = new CustomerAsCompany("09845765", "20067890","EzītisMiglā", ad3);
				companyRepo.save(cas1);
				companyRepo.save(cas2);
				
				CustomerAsPerson cap1 = new CustomerAsPerson("Jānis", "Lapiņš", "034560-21465", "29321921", ad1);
				CustomerAsPerson cap2 = new CustomerAsPerson("Dana", "Vītola", "978654-21345", "29397851", ad2);
				customerRepo.save(cap1);
				customerRepo.save(cap2);
				
				Driver dr1 = new Driver("Ainārs", "Bumbieris","070878-21900", "AZ071597",12);
				Driver dr2 = new Driver("Jānis", "Viesulis","045698-34560", "AB094275",3.5f);		
				driverRepo.save(dr1);
				driverRepo.save(dr2);
				
				Parcel p1 =  new Parcel(LocalDateTime.of(2024, 3, 30, 15, 30, 0), ParcelSize.M, true, dr1);
				Parcel p2 =  new Parcel(LocalDateTime.of(2024, 5, 16, 15, 30, 0), ParcelSize.S, false, dr2);
				Parcel p3 =  new Parcel(LocalDateTime.of(2025, 6, 17, 15, 30, 0), ParcelSize.L, true, dr2);
				parcelRepo.save(p1);
				parcelRepo.save(p2);
				parcelRepo.save(p3);
				
				
			}
			
		};
	}

}
