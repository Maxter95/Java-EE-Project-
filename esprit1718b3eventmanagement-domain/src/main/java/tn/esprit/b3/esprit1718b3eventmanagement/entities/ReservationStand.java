package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationStand
 *
 */
@Entity

public class ReservationStand implements Serializable {

	   
	@Id
	private int standNumber;
	private int customerNumber;
	private Date day;
	private int startHour;
	private int endHour;
	private int standSize;
	@ManyToOne
	private CompanyDirector companydirector;
	@ManyToOne
	private Stand stand;
	private static final long serialVersionUID = 1L;


	
	
	public ReservationStand(int customerNumber, Date day, int startHour, int endHour, int standSize) {
		super();
		this.customerNumber = customerNumber;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
		this.standSize = standSize;
	}

	public ReservationStand(int standNumber, int customerNumber, Date day, int startHour, int endHour, int standSize,
			User user, Stand stand) {
		super();
		this.standNumber = standNumber;
		this.customerNumber = customerNumber;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
		this.standSize = standSize;
		this.companydirector = (CompanyDirector) user;
		this.stand = stand;
	}
	public ReservationStand(int standNumber, int customerNumber, Date day, int startHour, int endHour, int standSize) {
		super();
		this.standNumber = standNumber;
		this.customerNumber = customerNumber;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
		this.standSize = standSize;
	}

	public ReservationStand() {
		super();
	}   
	
	public int getStandNumber() {
		return this.standNumber;
	}

	public void setStandNumber(int standNumber) {
		this.standNumber = standNumber;
	}   
	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}   
	public Date getDay() {
		return this.day;
	}

	public void setDay(Date d) {
		this.day = d;
	}   
	public int getStartHour() {
		return this.startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}   
	public int getEndHour() {
		return this.endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}   
	public int getStandSize() {
		return this.standSize;
	}

	public void setStandSize(int standSize) {
		this.standSize = standSize;
	}   
	  
	public Stand getStand() {
		return this.stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}
	
	public CompanyDirector getCompanydirector() {
		return companydirector;
	}

	public void setCompanydirector(CompanyDirector companydirector) {
		this.companydirector = companydirector;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*public int compareTo(ReservationStand o) {
        if(day.isBefore(o.day))
            return -1;
        if(day.isAfter(o.day))
            return 1;
        if(endHour <= o.startHour)
            return -1;
        else if(startHour >= o.endHour)
            return 1;
        return 0;
    }*/ 
   
}
