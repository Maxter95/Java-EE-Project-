package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;


/**
 * Entity implementation class for Entity: Staff
 *
 */
@Entity

public class Staff extends User implements Serializable {

	public Staff(int disponibilite, int nbjrscp, int yearswork, float salary_staff, List<Spending> spending) {
		super();
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.spending = spending;
	}
	private int disponibilite;
	private int nbjrscp;
	private int yearswork;
	private float salary_staff;
	private int increase;
	
	
	public Staff(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, state_account);
	}
	public Staff(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, modified_date,
				state_account);
	}
	public Staff(int disponibilite, int nbjrscp, int yearswork, float salary_staff, int increase) {
		super();
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.increase = increase;
	}
	public int getIncrease() {
		return increase;
	}
	public void setIncrease(int increase) {
		this.increase = increase;
	}
	@OneToMany(mappedBy="staff")
	private List<Spending> spending;
	
	public Staff() {
		super();
	}	
	public Staff(int cin, String first_name, String last_name, int phone_number, String address) {
		super(cin, first_name, last_name, phone_number, address);
		// TODO Auto-generated constructor stub
	}
	public Staff(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Conge conge, Fair fair) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, conge, fair);
		// TODO Auto-generated constructor stub
	}
	public Staff(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
		// TODO Auto-generated constructor stub
	}
	public Staff(int cin, String login, String password, String email) {
		super(cin, login, password, email);
		// TODO Auto-generated constructor stub
	}
	public Staff(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
	public Staff(int disponibilite, int nbjrscp, int yearswork, float salary_staff) {
		super();
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		
	}
	
	public Staff(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, int disponibilite, int nbjrscp, int yearswork, float salary_staff) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
	}
	
	

	public Staff(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, int disponibilite, int nbjrscp, int yearswork, float salary_staff,
			int increase) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.increase = increase;
		
	}
	public Staff(int cin, String login, String password, String email, int disponibilite, int nbjrscp, int yearswork,
			float salary_staff, int increase) {
		super(cin, login, password, email);
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.increase = increase;
		
	}
	public List<Spending> getSpending() {
		return spending;
	}
	public void setSpending(List<Spending> spending) {
		this.spending = spending;
	}
	public int getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}
	public int getNbjrscp() {
		return nbjrscp;
	}
	public void setNbjrscp(int nbjrscp) {
		this.nbjrscp = nbjrscp;
	}
	public int getYearswork() {
		return yearswork;
	}
	public void setYearswork(int yearswork) {
		this.yearswork = yearswork;
	}
	public float getSalary_staff() {
		return salary_staff;
	}
	public void setSalary_staff(float salary_staff) {
		this.salary_staff = salary_staff;
	}
   
}
