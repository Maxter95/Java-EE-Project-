package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;


import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceLocal;

@ManagedBean
@SessionScoped
public class reservation {

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
		init();
		//paginator = new RepeatPaginator(MyJobs);
		/*String n="/pages/MyJobOffers?faces-redirect=true";
		
		return n;*/
		
	}
	public String pages(){
		return"/StandDetail?faces-redirect=true";
	}
	
	public void addSt()
	{
	
		
		//stand.setId_s(0);
		//stand.setPrice_stand(0);
		//stand.setType_stand(null);
		//stand.setDescription_stand(null);
		System.out.println("mrgl loula");
		reservationstandlocal.AddReservationService(reservationstand);
		//stand = new Stand() ;
		System.out.println("mrgl thenya");
	    //init() ;
	
	}
	public static void sendMail(String to, String sujet, String contenu) throws MessagingException {

		String host = "smtp.gmail.com";
		final String user = "irmc.pidev@gmail.com";// change accordingly
		final String password = "esprit2018";// change accordingly

		// Get the session object
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.from", user);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props, null);
		MimeMessage msg = new MimeMessage(session);

		msg.setRecipients(Message.RecipientType.TO, to);
		msg.setSubject(sujet);
		msg.setSentDate(new Date());
		msg.setText(contenu);

		Transport transport = session.getTransport("smtp");

		transport.connect(user, password);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();

	}
	public void envoi() throws MessagingException{
		sendMail("mohamedamine.maroueni@esprit.tn", "Confirm reservation of stand", "please take a look at my stand");
	}
     
	
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
	
	
	public reservation() {
		
}
}


