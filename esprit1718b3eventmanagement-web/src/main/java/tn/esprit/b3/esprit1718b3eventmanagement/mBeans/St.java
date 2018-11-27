package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceLocal;

@ManagedBean
@SessionScoped
public class St {
	
	private Stand stand =new Stand();
	private Stand stand1  ;
	private List<Stand> Mystands = new ArrayList<Stand>();
	private List<Stand> Lsstand = new ArrayList<Stand>();
	
	public List<Stand> getLsstand() {
		return Lsstand;
	}

	public void setLsstand(List<Stand> lsstand) {
		Lsstand = lsstand;
	}

	private List<Stand> Stands = new ArrayList<Stand>();
	
	
	@EJB
	private StandServiceLocal standservicelocal ;
	
	private Boolean loggedInAsManager = false;
	
	public String add()
	{
	
		
		//stand.setId_s(0);
	/*	stand.setPrice_stand(0);
		stand.setType_stand(null);
		stand.setDescription_stand(null);*/
		standservicelocal.AddStandService(stand);
		
		return"/StandDetail?faces-redirect=true";
		//stand = new Stand() ;
		
	    
	
	}
	
	public void doDeleteSt(int id_stand){
		standservicelocal.DeleteStandService(standservicelocal.getStandById(id_stand));
		//init();
		//paginator = new RepeatPaginator(MyJobs);
		/*String n="/pages/MyJobOffers?faces-redirect=true";
		
		return n;*/
		
	}
	
public void getStands(int id_stand) {
		
		stand = standservicelocal.getStandById(id_stand);
		/*String n="/pages/UpdateJob?faces-redirect=true";
		return n;*/
		
	}

	public StandServiceLocal getStandservicelocal() {
		return standservicelocal;
	}
	public void setStandservicelocal(StandServiceLocal standservicelocal) {
		this.standservicelocal = standservicelocal;
	}
	public Stand getStand() {
		return stand;
	}
	public void setStand(Stand stand) {
		this.stand = stand;
	}
	public Stand getStand1() {
		return stand1;
	}
	public void setStand1(Stand stand1) {
		this.stand1 = stand1;
	}
	public List<Stand> getStands() {
		return Stands;
	}
	public void setStands(List<Stand> stands) {
		Stands = stands;
	}
	public Boolean getLoggedInAsManager() {
		return loggedInAsManager;
	}
	public void setLoggedInAsManager(Boolean loggedInAsManager) {
		this.loggedInAsManager = loggedInAsManager;
	}
	public St() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void init() {
		setLsstand(standservicelocal.FindAllStandService());
	
	}
	
	public List<Stand> getMystands() {
		return Mystands;
	}

	public void setMystands(List<Stand> mystands) {
		Mystands = mystands;
	}

}
