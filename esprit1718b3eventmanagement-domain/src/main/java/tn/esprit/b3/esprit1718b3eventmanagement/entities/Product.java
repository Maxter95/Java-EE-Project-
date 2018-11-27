package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	   

	@Id
	@GeneratedValue
	private int id_product;
	private String name_product;
	private float price_product;
	private String image_product;
	private String payment_type;
	private String delivery_mode;
	private Date date;
	private String brand_categorie;
	private String model_categorie;
	
	
	

	

	public String getBrand_categorie() {
		return brand_categorie;
	}

	public void setBrand_categorie(String brand_categorie) {
		this.brand_categorie = brand_categorie;
	}

	public String getModel_categorie() {
		return model_categorie;
	}

	public void setModel_categorie(String model_categorie) {
		this.model_categorie = model_categorie;
	}

	@ManyToOne
	private Category category;

	@ManyToOne
	private Promotion promotion;
	@OneToMany(mappedBy="productP")
	private List<OrderLine> LOrderLine;
	@OneToMany(mappedBy="productP2")
	private List<ProductLine> LproductLine;
	
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	
	public Product(int id_product, String name_product, float price_product, String image_product, String payment_type,
			String delivery_mode, Category category, Promotion promotion,Date date,String brand_categorie, String model_categorie) {
		super();
		this.id_product = id_product;
		this.name_product = name_product;
		this.price_product = price_product;
		this.image_product = image_product;
		this.payment_type = payment_type;
		this.delivery_mode = delivery_mode;
		this.category = category;
		this.promotion = promotion;
		this.date=date;
		this.brand_categorie = brand_categorie;
		this.model_categorie = model_categorie;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
	public int getId_p() {
		return id_product;
	}

	public void setId_p(int id_p) {
		this.id_product = id_p;
	}

	public String getName_product() {
		return this.name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}   
	public float getPrice_product() {
		return this.price_product;
	}

	public void setPrice_product(float price_product) {
		this.price_product = price_product;
	}   
	   
	public String getImage_product() {
		return image_product;
	}

	public void setImage_product(String image_product) {
		this.image_product = image_product;
	}

	public String getPayment_type() {
		return this.payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}   
	public String getDelivery_mode() {
		return this.delivery_mode;
	}

	public void setDelivery_mode(String delivery_mode) {
		this.delivery_mode = delivery_mode;
	}
	
	public List<OrderLine> getLOrderLine() {
		return LOrderLine;
	}

	public void setLOrderLine(List<OrderLine> lOrderLine) {
		LOrderLine = lOrderLine;
	}
	
	public List<ProductLine> getLproductLine() {
		return LproductLine;
	}

	public void setLproductLine(List<ProductLine> lproductLine) {
		LproductLine = lproductLine;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		
   
}
