package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: FairCalendar
 *
 */
@Entity

public class FairCalendar implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_date;
	private Date begin_date;
	private Date finish_date;
	@OneToMany(mappedBy="calendar")
	private List<Fair> fair;
	private static final long serialVersionUID = 1L;

	public FairCalendar() {
		super();
	}   
	
	public List<Fair> getF() {
		return fair;
	}

	public void setF(List<Fair> f) {
		this.fair = f;
	}

	public FairCalendar(int id_date, Date begin_date, Date finish_date, List<Fair> fair) {
		super();
		this.id_date = id_date;
		this.begin_date = begin_date;
		this.finish_date = finish_date;
		this.fair = fair;
	}

	public List<Fair> getFair() {
		return fair;
	}

	public void setFair(List<Fair> fair) {
		this.fair = fair;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_date() {
		return this.id_date;
	}

	public void setId_date(int id_date) {
		this.id_date = id_date;
	}   
	public Date getBegin_date() {
		return this.begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}   
	public Date getFinish_date() {
		return this.finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
   
}
