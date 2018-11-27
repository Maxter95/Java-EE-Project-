package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity

public class Payment implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_payment;
	private int card_number;
	private Date date_payment;
	private int card_code;
	private String card_type;

	@OneToMany(mappedBy="payment")
	private List<Order> order;
	private static final long serialVersionUID = 1L;

	public Payment(int id_payment, int card_number, Date date_payment, int card_code, String card_type,
			List<Order> order) {
		super();
		this.id_payment = id_payment;
		this.card_number = card_number;
		this.date_payment = date_payment;
		this.card_code = card_code;
		this.card_type = card_type;
		this.order = order;
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
	public Payment() {
		super();
	}   
	public int getId_payment() {
		return this.id_payment;
	}

	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}   
	public int getCard_number() {
		return this.card_number;
	}

	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}   
	public Date getDate_payment() {
		return this.date_payment;
	}

	public void setDate_payment(Date date_payment) {
		this.date_payment = date_payment;
	}   
	public int getCard_code() {
		return this.card_code;
	}

	public void setCard_code(int card_code) {
		this.card_code = card_code;
	}   
	public String getCard_type() {
		return this.card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
   
}
