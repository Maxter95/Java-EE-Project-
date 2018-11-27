package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;

@Local
public interface ReservationServiceLocal {
	
	
	void AddReservationService(ReservationStand reservationstand);

	void UpdateReservationService(ReservationStand reservationstand);

	void DeleteReservationService(ReservationStand reservationstand);

	List<ReservationStand> FindReservationService(Integer standNumber);

	List<ReservationStand> FindAllReservationService();
	
}
