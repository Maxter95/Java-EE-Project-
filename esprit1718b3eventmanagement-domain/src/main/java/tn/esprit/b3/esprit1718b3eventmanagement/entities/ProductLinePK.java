package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: ProductLinePK
 *
 */

@Embeddable

public class ProductLinePK implements Serializable {

	private int id_product_PK;

	private int id_company_PK;
	private static final long serialVersionUID = 1L;

	public ProductLinePK() {
		super();
	}

	public int getId_product_PK() {
		return id_product_PK;
	}

	public void setId_product_PK(int id_product_PK) {
		this.id_product_PK = id_product_PK;
	}

	public int getId_company_PK() {
		return id_company_PK;
	}

	public void setId_company_PK(int id_company_PK) {
		this.id_company_PK = id_company_PK;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_company_PK;
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
		ProductLinePK other = (ProductLinePK) obj;
		if (id_company_PK != other.id_company_PK)
			return false;
		if (id_product_PK != other.id_product_PK)
			return false;
		return true;
	}

	
   
}
