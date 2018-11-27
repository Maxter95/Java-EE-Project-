package controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote;


public class MyReservationController implements Initializable {

	private List <ReservationStand> dt= null;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ReservationStand> tablec;

    @FXML
    private TableColumn<ReservationStand, Integer> standnumber;

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
    private JFXDatePicker dates;

    @FXML
    private JFXTextField endhour;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXComboBox<Integer> stSize;
    
    @FXML
    private Label lab;

    @FXML
    private JFXButton b_submit;

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

    @FXML
    void submit_co(ActionEvent event) {

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
			System.out.println("ex");			
			}
	
	
	
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
  ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(7));
	 tablec.setItems(data);


    }

    @FXML
    void initialize() {
        assert tablec != null : "fx:id=\"tablec\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert standnumber != null : "fx:id=\"standnumber\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert day != null : "fx:id=\"day\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert shour != null : "fx:id=\"shour\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert ehour != null : "fx:id=\"ehour\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert standsize != null : "fx:id=\"standsize\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert customernumber != null : "fx:id=\"customernumber\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert dates != null : "fx:id=\"dates\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert endhour != null : "fx:id=\"endhour\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert cin != null : "fx:id=\"cin\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert stSize != null : "fx:id=\"stSize\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert b_submit != null : "fx:id=\"b_submit\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert bdelete != null : "fx:id=\"bdelete\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert bupdate != null : "fx:id=\"bupdate\" was not injected: check your FXML file 'ReservationSt.fxml'.";
        assert starthour != null : "fx:id=\"starthour\" was not injected: check your FXML file 'ReservationSt.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println("d5al2");
		String jndiName ="/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote";
    	Context ctx;

		try {
			ctx = new InitialContext();
		
		ReservationServiceRemote proxy = (ReservationServiceRemote) ctx.lookup(jndiName);
		System.out.println(LoginController.user);
		ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationUserService(3));
		System.out.println(data);
		tablec.setItems(data);
		dt=data ;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
    		System.out.println(e);
		}
    	
    	
		
		
		
		
		ObservableList<Integer> items = FXCollections.observableArrayList(5,
		        10);
		stSize.setItems(items);
		standnumber.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("standNumber"));
		day.setCellValueFactory(new PropertyValueFactory<ReservationStand,Date>("day"));
		shour.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("StartHour"));
		ehour.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("endHour"));
		standsize.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("StandSize"));
		customernumber.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("CustomerNumber"));

		
		
	}
}
