package lv.venta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@Table(name="PersonTable")
@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //visas klases, kas manto so bus IdP no sis klases

public class Person {
	
	/*@Column(name = "IdP") 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idP;
	*/
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String name;
	
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 2, max = 40)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String surname;
	
	@Column(name = "PersonCode")
	@NotNull
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}")
	private String personCode;
	
	/*@OneToOne(mappedBy = "person")
	@ToString.Exclude
	private CustomerAsPerson customerAsPerson;
	*/
	
	/*@OneToOne(mappedBy = "customerAsPerson")
	@ToString.Exclude //lai nav bezgaliga izsauksana starp prof un course
	private CustomerAsPerson customerAsPerson;
	*/
	
	
	public Person(String name, String surname, String personCode) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
	}
}
