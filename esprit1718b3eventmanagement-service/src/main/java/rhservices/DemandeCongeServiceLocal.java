package rhservices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;

@Local
public interface DemandeCongeServiceLocal {

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
