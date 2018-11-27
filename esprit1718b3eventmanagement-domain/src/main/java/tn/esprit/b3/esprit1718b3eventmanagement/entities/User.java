package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.OneToOne;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javax.persistence.*;

@Entity
@Table(name = "tab_user")
public class User extends RecursiveTreeObject<User> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USR_CIN")
	private int cin;
	@Column(name = "USR_FIRST_NAME")
	private String first_name;
	@Column(name = "USR_LOGIN")
	private String login;
	@Column(name = "USR_PWD")
	private String password;
	@Column(name = "USR_EMAIL")
	private String email;
	@Column(name = "USR_LAST_NAME")
	private String last_name;
	@Column(name = "USR_PHONE_NUMBER")
	private int phone_number;
	@Column(name = "USR_ADDRESS")
	private String address;
	@Column(name = "CREAT_DATE")
	private Date account_date;
	@Column(name = "MODIF_DATE")
	private Date modified_date;
	@Column(name = "STATE_ACOUNT")
	private String state_account;

	@OneToOne(mappedBy = "user")
	private Conge conge;
	@ManyToOne
	private Fair fair;

	public User() {
		super();
	}

	public User(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super();
		this.cin = cin;
		this.first_name = first_name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.address = address;
		this.account_date = account_date;
		this.state_account = state_account;
	}

	public User(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super();
		this.cin = cin;
		this.first_name = first_name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.address = address;
		this.account_date = account_date;
		this.modified_date = modified_date;
		this.state_account = state_account;
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User(int cin, String login, String password, String email) {
		super();
		this.cin = cin;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public User(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super();
		this.cin = cin;
		this.first_name = first_name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.address = address;
	}

	public User(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Conge conge, Fair fair) {
		super();
		this.cin = cin;
		this.first_name = first_name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.address = address;
		this.conge = conge;
		this.fair = fair;
	}

	public User(int cin, String first_name, String last_name, int phone_number, String address) {
		super();
		this.cin = cin;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.address = address;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Conge getConge() {
		return conge;
	}

	public void setConge(Conge conge) {
		this.conge = conge;
	}

	public Fair getFair() {
		return fair;
	}

	public void setFair(Fair fair) {
		this.fair = fair;
	}

	public Date getAccount_date() {
		return account_date;
	}

	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getState_account() {
		return state_account;
	}

	public void setState_account(String state_account) {
		this.state_account = state_account;
	}

}
