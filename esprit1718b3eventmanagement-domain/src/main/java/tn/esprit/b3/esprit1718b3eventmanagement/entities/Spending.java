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
 * Entity implementation class for Entity: Spending
 *
 */
@Entity

public class Spending implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_spending;
	private String type_spending;
	private Date date_spending;
	@OneToMany(mappedBy="spending")
	private List<Facture> facture;
	@ManyToOne
	private Staff staff;
	private static final long serialVersionUID = 1L;

	public Spending(int id_spending, String type_spending, Date date_spending, List<Facture> facture, Staff staff) {
		super();
		this.id_spending = id_spending;
		this.type_spending = type_spending;
		this.date_spending = date_spending;
		this.facture = facture;
		this.staff = staff;
	}
	
	public List<Facture> getFacture() {
		return facture;
	}
	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Spending() {
		super();
	}   
	public int getId_spending() {
		return this.id_spending;
	}

	public void setId_spending(int id_spending) {
		this.id_spending = id_spending;
	}   
	public String getType_spending() {
		return this.type_spending;
	}

	public void setType_spending(String type_spending) {
		this.type_spending = type_spending;
	}   
	public Date getDate_spending() {
		return this.date_spending;
	}

	public void setDate_spending(Date date_spending) {
		this.date_spending = date_spending;
	}
   
}
