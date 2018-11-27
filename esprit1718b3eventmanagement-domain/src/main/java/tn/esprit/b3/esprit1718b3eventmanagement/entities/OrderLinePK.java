package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: OrderLinePK
 *
 */

@Embeddable

public class OrderLinePK implements Serializable {

	
	
	private int id_order_PK;
	private int id_product_PK;
	private static final long serialVersionUID = 1L;

	public OrderLinePK() {
		super();
	}

	public int getId_order_PK() {
		return id_order_PK;
	}

	public void setId_order_PK(int id_order_PK) {
		this.id_order_PK = id_order_PK;
	}

	public int getId_product_PK() {
		return id_product_PK;
	}

	public void setId_product_PK(int id_product_PK) {
		this.id_product_PK = id_product_PK;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_order_PK;
		result = prime * result + id_product_PK;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLinePK other = (OrderLinePK) obj;
		if (id_order_PK != other.id_order_PK)
			return false;
		if (id_product_PK != other.id_product_PK)
			return false;
		return true;
	}   
	
	
	
   
}
