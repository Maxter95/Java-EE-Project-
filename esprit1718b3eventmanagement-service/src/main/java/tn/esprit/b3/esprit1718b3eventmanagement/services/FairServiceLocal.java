package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Fair;

@Local
public interface FairServiceLocal {

	void AddFairService(Fair fair);

	void UpdateFairService(Fair fair);

	void DeleteFairService(Fair fair);

	List<Fair> FindAllFairService();

	List<Fair> FindFairService(Integer id_fair);

}
