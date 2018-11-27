package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Gain
 *
 */
@Entity

public class Gain implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_gain;
	private String type_gain;
	private Date date_gain;
	@OneToMany(mappedBy="gain")
	private List<Facture> facture;
	@ManyToOne
	private Ticket ticket;
	@ManyToOne
	private Publicity publicity;
	private static final long serialVersionUID = 1L;

	public Gain() {
		super();
	}   
	
	public Gain(int id_gain, String type_gain, Date date_gain, List<Facture> facture, Ticket ticket,
			Publicity publicity) {
		super();
		this.id_gain = id_gain;
		this.type_gain = type_gain;
		this.date_gain = date_gain;
		this.facture = facture;
		this.ticket = ticket;
		this.publicity = publicity;
	}
	
	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public Publicity getPublicity() {
		return publicity;
	}

	public void setPublicity(Publicity publicity) {
		this.publicity = publicity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_gain() {
		return this.id_gain;
	}

	public void setId_gain(int id_gain) {
		this.id_gain = id_gain;
	}   
	public String getType_gain() {
		return this.type_gain;
	}

	public void setType_gain(String type_gain) {
		this.type_gain = type_gain;
	}   
	public Date getDate_gain() {
		return this.date_gain;
	}

	public void setDate_gain(Date date_gain) {
		this.date_gain = date_gain;
	}
   
}
