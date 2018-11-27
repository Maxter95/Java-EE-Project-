package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import productServices.cartServices;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Cart;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product1;

@ManagedBean
@SessionScoped
public class CartBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB

	private cartServices cartservices;
	private Cart cart;
	private List<Cart> listcart = new ArrayList<Cart>();

	public CartBean() {
	}

	@PostConstruct
	public void init() {
		listcart = cartservices.FindAllCart();
		cart = new Cart();
	}

	public void addProductToCart(Product1 product) {
		cart.setBrand_categorie(product.getBrand_categorie());
		cart.setDate(product.getDate());
		cart.setDelivery_mode(product.getDelivery_mode());
		cart.setName_product(product.getName_product());
		cart.setNumber_available(product.getNumber_available());
		cart.setPayment_type(product.getPayment_type());
		cart.setPrice_product(product.getPrice_product());
		cart.setViews(product.getViews());
		cart.setImage(product.getImage());
		cartservices.AddtoCart(cart);
		//initialiser l'objet
		cart = new Cart();
	}
	public String removeProduct(Cart cart) {
		cartservices.removeProduct(cart);
		return "cartPage?faces-redirect=true";
	}

	public List<Cart> displayallCart() {
		listcart = cartservices.FindAllCart();
		return listcart;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Cart> getListcart() {
		return listcart;
	}

	public void setListcart(List<Cart> listcart) {
		this.listcart = listcart;
	}

}
