package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.GenericDAO;

/**
 * Session Bean implementation class StandService
 */
@Stateless
@LocalBean
public class StandService extends GenericDAO<Stand> implements StandServiceRemote, StandServiceLocal {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public StandService() {
        // TODO Auto-generated constructor stub
    	super(Stand.class);
    }
    @Override
    public void AddStandService(Stand stand) {
		em.persist(stand);
	}
    @Override
    public void UpdateStandService(Stand stand) {
		
		em.merge(stand);
	}
    @Override
    public void DeleteStandService(Stand stand) {
		em.remove(em.merge(stand));	
	}
	@Override
	public List<Stand> FindAllStandService() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT s FROM Stand s ", Stand.class).getResultList();
	}
    
    @Override
	public List<Stand> FindStandService(Integer id_stand) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT s FROM Stand s WHERE s.id_stand="+id_stand, Stand.class).getResultList();
	}
    
    @Override
	public Stand getStandById(Integer id_stand) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT s FROM Stand s WHERE s.id_stand="+id_stand, Stand.class).getSingleResult();
	}

}
