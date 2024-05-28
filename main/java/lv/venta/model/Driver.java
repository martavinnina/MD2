package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name="DriverTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString


public class Driver extends Person {

	
	@Column(name = "LicenseNo")
	@NotNull
	@Pattern(regexp ="[A-ZĀČĒĢĶĻŅŠŪŽ]{2}[0-9]{6}+")
	private String LicenseNo;
	
	@Min(0)
	@Max(60)
	@Column(name = "ExperienceInYears")
	private float ExperienceInYears;
	
	
	//Parcel tabulā parādīsies driver Id
	@OneToMany(mappedBy = "driver") //vienam šoferim vairakas pacinas
	@ToString.Exclude //kad ieklauj otras klases objektu, lai nav cirkulara saite
	private Collection<Parcel> parcels; 
	

	public Driver(String name, String surname, String personCode,
			String LicenseNo, float ExperienceInYears) {
	super(name, surname, personCode);
	setLicenseNo(LicenseNo);
	setExperienceInYears(ExperienceInYears);
	}
	
}
