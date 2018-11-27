package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

	   
	
	@Id
	@GeneratedValue
	private int id_pomotion;
	private float price_pomotion;
	private Date date_promotion;
	private int delai_pomotion;
	private Blob image_pomotion;
	private String description_pomotion;

	@OneToMany(mappedBy="promotion")
	private List<Product> product;
	private static final long serialVersionUID = 1L;

	public Promotion() {
		super();
	}   
	
	public Promotion(int id_pomotion, float price_pomotion, Date date_promotion, int delai_pomotion,
			Blob image_pomotion, String description_pomotion, List<Product> product) {
		super();
		this.id_pomotion = id_pomotion;
		this.price_pomotion = price_pomotion;
		this.date_promotion = date_promotion;
		this.delai_pomotion = delai_pomotion;
		this.image_pomotion = image_pomotion;
		this.description_pomotion = description_pomotion;
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

	public int getId_pomotion() {
		return this.id_pomotion;
	}

	public void setId_pomotion(int id_pomotion) {
		this.id_pomotion = id_pomotion;
	}   
	public float getPrice_pomotion() {
		return this.price_pomotion;
	}

	public void setPrice_pomotion(float price_pomotion) {
		this.price_pomotion = price_pomotion;
	}   
	public Date getDate_promotion() {
		return this.date_promotion;
	}

	public void setDate_promotion(Date date_promotion) {
		this.date_promotion = date_promotion;
	}   
	public int getDelai_pomotion() {
		return this.delai_pomotion;
	}

	public void setDelai_pomotion(int delai_pomotion) {
		this.delai_pomotion = delai_pomotion;
	}   
	public Blob getImage_pomotion() {
		return this.image_pomotion;
	}

	public void setImage_pomotion(Blob image_pomotion) {
		this.image_pomotion = image_pomotion;
	}   
	public String getDescription_pomotion() {
		return this.description_pomotion;
	}

	public void setDescription_pomotion(String description_pomotion) {
		this.description_pomotion = description_pomotion;
	}
   
}
