package rhservices;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
//import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;

@Remote
public interface DemandeCongeServiceRemote {
	
	void AddDemandeConge(Conge conge);

	void UpdateDemandeConge(Conge conge);

	void DeleteDemandeConge(Conge conge);

	void UpdateStaff(Staff staff);

	Conge FindDemandeCongeById(Integer id_co);

	Staff ChangeDisponibility(Integer cin);

	List<Conge> FindAllDemandeConge();

	List<Conge> FindDemandeCongeByCin(Integer cin);

	List<Staff> FindAllStaff();

	void DeleteDemandeCongeByID(Integer id_co);

}
