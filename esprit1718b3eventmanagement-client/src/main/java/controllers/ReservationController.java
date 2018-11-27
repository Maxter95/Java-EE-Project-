package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import rhservices.DemandeCongeServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote;

public class ReservationController extends AnchorPane implements Initializable {

	@FXML
    private JFXDatePicker dates;

    @FXML
    private JFXTextField endhour;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXComboBox<Integer> stSize;

    @FXML
    private JFXButton b_submit;

    @FXML
    private TableView<ReservationStand> tablec;

    @FXML
    private TableColumn<ReservationStand, Integer> standnumber;

   /* @FXML
    private TableColumn<ReservationStand, String> director;*/

    @FXML
    private TableColumn<ReservationStand, Date> day;

    @FXML
    private TableColumn<ReservationStand, Integer> shour;

    @FXML
    private TableColumn<ReservationStand, Integer> ehour;

    @FXML
    private TableColumn<ReservationStand, Integer> standsize;

    @FXML
    private TableColumn<ReservationStand, Integer> customernumber;

    @FXML
    private JFXButton bdelete;

    @FXML
    private JFXButton bupdate;

    @FXML
    private JFXTextField starthour;

    @FXML
    void delete(ActionEvent event) {
    	
    	InitialContext ctx;
		try {
			ctx = new InitialContext();
			ReservationServiceRemote proxy;
			proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");

			Integer selected = tablec.getSelectionModel().getSelectedIndex();

			if (tablec.getSelectionModel().isSelected(selected)) {
				proxy.DeleteReservationService(tablec.getItems().get(selected));
				tablec.getItems().remove(tablec.getItems().get(selected));
				ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(7));
				 tablec.setItems(data);

			} else {
				System.out.println("selectionner un élement" + selected);
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @SuppressWarnings("deprecation")
	@FXML
    public void submit_co(ActionEvent event) {
    	InitialContext ctx;
		
		if (!stSize.getSelectionModel().getSelectedItem().equals("") && !starthour.getText().equals("") && !endhour.getText().equals("") && !cin.getText().equals("")  ) {
			
			Date d;
			
			if (dates.getValue() == null) {
				d = new Date(0);
				
			} else {
				
				d = new Date(dates.getValue().getYear() - 1900, dates.getValue().getMonthValue() - 1,
						dates.getValue().getDayOfMonth());
				
			}
			ReservationStand r = new ReservationStand(4,Integer.parseInt(cin.getText()), d, Integer.parseInt(starthour.getText()), Integer.parseInt(endhour.getText()), stSize.getSelectionModel().getSelectedItem());


			//c.setUser(cin.getText());
			r.setDay(d);
			try {
				ctx = new InitialContext();
				ReservationServiceRemote proxy;
				proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
				proxy.AddReservationService(r);
				System.out.println("date mouch mrigla") ;
			} catch (Exception e) {
System.out.println(r);			}

			 System.out.println("done");	
			    starthour.clear();
			    endhour.clear();
				stSize.setPromptText("type");
				dates.setPromptText("");
				cin.clear();
			
			//ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(7));
			 //tablec.setItems(data);
			 
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
    void update(ActionEvent event) throws NamingException {
		
		try {
			System.out.println("1");
			InitialContext ctx = new InitialContext();
			ReservationServiceRemote proxy;
			proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
			List<ReservationStand> list = proxy.FindAllReservationService();
			System.out.println("date mouch mrigla") ;
		} catch (Exception e) {
System.out.println("ex");			}
    	
    	
    	
    	Integer selected = tablec.getSelectionModel().getSelectedIndex();
		InitialContext ctx;
		ctx = new InitialContext();
		ReservationServiceRemote proxy;
		proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
      if (tablec.getSelectionModel().isSelected(selected)) {

			ReservationStand rr = (ReservationStand) tablec.getItems().get(selected);
			rr.setStartHour(Integer.parseInt(starthour.getText()));
			rr.setEndHour(Integer.parseInt(endhour.getText()));
			rr.setCustomerNumber(Integer.parseInt(cin.getText()));
			rr.setStandSize(stSize.getSelectionModel().getSelectedItem());
			
			Date d;
			if (dates.getValue() == null) {
				d = new Date(0);
			} else {
				d = new Date(dates.getValue().getYear() - 1900, dates.getValue().getMonthValue() - 1,
						dates.getValue().getDayOfMonth());
			}
			

			
			rr.setDay(d);
			proxy.UpdateReservationService(rr);
			starthour.clear();
			cin.clear();
			endhour.clear();
			stSize.setPromptText("Type");
			dates.setPromptText("");

		}
     // ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(7));
	//	 tablec.setItems(data);


    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*// TODO Auto-generated method stub
		ObservableList<Integer> items = FXCollections.observableArrayList(5,
		        10);
	stSize.setItems(items);*/
/*
			standnumber.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("StandNumber"));
//			day.setCellValueFactory(new PropertyValueFactory<ReservationStand,Date>("day"));
			shour.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("starthour"));
			ehour.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("endhour"));
			standsize.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("StandSize"));
			customernumber.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("CustomerNumber"));
			*/
			/*try {
				InitialContext ctx;
				ctx = new InitialContext();
				ReservationServiceRemote proxy;
				proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
			//ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindAllReservationService());
			
				*/
				
		/*		
				List<ReservationStand> list = FXCollections.observableArrayList(proxy.FindAllReservationService());
			System.out.println(list);
			//tablec.setItems(data);
		} catch (Exception e1) {
				System.out.println("ex");
		}*/
			
			
			

			
		
	}
}
