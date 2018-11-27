package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Fair;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;

/**
 * Session Bean implementation class FairService
 */
@Stateless
@LocalBean
public class FairService implements FairServiceRemote, FairServiceLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public FairService() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void AddFairService(Fair fair) {
		em.persist(fair);
	}
    @Override
    public void UpdateFairService(Fair fair) {
		
		em.merge(fair);
	}
    @Override
    public void DeleteFairService(Fair fair) {
		em.remove(em.merge(fair));	
	}
	@Override
	public List<Fair> FindAllFairService() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT f FROM Fair f ", Fair.class).getResultList();
	}
    
    @Override
	public List<Fair> FindFairService(Integer id_fair) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT f FROM Fair f WHERE f.id_Fair="+id_fair, Fair.class).getResultList();
	}
    

}
