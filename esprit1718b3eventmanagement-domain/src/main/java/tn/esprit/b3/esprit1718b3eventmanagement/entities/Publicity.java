package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Publicity
 *
 */
@Entity

public class Publicity implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_publicity;
	private float price_publicity;
	private Blob image_publicity;
	private String description_publicity;
	@OneToMany(mappedBy="publicity")
	private List<Gain> gain;
	private static final long serialVersionUID = 1L;

	public Publicity() {
		super();
	}   
	
	public Publicity(int id_publicity, float price_publicity, Blob image_publicity, String description_publicity,
			List<Gain> gain) {
		super();
		this.id_publicity = id_publicity;
		this.price_publicity = price_publicity;
		this.image_publicity = image_publicity;
		this.description_publicity = description_publicity;
		this.gain = gain;
	}

	public List<Gain> getGain() {
		return gain;
	}

	public void setGain(List<Gain> gain) {
		this.gain = gain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_publicity() {
		return this.id_publicity;
	}

	public void setId_publicity(int id_publicity) {
		this.id_publicity = id_publicity;
	}   
	public float getPrice_publicity() {
		return this.price_publicity;
	}

	public void setPrice_publicity(float price_publicity) {
		this.price_publicity = price_publicity;
	}   
	public Blob getImage_publicity() {
		return this.image_publicity;
	}

	public void setImage_publicity(Blob image_publicity) {
		this.image_publicity = image_publicity;
	}   
	public String getDescription_publicity() {
		return this.description_publicity;
	}

	public void setDescription_publicity(String description_publicity) {
		this.description_publicity = description_publicity;
	}
   
}
