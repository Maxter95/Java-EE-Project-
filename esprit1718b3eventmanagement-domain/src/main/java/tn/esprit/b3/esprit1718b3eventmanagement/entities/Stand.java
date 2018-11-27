package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Stand
 *
 */
@Entity

public class Stand implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_stand;
	private String type_stand;
	private float price_stand;
	private String description_stand;
	@OneToMany(mappedBy="standP")
	private List<StandLine> lStandLine;
	
	@OneToMany(mappedBy="stand")
	private List<StandEquipment> stand_equipment;
	@OneToMany(mappedBy="stand")
	private List<Company> company;
	@OneToMany(mappedBy="stand")
	private List<ReservationStand> reservationstand;
	
	
	
	private static final long serialVersionUID = 1L;

	public Stand() {
		super();
	}   
	
	public List<StandLine> getlStandLine() {
		return lStandLine;
	}

	public void setlStandLine(List<StandLine> lStandLine) {
		this.lStandLine = lStandLine;
	}
	
	public List<StandEquipment> getStand_equipment() {
		return stand_equipment;
	}

	public void setStand_equipment(List<StandEquipment> stand_equipment) {
		this.stand_equipment = stand_equipment;
	}
	
	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
	public Stand(int id_s, String type_stand, float price_stand, String description_stand, List<StandLine> lStandLine,
			List<StandEquipment> stand_equipment, List<Company> company) {
		super();
		this.id_stand = id_s;
		this.type_stand = type_stand;
		this.price_stand = price_stand;
		this.description_stand = description_stand;
		this.lStandLine = lStandLine;
		this.stand_equipment = stand_equipment;
		this.company = company;
	}
	public Stand( String type_stand, float price_stand, String description_stand) {
		super();
		
		this.type_stand = type_stand;
		this.price_stand = price_stand;
		this.description_stand = description_stand;
	
	}
	public int getId_s() {
		return id_stand;
	}
	public void setId_s(int id_s) {
		this.id_stand = id_s;
	}
	public String getType_stand() {
		return this.type_stand;
	}

	public void setType_stand(String type_stand) {
		this.type_stand = type_stand;
	}   
	public float getPrice_stand() {
		return this.price_stand;
	}

	public void setPrice_stand(float price_stand) {
		this.price_stand = price_stand;
	}   
	public String getDescription_stand() {
		return this.description_stand;
	}

	public void setDescription_stand(String description_stand) {
		this.description_stand = description_stand;
	}
 
	
}
