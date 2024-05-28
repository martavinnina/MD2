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
public class CustomerAsPerson extends Person{


		@Column(name = "CustomerCode")
		//@NotNull
		private String customerCode; 
		
		
		/*@Column(name = "PersonCode")
		@NotNull
		@Pattern(regexp = "[0-9]{1}[0-9]{8}")
		private String personCode;
		*/
		
		/*
		@OneToOne
		@JoinColumn(name = "PersonCode")
		private Person person;
		*/
		
		//IdP paradisies saja tabula(CostumerAsPerson)
		/*@OneToOne
		@JoinColumn(name = "IdP")
		private Person person;
		*/
		
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
		
		
		public CustomerAsPerson(String name, String surname, String personCode, String phoneNo, Adress adress) {
			super(name, surname, personCode);
			setPhoneNo(phoneNo);
			setAdress(adress);
		}
		
		 public void customerCodeCreation(){
		        this.customerCode = super.getIdP() + "_person_" + this.getPersonCode();
		    }
}
