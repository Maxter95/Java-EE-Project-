package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;



import javax.persistence.*;

import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: ProductLine
 *
 */
@Entity

public class ProductLine implements Serializable {
	
	@EmbeddedId 
	private ProductLinePK ProductLinePK ;
	
	private Integer product;
	@ManyToOne 
	@JoinColumn(name="id_product_PK",referencedColumnName="id_product",insertable=false,updatable=false)
	private Product productP2;
	@ManyToOne
	@JoinColumn(name="id_company_PK",referencedColumnName="id_company",insertable=false,updatable=false)
	private Company companyP;
	

	private static final long serialVersionUID = 1L;

	public ProductLine() {
		super();
	}
	
	public ProductLinePK getProductLinePK() {
		return ProductLinePK;
	}

	public void setProductLinePK(ProductLinePK productLinePK) {
		ProductLinePK = productLinePK;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	
	
	public Product getProductP2() {
		return productP2;
	}

	public void setProductP2(Product productP2) {
		this.productP2 = productP2;
	}
	
	public Company getCompanyP() {
		return companyP;
	}

	public void setCompanyP(Company companyP) {
		this.companyP = companyP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ProductLinePK == null) ? 0 : ProductLinePK.hashCode());
		result = prime * result + ((companyP == null) ? 0 : companyP.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productP2 == null) ? 0 : productP2.hashCode());
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
		ProductLine other = (ProductLine) obj;
		if (ProductLinePK == null) {
			if (other.ProductLinePK != null)
				return false;
		} else if (!ProductLinePK.equals(other.ProductLinePK))
			return false;
		if (companyP == null) {
			if (other.companyP != null)
				return false;
		} else if (!companyP.equals(other.companyP))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productP2 == null) {
			if (other.productP2 != null)
				return false;
		} else if (!productP2.equals(other.productP2))
			return false;
		return true;
	}

	
		
   
}
