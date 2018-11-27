package tn.esprit.b3.esprit1718b3eventmanagement.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Company;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.utilities.GenericDAO;

/**
 * Session Bean implementation class CompanyService
 */
@Stateless
public class CompanyService extends GenericDAO<Company> implements CompanyServiceRemote, CompanyServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public CompanyService() {
		super(Company.class);
	}

	@Override
	public void addCompany(Company Company) {
		entityManager.persist(Company);
	}

	@Override
	public void deleteCompany(Company Company) {

		entityManager.remove(entityManager.merge(Company));
	}

	@Override
	public void updateCompany(Company Company) {

		entityManager.merge(Company);
	}

	@Override
	public Company findCompanyById(int idCompany) {
		return entityManager.find(Company.class, idCompany);
	}
	
	
	@Override
	public List<Company> getAllCompany() {
		return entityManager.createQuery("select u from Company u", Company.class).getResultList();
	}
	
	@Override
	public Company findCompanyByDirector(CompanyDirector Director) {
		return entityManager.createQuery("select u from Company u where u.director=?1", Company.class).setParameter(1, Director)
				.getSingleResult();
	}

}
