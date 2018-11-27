package tn.esprit.b3.esprit1718b3eventmanagement.utilities;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Admin;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Client;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Company;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Organizer;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.CompanyServiceLocal;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	
	@EJB
	private UserServiceLocal userServiceLocal;
	
	@EJB 
	private CompanyServiceLocal companyServiceLocal;
	
	Date d = new Date();
	public DBPopulator() {
	}

	@PostConstruct
	public void init() {

		User user5 = new  Staff(5, "beher", "5","5","mahmoudbeher.chebil@esprit.tn","chebil",5,"5", 1, 0, 2, 1000, 1);
		User user6 = new Staff(6, "mah", "6", "6", "mahmoudbeher.chebil@esprit.tn", "moud", 6, "6", 1, 0, 5, 1500, 4);
		User user7 = new Client(7, "7", "7", "7", "7", "7", 7, "7");

		user5.setState_account("ACTIVE");
		user5.setAccount_date(new Date());
		user6.setState_account("ACTIVE");
		user6.setAccount_date(new Date());
		user7.setState_account("ACTIVE");
		user7.setAccount_date(new Date());
		User user1 = new Organizer(1, "1", "1", "1", "1", "1", 1, "1", d, "ACTIVE");
		//User user2 = new Staff(2, "2", "2", "2", "2", "2", 2, "2", d, "ACTIVE");
		User user3 =new CompanyDirector(3, "3", "3", "3", "3", "3", 3, "3", d, "ACTIVE");
		User user4 =new Admin(4, "4", "4", "4", "4", "4", 4, "4",d,"ACTIVE");
		//user2.setState_account("ACTIVE");
		user3.setAccount_date(new Date());
		CompanyDirector director = (CompanyDirector) user3;

		Company company1 = new Company(3, "3", "3", "3", "3", director);
		userServiceLocal.update(user1);
		//userServiceLocal.update(user2);
		userServiceLocal.update(user3);
		userServiceLocal.update(user4);
		userServiceLocal.update(user6);
		userServiceLocal.update(user5);
		userServiceLocal.update(user7);
		companyServiceLocal.update(company1);
	}
}
