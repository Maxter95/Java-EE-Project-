package productServices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Cart;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product1;

/**
 * Session Bean implementation class cartServices
 */
@Stateless
@LocalBean
public class cartServices implements cartServicesRemote, cartServicesLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public cartServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void AddtoCart(Cart cart) {
		em.persist(cart);
	}
	 @Override
	 public void removeProduct(Cart cart) {
	    em.remove(em.merge(cart));	
		}

	@Override
	public List<Cart> FindAllCart() {

		return em.createQuery("SELECT c FROM Cart c ", Cart.class).getResultList();
	}

}
