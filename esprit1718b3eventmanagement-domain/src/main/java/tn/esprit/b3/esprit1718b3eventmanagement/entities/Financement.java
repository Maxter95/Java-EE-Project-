package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Financement
 *
 */
@Entity

public class Financement implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_financement;
	private String type_financement;
	private String description_financement;
	
	@OneToMany(mappedBy="financement")
	private List<Fair> fair;
	@ManyToOne
	private Facture facture;
	private static final long serialVersionUID = 1L;

	public Financement() {
		super();
	}   
	public int getId_financement() {
		return this.id_financement;
	}

	public void setId_financement(int id_financement) {
		this.id_financement = id_financement;
	}   
	public String getType_financement() {
		return this.type_financement;
	}

	public Financement(int id_financement, String type_financement, String description_financement, List<Fair> fair,
			Facture facture) {
		super();
		this.id_financement = id_financement;
		this.type_financement = type_financement;
		this.description_financement = description_financement;
		this.fair = fair;
		this.facture = facture;
	}

	public List<Fair> getFair() {
		return fair;
	}
	public void setFair(List<Fair> fair) {
		this.fair = fair;
	}
	
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setType_financement(String type_financement) {
		this.type_financement = type_financement;
	}   
	public String getDescription_financement() {
		return this.description_financement;
	}

	public void setDescription_financement(String description_financement) {
		this.description_financement = description_financement;
	}
   
}
