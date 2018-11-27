package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Localisation
 *
 */
@Entity

public class Localisation implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_localisation;
	private String address_localisation;
	private String name_localisation;
	private String city_localisation;
	
	@OneToMany(mappedBy="localisation")
	private List<Fair> fair;
	private static final long serialVersionUID = 1L;

	public Localisation() {
		super();
	}   
	





	public Localisation(int id_localisation, String address_localisation, String name_localisation,
			String city_localisation, List<Fair> fair) {
		super();
		this.id_localisation = id_localisation;
		this.address_localisation = address_localisation;
		this.name_localisation = name_localisation;
		this.city_localisation = city_localisation;
		this.fair = fair;
	}













	
	public List<Fair> getFair() {
		return fair;
	}






	public void setFair(List<Fair> fair) {
		this.fair = fair;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_localisation() {
		return this.id_localisation;
	}

	public void setId_localisation(int id_localisation) {
		this.id_localisation = id_localisation;
	}   
	public String getAddress_localisation() {
		return this.address_localisation;
	}

	public void setAddress_localisation(String address_localisation) {
		this.address_localisation = address_localisation;
	}   
	public String getName_localisation() {
		return this.name_localisation;
	}

	public void setName_localisation(String name_localisation) {
		this.name_localisation = name_localisation;
	}   
	public String getCity_localisation() {
		return this.city_localisation;
	}

	public void setCity_localisation(String city_localisation) {
		this.city_localisation = city_localisation;
	}
   
}
