package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceLocal;

@ManagedBean
@SessionScoped
public class Reserv {

	@EJB
	private ReservationServiceLocal reservationstandlocal ;
	private ReservationStand reservationstand = new ReservationStand();
	private List<ReservationStand> Lrservation = new ArrayList<ReservationStand>();
	private ReservationStand reservationselected ;
	
	public ReservationStand getReservationselected() {
		return reservationselected;
	}


	public void setReservationselected(ReservationStand reservationselected) {
		this.reservationselected = reservationselected;
	}


	@PostConstruct
	public void init(){
		setLrservation(reservationstandlocal.FindAllReservationService());
		
	}
	
	public void doDeleteRs(){


		//System.out.println("satand selected ::::"+standSelected.getId_s());
		reservationstandlocal.DeleteReservationService(reservationselected);;
		//init();
		//paginator = new RepeatPaginator(MyJobs);
		/*String n="/pages/MyJobOffers?faces-redirect=true";
		
		return n;*/
		
	}
	
	/*public void addSt()
	{
	
		
		//stand.setId_s(0);
		stand.setPrice_stand(0);
		stand.setType_stand(null);
		stand.setDescription_stand(null);
		reservationstandlocal.AddReservationService(reservationstand);
		//stand = new Stand() ;
		
	    //init() ;
	
	}*/
     
	
	public ReservationServiceLocal getReservationstandlocal() {
		return reservationstandlocal;
	}

	public void setReservationstandlocal(ReservationServiceLocal reservationstandlocal) {
		this.reservationstandlocal = reservationstandlocal;
	}

	public ReservationStand getReservationstand() {
		return reservationstand;
	}

	public void setReservationstand(ReservationStand reservationstand) {
		this.reservationstand = reservationstand;
	}

	public List<ReservationStand> getLrservation() {
		return Lrservation;
	}

	public void setLrservation(List<ReservationStand> lrservation) {
		Lrservation = lrservation;
	}
	
	public Reserv() {
		// TODO Auto-generated constructor stub
	}
    
}
