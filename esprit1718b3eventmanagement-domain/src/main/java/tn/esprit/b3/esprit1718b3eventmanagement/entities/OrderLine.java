package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderLine
 *
 */
@Entity

public class OrderLine implements Serializable {
	@EmbeddedId 
	private OrderLinePK orderLinePK ;
	private float amount;
	@ManyToOne 
	@JoinColumn(name="id_order_PK",referencedColumnName="id_order",insertable=false,updatable=false)
	private Order orderP;
	@ManyToOne 
	@JoinColumn(name="id_product_PK",referencedColumnName="id_product",insertable=false,updatable=false)
	private Product productP;
	
	
	private static final long serialVersionUID = 1L;

	public OrderLine() {
		super();
	}   
	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public OrderLinePK getOrderLinePK() {
		return orderLinePK;
	}
	public void setOrderLinePK(OrderLinePK orderLinePK) {
		this.orderLinePK = orderLinePK;
	}
		public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		public Order getOrderP() {
			return orderP;
		}
		public void setOrderP(Order orderP) {
			this.orderP = orderP;
		}
	
		public Product getProductP() {
			return productP;
		}
		public void setProductP(Product productP) {
			this.productP = productP;
		}
		public OrderLine(OrderLinePK orderLinePK, float amount, Order orderP, Product productP) {
			super();
			this.orderLinePK = orderLinePK;
			this.amount = amount;
			this.orderP = orderP;
			this.productP = productP;
		}
	
	
   
}
