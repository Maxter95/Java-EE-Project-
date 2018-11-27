package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import persistence.Client;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceLocal;

@ManagedBean
@SessionScoped
public class Stands {
	@EJB
	private StandServiceLocal standservicelocal ;
	private Stand stand = new Stand() ;
	private Stand stand1  ;
	private List<Stand> Stands = new ArrayList<Stand>();
	//private BasicOpsLocal basicOpsLocal;
	private Boolean loggedInAsManager = false;
    
	public String add()
	{
	
		
		//stand.setId_s(0);
		stand.setPrice_stand(0);
		System.out.println("1");
		stand.setType_stand(null);
		stand.setDescription_stand(null);
		System.out.println("2");
		standservicelocal.AddStandService(stand);
		System.out.println("3");
		return "/login?faces-redirect=true";
	
	
	}
	
	

	public String getStands(int id_stand) {
		
		stand = standservicelocal.getStandById(id_stand);
		/*String n="/pages/UpdateJob?faces-redirect=true";
		return n;*/
		return null;
	}
	
	public String doDeleteSt(int id_stand){
		standservicelocal.DeleteStandService(standservicelocal.getStandById(id_stand));
		//init();
		//paginator = new RepeatPaginator(MyJobs);
		/*String n="/pages/MyJobOffers?faces-redirect=true";
		
		return n;*/
		return null;
	}
	
	public String doUpdateSt(){
		standservicelocal.UpdateStandService(stand);
		//init();
		//paginator = new RepeatPaginator(MyJobs);
		/*offer=new JobOffer();
		String n="/pages/MyJobOffers?faces-redirect=true";
		return n;*/
		return null;
	}
	
	
	public Stands() {
		// TODO Auto-generated constructor stub
	}
	public Stand getStand() {
		return stand;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}



	public StandServiceLocal getStandservicelocal() {
		return standservicelocal;
	}



	public void setStandservicelocal(StandServiceLocal standservicelocal) {
		this.standservicelocal = standservicelocal;
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
	

}
