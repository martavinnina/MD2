package lv.venta.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name="CustomerAsPersonTable")
@Entity

public class CustomerAsPerson {


	@Column(name = "IdC2")
	@Setter(value = AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idC2;
	
	
	@Column(name = "CustomerCode")
	private String customerCode; 
	
	
	@Column(name = "PhoneNo")
	@NotNull
	@Pattern(regexp = "[2]{1}[0-9]{7}")
	private String phoneNo;
	
	
	@ManyToOne //vairakiem customer persons viena adrese
	@JoinColumn(name = "IdA")
	private Adress adress;
	
	@OneToMany(mappedBy = "customerAsPerson") 
	@ToString.Exclude 
	private Collection<Parcel> parcelsPerson; 
	
	
	 @OneToOne
	 @JoinColumn(name = "IdP")
	 private Person person;
	
	 
	public CustomerAsPerson(Person person, String phoneNo, Adress adress) {
		setPerson(person);
		setPhoneNo(phoneNo);
		setAdress(adress);
	}
	
	public void customerCodeCreation(){
	       this.customerCode = this.getIdC2() + "_person_" + this.person.getPersonCode();
	   }
}
