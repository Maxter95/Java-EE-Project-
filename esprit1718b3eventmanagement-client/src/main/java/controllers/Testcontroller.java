package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.InitialContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote;

public class Testcontroller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ReservationStand, Integer> a;

    @FXML
    private TableColumn<ReservationStand, Integer> b;
    
    @FXML
    private TableView<ReservationStand> c;


    @FXML
    void initialize() {
        assert a != null : "fx:id=\"a\" was not injected: check your FXML file 'Test.fxml'.";
        assert b != null : "fx:id=\"b\" was not injected: check your FXML file 'Test.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		a.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("standNumber"));
//		day.setCellValueFactory(new PropertyValueFactory<ReservationStand,Date>("day"));
		b.setCellValueFactory(new PropertyValueFactory<ReservationStand,Integer>("StartHour"));
	try {
		InitialContext ctx;
		ctx = new InitialContext();
		ReservationServiceRemote proxy;
		proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
	ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindAllReservationService());
	c.setItems(data);
		
	} catch (Exception e) {
System.out.println("ex");	
}	
		
		

		
	}
}
