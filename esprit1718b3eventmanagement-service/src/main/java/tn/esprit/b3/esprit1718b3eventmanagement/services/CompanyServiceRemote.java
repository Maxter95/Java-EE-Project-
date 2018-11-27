package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Company;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.IGenericDAO;

@Remote
public interface CompanyServiceRemote extends IGenericDAO<Company> {

	void deleteCompany(Company Company);

	void addCompany(Company Company);

	void updateCompany(Company Company);

	Company findCompanyById(int idCompany);

	List<Company> getAllCompany();

	Company findCompanyByDirector(CompanyDirector Director);


}
