package rhservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.GenericDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Session Bean implementation class DemandeCongeService
 */
@Stateless
@LocalBean
public class DemandeCongeService implements DemandeCongeServiceRemote, DemandeCongeServiceLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public DemandeCongeService() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void AddDemandeConge(Conge conge) {
		em.persist(conge);
	}
    @Override
    public void UpdateDemandeConge(Conge conge) {
		
		em.merge(conge);
	}
    @Override
    public void UpdateStaff(Staff staff) {
		
		em.merge(staff);
	}

    @Override
    public void DeleteDemandeConge(Conge conge) {
		em.remove(em.merge(conge));	
	}
    @Override
    public void DeleteDemandeCongeByID(Integer id_co) {
		//em.remove(em.merge(Conge.class, id_co));	
		//return em.createQuery("REMOVE c FROM Conge c WHERE c.id_co="+id_co, Conge.class);
		em.createQuery("delete c from Conge c WHERE c.id_co="+id_co, Conge.class).executeUpdate();
	}
    @Override
    public Conge FindDemandeCongeById(Integer id_co) {

		return em.find(Conge.class, id_co);
	}
	@Override
	public List<Conge> FindAllDemandeConge() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Conge c ", Conge.class).getResultList();
	}
	@Override
	public List<Conge> FindDemandeCongeByCin(Integer cin) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Conge c WHERE c.cin="+cin, Conge.class).getResultList();
	}
	public Staff ChangeDisponibility(Integer cin) {
		// TODO Auto-generated method stub
		
		return em.createQuery("select r from Staff r  where r.cin="+cin,Staff.class).getSingleResult();
	}
	@Override
	public List<Staff> FindAllStaff() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c FROM Staff c ", Staff.class).getResultList();
	}
}
