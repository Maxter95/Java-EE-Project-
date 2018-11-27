package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Fair;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;

@Remote
public interface FairServiceRemote {

	void AddFairService(Fair fair);

	void UpdateFairService(Fair fair);

	void DeleteFairService(Fair fair);

	List<Fair> FindAllFairService();

	List<Fair> FindFairService(Integer id_fair);

}
