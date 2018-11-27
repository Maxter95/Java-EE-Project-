package productServices;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Cart;

@Remote
public interface cartServicesRemote {
	
	public void AddtoCart(Cart cart);
	public List<Cart> FindAllCart();
	public void removeProduct(Cart cart);

}
