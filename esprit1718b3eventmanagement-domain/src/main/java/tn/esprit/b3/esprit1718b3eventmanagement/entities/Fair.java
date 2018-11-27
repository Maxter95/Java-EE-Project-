package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.lang.String;
import java.util.List;





/**
 * Entity implementation class for Entity: Fair
 *
 */
@Entity

public class Fair implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_fair;
	private String event_type;
	private int stand_number;
	private float fair_price;
	private String fair_name;
	private String address;
	private float area;
	@OneToMany(mappedBy="fairP")
	private List<StandLine> lStandline;
	
	@OneToMany(mappedBy="fair2P")
	private List<PosterLine> lPosterline;
	
	@OneToMany(mappedBy="fair")
	private List<User> user;
	@ManyToOne
	private FairCalendar calendar;
	
	@ManyToOne
	private Financement financement;
	@ManyToOne
	private Localisation localisation;
	
	
	
	public Fair(int id_fair, String event_type, int stand_number, float fair_price, String fair_name, String address,
			float area, List<User> user, Localisation localisation, FairCalendar calendar, Financement financement) {
		super();
		this.id_fair = id_fair;
		this.event_type = event_type;
		this.stand_number = stand_number;
		this.fair_price = fair_price;
		this.fair_name = fair_name;
		this.address = address;
		this.area = area;
		this.user = user;
		this.localisation = localisation;
		this.calendar = calendar;
		this.financement = financement;
	}	
	public List<StandLine> getlStandline() {
		return lStandline;
	}
	public void setlStandline(List<StandLine> lStandline) {
		this.lStandline = lStandline;
	}
	public List<PosterLine> getlPosterline() {
		return lPosterline;
	}
	public void setlPosterline(List<PosterLine> lPosterline) {
		this.lPosterline = lPosterline;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	public FairCalendar getCalendar() {
		return calendar;
	}
	public void setCalendar(FairCalendar calendar) {
		this.calendar = calendar;
	}
	public Financement getFinancement() {
		return financement;
	}
	public void setFinancement(Financement financement) {
		this.financement = financement;
	}
	public Fair() {
		super();
	} 
	
	public Financement getFin() {
		return financement;
	}
	public void setFin(Financement fin) {
		this.financement = fin;
	}
	public List<User> getU() {
		return user;
	}

	public void setU(List<User> u) {
		this.user = u;
	}

	public int getId_f() {
		return id_fair;
	}

	public void setId_f(int id_f) {
		this.id_fair = id_f;
	}

	public String getEvent_type() {
		return this.event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}   
	public int getStand_number() {
		return this.stand_number;
	}

	public void setStand_number(int stand_number) {
		this.stand_number = stand_number;
	}   
	public float getFair_price() {
		return this.fair_price;
	}

	public void setFair_price(float fair_price) {
		this.fair_price = fair_price;
	}   
	public String getFair_name() {
		return this.fair_name;
	}

	public void setFair_name(String fair_name) {
		this.fair_name = fair_name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public float getArea() {
		return this.area;
	}

	public void setArea(float area) {
		this.area = area;
	}
	public Fair(String event_type, int stand_number, float fair_price, String fair_name, String address, float area) {
		super();
		this.event_type = event_type;
		this.stand_number = stand_number;
		this.fair_price = fair_price;
		this.fair_name = fair_name;
		this.address = address;
		this.area = area;
	}
	
   
}
