package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;

@Remote
public interface StandServiceRemote {

	void AddStandService(Stand stand);

	void UpdateStandService(Stand stand);

	void DeleteStandService(Stand stand);

	List<Stand> FindAllStandService();

	List<Stand> FindStandService(Integer id_stand);

	Stand getStandById(Integer id_stand);

}
