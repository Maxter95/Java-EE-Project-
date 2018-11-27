package productServices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Product1;

/**
 * Session Bean implementation class ProductServices
 */
@Stateless
@LocalBean
public class ProductServices implements ProductServicesRemote, ProductServicesLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ProductServices() {
        // TODO Auto-generated constructor stub
    }
    @Override
 	public List<Product1> findTopProduit() {
 		 Query query = em.createQuery("SELECT e FROM Product1 e order by e.views");
 		    
 		    List<Product1> resultList = (List<Product1>) query.setMaxResults(5).getResultList();
 			return resultList;
 		
 	}
 	  
 	@Override
 	public List<Product1> findTopRatedProduit() {
 		 Query query = em.createQuery("SELECT e FROM Product1 e order by e.price_product");
 		    
 		    List<Product1> resultList = (List<Product1>) query.setMaxResults(5).getResultList();
 			return resultList;
 		
 	}
    @Override
   	public void buy(int id) {
   		Product1 t=FindProductById(id);
   		int a=t.getNumber_available();
                   t.setNumber_available(a-1);
                   em.merge(t);
   		
   	}
       @Override
     	public void view(int id) {
    	   Product1 t=FindProductById(id);
     		int a=t.getViews();
                     t.setViews(a+1);
                     em.merge(t);
     		
     	}
    @Override
    public void AddProduct(Product1 product) {
		em.persist(product);
	}
    @Override
    public void DeleteProduct(Product1 product) {
		em.remove(em.merge(product));	
	}
    @Override
    public void UpdateProduct(Product1 product) {
		
		em.merge(product);
	}
    @Override
    public Product1 FindProductById(Integer id) {
		return em.find(Product1.class, id);
	}
    @Override
	public void DeleteProductById(int id) {
    	em.remove(FindProductById(id));
	}
    @Override
	public List<Product1> FindAllProducts() {
		return em.createQuery("SELECT c FROM Product1 c ", Product1.class).getResultList();
	}
    @Override
	public List<Product1> findWithName(String name_product) {
		return em
			.createQuery("SELECT m FROM Product1 m where m.name_product=:c",
					Product1.class).setParameter("c", name_product)
				.getResultList();
	}
}
