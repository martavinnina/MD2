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
import lv.venta.model.Person;
import lv.venta.repo.IAdressRepo;
import lv.venta.repo.ICustomerAsCompanyRepo;
import lv.venta.repo.ICustomerAsPersonRepo;
import lv.venta.repo.IDriverRepo;
import lv.venta.repo.IParcelRepo;
import lv.venta.repo.IPersonRepo;


@SpringBootApplication
public class Md2VinninaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Md2VinninaApplication.class, args);
	}
	@Bean
	public CommandLineRunner testDatabaseLayer(IAdressRepo adressRepo, ICustomerAsCompanyRepo companyRepo, 
			ICustomerAsPersonRepo customerRepo, IDriverRepo driverRepo, IParcelRepo parcelRepo, IPersonRepo persRepo)
	{
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				Adress ad1 = new Adress(City.Ventspils, 11, "Robezu");
				Adress ad2 = new Adress(City.Riga, 6, "Pulkveza");
				Adress ad3 = new Adress(City.Dobele, 10, "Zala");
				adressRepo.save(ad1);
				adressRepo.save(ad2);
				adressRepo.save(ad3);
				
				
				CustomerAsCompany cac1 = new CustomerAsCompany("12345679", "28615197","Ziedi&pušķi", ad2);
				CustomerAsCompany cac2 = new CustomerAsCompany("09845765", "20067890","EzītisMiglā", ad3);
				companyRepo.save(cac1);
				companyRepo.save(cac2);
				
				cac1.CustomerCodeCreation();
				cac2.CustomerCodeCreation();
				companyRepo.save(cac1);
				companyRepo.save(cac2);
				
				Person pers1 = new Person ("Janis", "Lapins", "034560-21465");
				Person pers2 = new Person ("Dana", "Vitola", "978654-21345");
				persRepo.save(pers1);
				persRepo.save(pers2);
				
				
				CustomerAsPerson cap1 = new CustomerAsPerson(pers1, "29321921", ad1);
				CustomerAsPerson cap2 = new CustomerAsPerson(pers2, "29397851", ad2);
				customerRepo.save(cap1);
				customerRepo.save(cap2);
				
				cap1.customerCodeCreation();
				cap2.customerCodeCreation();
				customerRepo.save(cap1);
				customerRepo.save(cap2);
				
				
				Driver dr1 = new Driver("Ainars", "Bumbieris","070878-21900", "AZ071597",12);
				Driver dr2 = new Driver("Janis", "Viesulis","045698-34560", "AB094275",3.5f);		
				driverRepo.save(dr1);
				driverRepo.save(dr2);
				
				
				Parcel p1 =  new Parcel(LocalDateTime.of(2024, 3, 30, 15, 30, 0), ParcelSize.M, true, dr1, cac1);
				Parcel p2 =  new Parcel(LocalDateTime.of(2024, 5, 16, 15, 30, 0), ParcelSize.S, false, dr2, cac2);
				Parcel p3 =  new Parcel(LocalDateTime.of(2025, 6, 17, 15, 30, 0), ParcelSize.L, true, dr2, cap1);
				Parcel p4 =  new Parcel(LocalDateTime.of(2025, 6, 17, 15, 30, 0), ParcelSize.L, true, dr2, cap2);
				parcelRepo.save(p1);
				parcelRepo.save(p2);
				parcelRepo.save(p3);
				parcelRepo.save(p4);
				
			}
			
		};
	}

}
