package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;

/**
 * Entity implementation class for Entity: CompanyDirector
 *
 */
@Entity

public class CompanyDirector extends User implements Serializable {

	
	private String position;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="stand")
	private List<StandEquipment> stand_equipment;
	public CompanyDirector() {
		super();
	} 
	
	public CompanyDirector(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, state_account);
	}

	public CompanyDirector(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, Date account_date, Date modified_date, String state_account) {
		super(cin, first_name, login, password, email, last_name, phone_number, address, account_date, modified_date,
				state_account);
	}

	public CompanyDirector(String position) {
		super();
		this.position = position;
	}

	public CompanyDirector(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address, String position) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
		this.position = position;
	}
	
	

	public CompanyDirector(int cin, String first_name, String last_name, int phone_number, String address) {
		super(cin, first_name, last_name, phone_number, address);
	}

	public CompanyDirector(int cin, String first_name, String login, String password, String email, String last_name,
			int phone_number, String address) {
		super(cin, first_name, login, password, email, last_name, phone_number, address);
	}

	public CompanyDirector(int cin, String login, String password, String email) {
		super(cin, login, password, email);
	}

	public CompanyDirector(int cin, String login, String password, String email, String position) {
		super(cin, login, password, email);
		this.position = position;
	}
	
	
	
	

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
   
}
