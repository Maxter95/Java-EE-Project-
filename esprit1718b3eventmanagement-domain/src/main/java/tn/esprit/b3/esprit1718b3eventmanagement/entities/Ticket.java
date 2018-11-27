package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import java.lang.String;
import java.sql.Blob;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {

	   
	@Id
	private int ref_ticket;
	private float price_ticket;
	private Blob image_ticket;
	private String description_ticket;
	@OneToMany(mappedBy="ticket")
	private List<Gain> gain;
	
	private static final long serialVersionUID = 1L;

	public Ticket() {
		super();
	}   
	public int getRef_ticket() {
		return this.ref_ticket;
	}

	public void setRef_ticket(int ref_ticket) {
		this.ref_ticket = ref_ticket;
	}   
	public float getPrice_ticket() {
		return this.price_ticket;
	}

	public void setPrice_ticket(float price_ticket) {
		this.price_ticket = price_ticket;
	}   
	public Blob getImage_ticket() {
		return this.image_ticket;
	}

	public void setImage_ticket(Blob image_ticket) {
		this.image_ticket = image_ticket;
	}   
	public String getDescription_ticket() {
		return this.description_ticket;
	}

	public void setDescription_ticket(String description_ticket) {
		this.description_ticket = description_ticket;
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
   
}
