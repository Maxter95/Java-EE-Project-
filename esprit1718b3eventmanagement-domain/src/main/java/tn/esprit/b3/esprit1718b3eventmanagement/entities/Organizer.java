package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity

public class Organizer extends User implements Serializable{
	
	private String name_company;

	public Organizer() {
		super();
	}
	
	public Organizer(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, state_account);
	}

	public Organizer(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, modified_date,
				state_account);
	}

	public Organizer(String login, String password) {
		super(login, password);
	}
	public Organizer(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, String name_company) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
		this.name_company = name_company;
	}
	public Organizer(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
	}
	public Organizer(int cin, String login, String password, String email) {
		super(cin, login, password, email);
	}
	
	public Organizer(int cin, String login, String password, String email, String name_company) {
		super(cin, login, password, email);
		this.name_company = name_company;
	}
	
	public Organizer(int cin, String first_name, String last_name, int phone_number, String address) {
		super(cin, first_name, last_name, phone_number, address);
	}
	public String getName_company() {
		return name_company;
	}

	public void setName_company(String name_company) {
		this.name_company = name_company;
	}
}
