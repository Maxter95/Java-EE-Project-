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
public class StandList {

	@EJB
	private StandServiceLocal standservicelocal ;
	private Stand stand =new Stand();
	private List<Stand> Lsstand = new ArrayList<Stand>();
	private Stand standSelected;
	private int nbr ;
	private float com ;
	private float d ;
	private static float budget ;
	
	
	@PostConstruct
	public void init (){
		setLsstand(standservicelocal.FindAllStandService());
        
	}
	
public void getStands(int id_stand) {
		
		stand = standservicelocal.getStandById(id_stand);
		/*String n="/pages/UpdateJob?faces-redirect=true";
		return n;*/
		
	}
public void doDeleteSt(){


	//System.out.println("satand selected ::::"+standSelected.getId_s());
	standservicelocal.delete(standSelected);
	init();
	//paginator = new RepeatPaginator(MyJobs);
	/*String n="/pages/MyJobOffers?faces-redirect=true";
	
	return n;*/
	
}
public String page(){
	return"/AddStand?faces-redirect=true";
}
public String pagest(){
	return"/StandReservation?faces-redirect=true";
}
public String pageadd(){
	return"/AddStand?faces-redirect=true";
}
public void doCalculst(float budget){
	
	d=budget/standSelected.getPrice_stand();
	
}
public void doCalculReste(){
	
	float r ;
	float complete ;
	float dd ;
	d=budget/standSelected.getPrice_stand();
    dd=(int)d ;
	r=budget-(standSelected.getPrice_stand()*dd) ;
	complete=standSelected.getPrice_stand()+r ;
	nbr=(int)dd ;
	com=complete ;
	System.out.println("he4eka houwa ereste"+r);
	System.out.println("he4eka houwa eli yelzmou yekmil"+complete);

	
}
public String doUpdateSt(){


	//System.out.println("satand selected ::::"+standSelected.getId_s());
	standservicelocal.delete(standSelected);
	init();
	return"/AddStand?faces-redirect=true";
	
	
	//paginator = new RepeatPaginator(MyJobs);
	/*String n="/pages/MyJobOffers?faces-redirect=true";
	
	return n;*/
	
}


public Stand getStand() {
	return stand;
}
public void setStand(Stand stand) {
	this.stand = stand;
}

public List<Stand> getLsstand() {
	return Lsstand;
}
public void setLsstand(List<Stand> lsstand) {
	Lsstand = lsstand;
}
public StandServiceLocal getStandservicelocal() {
	return standservicelocal;
}
public void setStandservicelocal(StandServiceLocal standservicelocal) {
	this.standservicelocal = standservicelocal;
}
public Stand getStandSelected() {
	return standSelected;
}
public void setStandSelected(Stand standSelected) {
	this.standSelected = standSelected;
}

public float getD() {
	return d;
}

public void setD(float d) {
	this.d = d;
}

public float getBudget() {
	return budget;
}

public void setBudget(float budget) {
	this.budget = budget;
}

public int getNbr() {
	return nbr;
}

public void setNbr(int nbr) {
	this.nbr = nbr;
}

public float getCom() {
	return com;
}

public void setCom(float com) {
	this.com = com;
}





    

}
