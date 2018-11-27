package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;


import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;

@Remote
public interface ReservationServiceRemote {
	
	void AddReservationService(ReservationStand reservationstand);
	void UpdateReservationService(ReservationStand reservationstand);
	void DeleteReservationService(ReservationStand reservationstand);
	List<ReservationStand> FindReservationService(Integer standNumber);
	List<ReservationStand> FindAllReservationService();
	List<ReservationStand> FindReservationDayService(Date d);
	//List<ReservationStand> FindReservationLocalDayService(LocalDate day);
	List<ReservationStand> FindReservationUserService(Integer cin);
	ReservationStand FindReservationLocalDayService(LocalDate day);
	
	
	
	
	
}
