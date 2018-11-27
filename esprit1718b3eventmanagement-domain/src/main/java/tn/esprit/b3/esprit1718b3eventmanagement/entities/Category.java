package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   

	@Id
	@GeneratedValue
	private int id_category;
	private String brand_category;
	private String model_category;
	
	@OneToMany(mappedBy="category")
	private List<Product> product;
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}   
	
	public Category(int id_category, String brand_category, String model_category, List<Product> product) {
		super();
		this.id_category = id_category;
		this.brand_category = brand_category;
		this.model_category = model_category;
		this.product = product;
	}
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_category() {
		return this.id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}   
	public String getBrand_category() {
		return this.brand_category;
	}

	public void setBrand_category(String brand_category) {
		this.brand_category = brand_category;
	}   
	public String getModel_category() {
		return this.model_category;
	}

	public void setModel_category(String model_category) {
		this.model_category = model_category;
	}
   
}
