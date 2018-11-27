package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
//import java.sql.Date;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: conge
 *
 */
@Entity

public class Conge implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id_co;
	private Date date_co;
	private String type_co;
	private String certificat;
	private int nbjrs_co;
	private String status_co;
	private int cin;
	public Conge(String type_co, String certificat, int nbjrs_co, String status_co, int cin) {
		super();
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.cin = cin;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}

	public Conge(Date date_co, String type_co, String certificat, int nbjrs_co, String status_co, int cin) {
		super();
		this.date_co = date_co;
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.cin = cin;
	}
	public Conge(int id_co, Date date_co, String type_co, String certificat, int nbjrs_co, String status_co, int cin) {
		super();
		this.id_co = id_co;
		this.date_co = date_co;
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.cin = cin;
	}

	@OneToOne
	private User user;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Conge(int id_co, Date date_co, String type_co, String certificat, int nbjrs_co, String status_co, User user) {
		super();
		this.id_co = id_co;
		this.date_co = date_co;
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	public Conge() {
		super();
	}   
	public int getId_co() {
		return this.id_co;
	}

	public void setId_co(int id_co) {
		this.id_co = id_co;
	}   
	public Date getDate_co() {
		return this.date_co;
	}
	
	
	public void setDate_co(Date date_co) {
		this.date_co = date_co;
	}   
	public Conge(String type_co, String certificat, int nbjrs_co, String status_co) {
		super();
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
	}
	public String getType_co() {
		return this.type_co;
	}

	public void setType_co(String type_co) {
		this.type_co = type_co;
	}   
	
	
	
	public String getCertificat() {
		return certificat;
	}
	public void setCertificat(String certificat) {
		this.certificat = certificat;
	}
	public int getNbjrs_co() {
		return this.nbjrs_co;
	}

	public void setNbjrs_co(int nbjrs_co) {
		this.nbjrs_co = nbjrs_co;
	}   
	public String getStatus_co() {
		return this.status_co;
	}

	public void setStatus_co(String status_co) {
		this.status_co = status_co;
	}
   
}
