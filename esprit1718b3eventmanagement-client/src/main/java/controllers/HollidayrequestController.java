package controllers;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;



import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TitledPane;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import rhservices.DemandeCongeServiceRemote;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
public class HollidayrequestController extends AnchorPane implements Initializable {

    @FXML
    private JFXDatePicker dateC;

    @FXML
    private JFXTextField nbjr;

    

    @FXML
    private JFXComboBox<String> cbType;

    @FXML
    private JFXComboBox<String> certif;

    @FXML
    private JFXButton BTsub_co;
    @FXML
    private JFXButton btsalary;

    @FXML
    private TableView<Conge> tablec;

    @FXML
    private TableColumn<Conge,Date> cdate;

    @FXML
    private TableColumn<Conge,String> ctype;

    @FXML
    private TableColumn<Conge,String> ccertif;

    @FXML
    private TableColumn<Conge,Integer> cdays;

    @FXML
    private TableColumn<Conge,String> cstatus;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		 ObservableList<String> items = FXCollections.observableArrayList("Medical",
			        "Normal");
	       
		 cbType.setItems(items);	
		 ObservableList<String> itemss = FXCollections.observableArrayList("Available",
			        "Unavailable");
		 certif.setItems(itemss);
		 InitialContext ctx;
			try {
				ctx = new InitialContext();
				DemandeCongeServiceRemote proxy;

				proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

				cdate.setCellValueFactory(new PropertyValueFactory<Conge,Date>("date_co"));
				ctype.setCellValueFactory(new PropertyValueFactory<Conge,String>("type_co"));
				ccertif.setCellValueFactory(new PropertyValueFactory<Conge,String>("certificat"));
				cdays.setCellValueFactory(new PropertyValueFactory<Conge,Integer>("nbjrs_co"));
				cstatus.setCellValueFactory(new PropertyValueFactory<Conge,String>("status_co"));
				ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				tablec.setItems(data);
				
				
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
			
				
			
	}

