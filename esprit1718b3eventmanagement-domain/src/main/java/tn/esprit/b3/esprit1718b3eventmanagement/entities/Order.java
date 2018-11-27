package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name="t_order")
public class Order implements Serializable {

	   
	@Id
	@GeneratedValue	
	private int id_order;
	private Date date_order;
	private String state_order;



	@ManyToOne
	private Client client;

	@ManyToOne
	private Payment payment;
	
	@OneToMany(mappedBy="orderP")
	private List<OrderLine> lorderLine;
	
	private static final long serialVersionUID = 1L;

	public Order() {
		super();
	}   


	public Order(int id_order, Date date_order, String state_order, Client client, Payment payment) {
		super();
		this.id_order = id_order;
		this.date_order = date_order;
		this.state_order = state_order;
		this.client = client;
		this.payment = payment;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
  
	public int getId_o() {
		return id_order;
	}


	public void setId_o(int id_o) {
		this.id_order = id_o;
	}


	public Date getDate_order() {
		return this.date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}   
	public String getState_order() {
		return this.state_order;
	}

	public void setState_order(String state_order) {
		this.state_order = state_order;
	}
	
	public List<OrderLine> getLorderLine() {
		return lorderLine;
	}
	public void setLorderLine(List<OrderLine> lorderLine) {
		this.lorderLine = lorderLine;
	}
		
   
}
