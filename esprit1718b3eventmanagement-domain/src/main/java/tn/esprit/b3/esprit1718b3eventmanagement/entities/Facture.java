package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Facture
 *
 */
@Entity

public class Facture implements Serializable {

	   
	@Id
	private int ref_facture;
	private Date date_facture;
	private String seller_facture;
	private String buyer_facture;
	private float total_facture;
	
	@OneToMany(mappedBy="facture")
	private List<Financement> financement;

	@ManyToOne
	private Gain gain;
	@ManyToOne
	private Spending spending;
	
	private static final long serialVersionUID = 1L;
	
	public Facture(int ref_facture, Date date_facture, String seller_facture, String buyer_facture, float total_facture,
			List<Financement> financement, Gain gain, Spending spending) {
		super();
		this.ref_facture = ref_facture;
		this.date_facture = date_facture;
		this.seller_facture = seller_facture;
		this.buyer_facture = buyer_facture;
		this.total_facture = total_facture;
		this.financement = financement;
		this.gain = gain;
		this.spending = spending;
	}
	
	public List<Financement> getFinancement() {
		return financement;
	}
	public void setFinancement(List<Financement> financement) {
		this.financement = financement;
	}
	public Gain getGain() {
		return gain;
	}
	
	public void setGain(Gain gain) {
		this.gain = gain;
	}
	
	public Spending getSpending() {
		return spending;
	}
	public void setSpending(Spending spending) {
		this.spending = spending;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

	public Facture() {
		super();
	}   
	public int getRef_facture() {
		return this.ref_facture;
	}

	public void setRef_facture(int ref_facture) {
		this.ref_facture = ref_facture;
	}   
	public Date getDate_facture() {
		return this.date_facture;
	}

	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}   
	public String getSeller_facture() {
		return this.seller_facture;
	}

	public void setSeller_facture(String seller_facture) {
		this.seller_facture = seller_facture;
	}   
	public String getBuyer_facture() {
		return this.buyer_facture;
	}

	public void setBuyer_facture(String buyer_facture) {
		this.buyer_facture = buyer_facture;
	}   
	public float getTotal_facture() {
		return this.total_facture;
	}

	public void setTotal_facture(float total_facture) {
		this.total_facture = total_facture;
	}
   
}
