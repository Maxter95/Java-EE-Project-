package productServices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Category;







/**
 * Session Bean implementation class ProductServices
 */
@Stateless
@LocalBean

public class CategoriesServices implements CategoriesServicesLocal,CategoriesServicesRemote {
	
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CategoriesServices() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void AddCategorie(Category categorie) {
		em.persist(categorie);
	}
    
	@Override
	public List<Category> FindAllCateogorie() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Category c ", Category.class).getResultList();
	}
	 @Override
		public List<Category> findWithName(String model_product) {
			return em
				.createQuery("select m from Category m where m.model_product=:c",
						Category.class).setParameter("c", model_product)
					.getResultList();
		}
}
