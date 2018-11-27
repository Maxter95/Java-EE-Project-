package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends User implements Serializable {

	   
	
	private String first_name_client;
	private String last_name_client;
	private String email_client;
	private int phone_number_client;
	private String username_client;
	private String password_client;
	private Date creation_date_client;

	@OneToMany(mappedBy="client")
	private List<Order> order;
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}   
	
	public Client(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, state_account);
	}

	
	public Client(int cin, String first_name, String last_name, int phone_number, String address) {
		super(cin, first_name, last_name, phone_number, address);
	}

	public Client(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
	}

	public Client(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, modified_date,
				state_account);
	}

	public String getFirst_name_client() {
		return this.first_name_client;
	}

	public void setFirst_name_client(String first_name_client) {
		this.first_name_client = first_name_client;
	}   
	public String getLast_name_client() {
		return this.last_name_client;
	}

	public void setLast_name_client(String last_name_client) {
		this.last_name_client = last_name_client;
	}   
	public String getEmail_client() {
		return this.email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}   
	public int getPhone_number_client() {
		return this.phone_number_client;
	}

	public void setPhone_number_client(int phone_number_client) {
		this.phone_number_client = phone_number_client;
	}   
	public String getUsername_client() {
		return this.username_client;
	}

	public void setUsername_client(String username_client) {
		this.username_client = username_client;
	}   
	public String getPassword_client() {
		return this.password_client;
	}

	public void setPassword_client(String password_client) {
		this.password_client = password_client;
	}   
	public Date getCreation_date_client() {
		return this.creation_date_client;
	}

	public void setCreation_date_client(Date creation_date_client) {
		this.creation_date_client = creation_date_client;
	}
	
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}