    @SuppressWarnings("deprecation")
	@FXML
    void submit_co(ActionEvent event) throws NamingException {
    	InitialContext ctx;
		ctx = new InitialContext();
		DemandeCongeServiceRemote proxy;
		proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

		if (!nbjr.getText().equals("")  && !cbType.getSelectionModel().getSelectedItem().equals("")&& !certif.getSelectionModel().getSelectedItem().equals("")) {

			Conge c = new Conge(cbType.getSelectionModel().getSelectedItem(),certif.getSelectionModel().getSelectedItem(),Integer.parseInt(nbjr.getText()),"not exhamined yet",LoginController.user.getCin());
			Date d;
			if (dateC.getValue() == null) {
				d = new Date(0);
			} else {
				d = new Date(dateC.getValue().getYear() - 1900, dateC.getValue().getMonthValue() - 1,
						dateC.getValue().getDayOfMonth());
			}
			

			//c.setUser(cin.getText());
			c.setDate_co(d);
			proxy.AddDemandeConge(c);
			 System.out.println("done");	
			 nbjr.clear();
				
				cbType.setPromptText("type");
				certif.setPromptText("certificate");
				dateC.setPromptText("");
			
			ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
			 tablec.setItems(data);
			 Notifications notification11 = Notifications.create().title("Done !")
						.text("Holiday request succesfully added").graphic(null).hideAfter(Duration.seconds(5))
						.position(Pos.BOTTOM_RIGHT);

				notification11.darkStyle();
				notification11.showWarning();
			 
			 
		} else {
			//erreur.setText("champs vide!!");
			
			 System.out.println("not done");
		}
    }
    private Calendar pickDateConversion(DatePicker datePicker) {
		Calendar cal = Calendar.getInstance();
		Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		cal.setTime(date);
		return cal;
	}
    @FXML
    void delete(ActionEvent event) {
    	InitialContext ctx;
		try {
			ctx = new InitialContext();
			DemandeCongeServiceRemote proxy;
			proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

			Integer selected = tablec.getSelectionModel().getSelectedIndex();

			if (tablec.getSelectionModel().isSelected(selected)) {
				proxy.DeleteDemandeConge(tablec.getItems().get(selected));
				tablec.getItems().remove(tablec.getItems().get(selected));
				ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				 tablec.setItems(data);
				 Notifications notification11 = Notifications.create().title("Done !")
							.text("Holiday request succesfully deleted").graphic(null).hideAfter(Duration.seconds(5))
							.position(Pos.BOTTOM_RIGHT);

					notification11.darkStyle();
					notification11.showWarning();
					try{
			            String host ="smtp.gmail.com" ;
			            String user = "manegementevent@gmail.com";
			            String pass = "20778737";
			            String to = LoginController.user.getEmail();
			            String from = "mohamedfadhel.louati@gmail.com";
			            String subject = "Your holiday request have successfully been  deleted , PLEASE  CHECK YOUR EMAIL";
			            String messageText = "Your Is Test Email :";
			            boolean sessionDebug = false;

			            Properties props = System.getProperties();

			            props.put("mail.smtp.starttls.enable", "true");
			            props.put("mail.smtp.host", host);
			            props.put("mail.smtp.port", "587");
			            props.put("mail.smtp.auth", "true");
			            props.put("mail.smtp.starttls.required", "true");

			            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			            Session mailSession = Session.getDefaultInstance(props, null);
			            mailSession.setDebug(sessionDebug);
			            Message msg = new MimeMessage(mailSession);
			            msg.setFrom(new InternetAddress(from));
			            InternetAddress[] address = {new InternetAddress(to)};
			            msg.setRecipients(Message.RecipientType.TO, address);
			            msg.setSubject(subject); msg.setSentDate(new Date());
			            msg.setText(messageText);

			           Transport transport=mailSession.getTransport("smtp");
			           transport.connect(host, user, pass);
			           transport.sendMessage(msg, msg.getAllRecipients());
			           transport.close();
			           System.out.println("message send successfully");
			           }
					catch(Exception ex)
			        {
				            System.out.println(ex);
				        }

			} else {
				System.out.println("selectionner un élement" + selected);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    @FXML
    void update(ActionEvent event) throws NamingException {
    	Integer selected = tablec.getSelectionModel().getSelectedIndex();
		InitialContext ctx;
		ctx = new InitialContext();
		DemandeCongeServiceRemote proxy;
		proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");
      if (tablec.getSelectionModel().isSelected(selected)) {

			Conge cc = tablec.getItems().get(selected);
			cc.setNbjrs_co(Integer.parseInt(nbjr.getText()));
			
			cc.setType_co(cbType.getSelectionModel().getSelectedItem());
			cc.setCertificat(certif.getSelectionModel().getSelectedItem());
			Date d;
			if (dateC.getValue() == null) {
				d = new Date(0);
			} else {
				d = new Date(dateC.getValue().getYear() - 1900, dateC.getValue().getMonthValue() - 1,
						dateC.getValue().getDayOfMonth());
			}
			

			cc.setStatus_co(" not exhamined yet ");
			cc.setDate_co(d);
			proxy.UpdateDemandeConge(cc);
			nbjr.clear();
			
			cbType.setPromptText("Type");
			certif.setPromptText("certificate");
			dateC.setPromptText("");

		}
      ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
		 tablec.setItems(data);
		 Notifications notification11 = Notifications.create().title("Done !")
					.text("Holiday request succesfully updated").graphic(null).hideAfter(Duration.seconds(5))
					.position(Pos.BOTTOM_RIGHT);

			notification11.darkStyle();
			notification11.showWarning();
    }
    //@FXML
  //  void bttraiter(ActionEvent event) throws NamingException {
    	//InitialContext ctx;
		//ctx = new InitialContext();
		//DemandeCongeServiceRemote proxy;
		//proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

		//ObservableList<Conge> data2 = FXCollections.observableArrayList(proxy.FindAllDemandeConge());
		//for(Conge str:data2)  {
       //    int k;
       // k=str.getCin();
   // System.out.println(proxy.ChangeDisponibility(str.getCin()).getNbjrscp()); 
      //    System.out.println(k); 
          //if ((str.getType_co()).equals("Medical") && (str.getCertificat()).equals("Available")){
        	//  str.setStatus_co("Accepted");
        	//  proxy.UpdateDemandeConge(str);
        	 // ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
     		// tablec.setItems(data);
        	  
        //  }
        //  else if ((str.getType_co()).equals("Medical") && (str.getCertificat()).equals("Unavailable")){
        	//  str.setStatus_co("Rejected");
        	//	proxy.UpdateDemandeConge(str);
        	//  ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
     	//	 tablec.setItems(data);
     	
        	  
        //  }
        //  else if ((str.getType_co()).equals("Normal") &&  (str.getCertificat()).equals("Available") && (proxy.ChangeDisponibility(str.getCin()).getNbjrscp()+str.getNbjrs_co())<=30){
         //	 str.setStatus_co("Your request is confusing");
         //	proxy.UpdateDemandeConge(str);
      //  ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
      	// tablec.setItems(data);
      	
         	  
        //   }
      //   else if ((str.getType_co()).equals("Normal") && (proxy.ChangeDisponibility(str.getCin()).getNbjrscp()+str.getNbjrs_co())<=30){
        	 //str.setStatus_co("Accepted");
        	// Staff ss = proxy.ChangeDisponibility(str.getCin());
        	// ss.setNbjrscp((ss.getNbjrscp())+(str.getNbjrs_co()));
        	  //proxy.ChangeDisponibility(str.getCin()).setNbjrscp((proxy.ChangeDisponibility(str.getCin()).getNbjrscp())+str.getNbjrs_co());
        	//	proxy.UpdateStaff(ss);
        //	  proxy.UpdateDemandeConge(str);
      // ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
     	// tablec.setItems(data);
     	
        	  
       //   }
       ///  else if ((str.getType_co()).equals("Normal") && (proxy.ChangeDisponibility(str.getCin()).getNbjrscp()+str.getNbjrs_co())>30){
       // 	 str.setStatus_co("Rejected");
        //	proxy.UpdateDemandeConge(str);
       //ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
     	// tablec.setItems(data);
     	
        	  
        //  }
        //
        //    }
   // }
    //@FXML
  //  void salary(ActionEvent event)throws NamingException {
    	//InitialContext ctx;
		//ctx = new InitialContext();
	///DemandeCongeServiceRemote proxy;
	//	proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");
//
	//	ObservableList<Staff> data3 = FXCollections.observableArrayList(proxy.FindAllStaff());
		//for(Staff str:data3)  {
		//	if (str.getIncrease()<str.getYearswork()){
		//		 Staff ss = proxy.ChangeDisponibility(str.getCin());
		////		 ss.setSalary_staff((((str.getYearswork())-(str.getIncrease()))*2*(str.getSalary_staff()/100))+str.getSalary_staff());
		//		ss.setIncrease(str.getIncrease()+((str.getYearswork())-(str.getIncrease())));
		//		proxy.UpdateStaff(ss);
		//	}
			
	//	}

  //  }
}
