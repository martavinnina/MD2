package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "AdressTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Adress {
	
	@Column(name ="IdA")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idA;
	
	
	@Column(name ="City")
	@NotNull
	private City City;
	
	
	@Min(0)
	@Column(name ="HouseNo")
	private int HouseNo;
	
	
	@Column(name ="StreetOrHouseTitle")
	@NotNull
	@Pattern(regexp ="[A-ZĀČĒĢĶĻŅŠŪŽ]{1}[a-zāčēģķīļņšūž]+")
	private String StreetOrHouseTitle;
	
	//viena adrese vairakam kompanijam
	@OneToMany(mappedBy = "adress")
    @ToString.Exclude
	private Collection<CustomerAsCompany> companyCustomers;
	
	
	//viena adrese vairakam personam
    @OneToMany(mappedBy = "adress")
	@ToString.Exclude
    private Collection<CustomerAsPerson> personCustomers;
		
	
	public Adress(City City,int HouseNo, String StreetOrHouseTitle) {
		setCity(City);
		setHouseNo(HouseNo);
		setStreetOrHouseTitle(StreetOrHouseTitle);
	}

}
