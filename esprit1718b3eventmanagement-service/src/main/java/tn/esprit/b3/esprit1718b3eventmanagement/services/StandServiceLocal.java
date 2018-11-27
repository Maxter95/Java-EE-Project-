package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.IGenericDAO;

@Local
public interface StandServiceLocal extends IGenericDAO<Stand> {
	
	void AddStandService(Stand stand);

	void UpdateStandService(Stand stand);

	void DeleteStandService(Stand stand);

	List<Stand> FindAllStandService();

	List<Stand> FindStandService(Integer id_stand);
	
	public Stand getStandById(Integer id_stand) ;

}
