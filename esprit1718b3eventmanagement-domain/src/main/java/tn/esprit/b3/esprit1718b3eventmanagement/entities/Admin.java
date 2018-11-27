package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity

public class Admin extends User implements Serializable{
	
	private String surnom ;

	public Admin() {
		super();
	}
	
	
	public Admin(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, state_account);
	}


	public Admin(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, modified_date,
				state_account);
	}


	public Admin(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
	}

	public Admin(int cin, String login, String password, String email) {
		super(cin, login, password, email);
	}

	public Admin(String surnom) {
		super();
		this.surnom = surnom;
	}
}
