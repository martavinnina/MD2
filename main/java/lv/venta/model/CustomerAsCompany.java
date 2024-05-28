package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="CustomerAsCompanyTable")
@Entity
public class CustomerAsCompany {

	//bez mantošanas 
	@Column(name = "IdC1")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idC1;
	
	@Column(name = "CompanyRegNo")
	@NotNull
	@Pattern(regexp = "[0-9]{8}")
	private String companyRegNo;
	
	
	@Column(name = "CustomerCode")
	//@NotNull
	@Setter(value = AccessLevel.NONE)
	private String customerCode; 
	//TODO 
	
	@Column(name = "PhoneNo")
	@NotNull
	@Pattern(regexp = "[2]{1}[0-9]{7}")
	private String phoneNo;
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-ZĀČĒĢĶĻŅŠŪŽa-zāčēģķīļņšūž0-9!?/|$%&*]{3,20}")
	private String title;
	
	@ManyToOne //vairakiem customer viena adrese
	@JoinColumn(name = "IdA")
	private Adress adress;
	
	@OneToMany(mappedBy = "customerAsCompany") 
	@ToString.Exclude 
	private Collection<Parcel> parcelsCompany; 
	
	
	public CustomerAsCompany(String companyRegNo,String phoneNo, String title, Adress adress) {
		setCompanyRegNo(companyRegNo);
		setPhoneNo(phoneNo);
		setTitle(title);
		setAdress(adress);
	}
	
	 public void CustomerCodeCreation(){
	        this.customerCode = this.getIdC1() + "_company_" + this.getCompanyRegNo();
	    }
	
}
