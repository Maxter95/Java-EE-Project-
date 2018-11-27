package tn.esprit.b3.esprit1718b3eventmanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cart
 *
 */
@Entity

public class Cart implements Serializable {

	
	   

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id_product;
		private String name_product;
		private float price_product;
		private String payment_type;
		private String delivery_mode;
		private Date date;
		private String brand_categorie;
		private int number_available;
		private int views;
		private String image;
		
	

		
		private static final long serialVersionUID = 1L;

		public Cart() {
			super();
		}   
		
		public Cart(int id_product, String name_product, float price_product,  String payment_type,
				String delivery_mode,Date date,String brand_categorie,int number_available,int views) {
			super();
			this.id_product = id_product;
			this.name_product = name_product;
			this.price_product = price_product;
			this.payment_type = payment_type;
			this.delivery_mode = delivery_mode;

			this.date=date;
			this.brand_categorie = brand_categorie;
			this.number_available =number_available;
			this.views =views;
		}
		

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
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
		
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		public int getNumber_available() {
			return number_available;
		}

		public void setNumber_available(int number_available) {
			this.number_available = number_available;
		}

		public String getBrand_categorie() {
			return brand_categorie;
		}

		public void setBrand_categorie(String brand_categorie) {
			this.brand_categorie = brand_categorie;
		}

		public int getViews() {
			return views;
		}

		public void setViews(int views) {
			this.views = views;
		}

			
}
