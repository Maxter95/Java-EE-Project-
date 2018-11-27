package productServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Cart;

@Local
public interface cartServicesLocal {

	public void AddtoCart(Cart cart);
	public List<Cart> FindAllCart();
	public void removeProduct(Cart cart);

}
