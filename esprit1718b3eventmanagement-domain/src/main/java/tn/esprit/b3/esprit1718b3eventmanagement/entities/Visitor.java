package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Visitor extends User implements Serializable {

	public Visitor() {
		super();
	}

	public Visitor(int cin, String first_name, String last_name, int phone_number, String address) {
		super(cin, first_name, last_name, phone_number, address);
	}

	public Visitor(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Conge conge, Fair fair) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, conge, fair);
	}

	public Visitor(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, modified_date,
				state_account);
	}

	public Visitor(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, state_account);
	}

	public Visitor(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
	}

	public Visitor(int cin, String login, String password, String email) {
		super(cin, login, password, email);
	}

	public Visitor(String login, String password) {
		super(login, password);
	}

	
	
}
