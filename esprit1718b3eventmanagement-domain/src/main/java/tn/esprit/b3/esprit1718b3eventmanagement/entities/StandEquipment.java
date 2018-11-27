package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import java.lang.String;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: StandEquipment
 *
 */
@Entity

public class StandEquipment implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_equipment;
	private String type_equipment;
	private float price_equipment;
	private String description_equipment;
	@ManyToOne
	private Stand stand;
	private static final long serialVersionUID = 1L;

	public StandEquipment() {
		super();
	}   
	public int getId_equipment() {
		return this.id_equipment;
	}

	public void setId_equipment(int id_equipment) {
		this.id_equipment = id_equipment;
	}   
	public String getType_equipment() {
		return this.type_equipment;
	}

	public void setType_equipment(String type_equipment) {
		this.type_equipment = type_equipment;
	}   
	public float getPrice_equipment() {
		return this.price_equipment;
	}

	public void setPrice_equipment(float price_equipment) {
		this.price_equipment = price_equipment;
	}   
	public String getDescription_equipment() {
		return this.description_equipment;
	}

	public void setDescription_equipment(String description_equipment) {
		this.description_equipment = description_equipment;
	}
	
	public Stand getStand() {
		return stand;
	}
	public void setStand(Stand stand) {
		this.stand = stand;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
