package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;

/**
 * Session Bean implementation class ReservationService
 */
@Stateless
@LocalBean
public class ReservationService implements ReservationServiceRemote, ReservationServiceLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReservationService() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void AddReservationService(ReservationStand reservationstand) {
		em.persist(reservationstand);
	}
    @Override
    public void UpdateReservationService(ReservationStand reservationstand) {
		
		em.merge(reservationstand);
	}
    @Override
    public void DeleteReservationService(ReservationStand reservationstand) {
		em.remove(em.merge(reservationstand));	
	}
	@Override
	public List<ReservationStand> FindAllReservationService() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM ReservationStand r ", ReservationStand.class).getResultList();
	}
    
    @Override
	public List<ReservationStand> FindReservationService(Integer standNumber) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM ReservationStand r WHERE r.standNumber="+standNumber, ReservationStand.class).getResultList();
	}
    
    @Override
	public List<ReservationStand> FindReservationDayService(Date day) {
		// TODO Auto-generated method stub
		return em.createQuery("select r from ReservationStand r where r.day="+day, ReservationStand.class).getResultList();
	}
    @Override
	public ReservationStand FindReservationLocalDayService(LocalDate day) {
		// TODO Auto-generated method stub
		return em.createQuery("select r from ReservationStand r where r.day='"+day+"'", ReservationStand.class).getSingleResult();

}   @Override
	public List<ReservationStand> FindReservationUserService(Integer cin) {
	// TODO Auto-generated method stub
	return em.createQuery("select r from ReservationStand r where r.companydirector="+cin, ReservationStand.class).getResultList();

}
    }
