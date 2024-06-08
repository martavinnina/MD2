package lv.venta.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ParcelTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Parcel {
	
	@Column(name = "IdPa")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idPa;
	
	@Column(name = "IsFragile")
	private boolean isFragile;
	
	@Column(name = "OrderCreated")
	private LocalDateTime orderCreated = LocalDateTime.now();
	
	@Column(name = "PlannedDelivery")
	@NotNull
	private LocalDateTime plannedDelivery;
	
	
	@Column(name = "Price")
	private float price;
	
	
	@Column(name = "Size")
	@NotNull
	private ParcelSize size;
	
	
	@ManyToOne //vairakam pacinam viens pircejs
	@JoinColumn(name = "IdC1")
	private CustomerAsCompany customerAsCompany;
	
	
	@ManyToOne //vairakam pacinam viens pircejs
	@JoinColumn(name = "IdC2") //tā kā sakrit idP soferim un personai, tad ieliku name
	private CustomerAsPerson customerAsPerson;
	
	
	//kolonna paradisies saja tabula
	//join column IDP (no driver)
	@ManyToOne //vairakam pacinam viens soferis
	@JoinColumn(name = "IdP")
	private Driver driver;
	
	

	
	public Parcel(LocalDateTime plannedDeliveryTime, ParcelSize size, boolean isFragile, Driver driver, CustomerAsCompany customerAsCompany) {
		setPlannedDelivery(plannedDeliveryTime);
		setSize(size);
		setFragile(isFragile);
		setPrice();
		setDriver(driver);
		setCustomerAsCompany(customerAsCompany);
	}
	
	public Parcel(LocalDateTime plannedDeliveryTime, ParcelSize size, boolean isFragile, Driver driver, CustomerAsPerson customerAsPerson) {
		setPlannedDelivery(plannedDeliveryTime);
		setSize(size);
		setFragile(isFragile);
		setPrice();
		setDriver(driver);
		setCustomerAsPerson(customerAsPerson);
	}
	
	
	
	
	public void setPrice() {
		//aprekins
		float sizePrice = 0;
		switch (size) {
	    	case XS:
	    		sizePrice = 1.99f; //1.99 eur TODO 
	    		break;
	    	case S:
	    		sizePrice = 1.99f * 2; //3.98 eur
	    		break;
	    	case M:
	    		sizePrice = 1.99f * 3; //5.97 eur
	    		break;
	    	case L:
	    		sizePrice = 1.99f * 4; //7.96 eur
	    		break;
	    	case XL:
	    		sizePrice = 1.99f * 5; //9.95 eur
	    		break;
	    	default:
	    		break;
		}
		if (isFragile) 
	        this.price = sizePrice + 2.99f; // Add fragile price
	     else
	        this.price = sizePrice; 
	    
	}
	
}
