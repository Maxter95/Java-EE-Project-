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
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote;

public class StandfController implements Initializable  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Stand> tablec;

    @FXML
    private TableColumn<Stand, String> tstand;

    @FXML
    private TableColumn<Stand, Float> pstand;

    @FXML
    private TableColumn<Stand, String> dstand;

    @FXML
    void initialize() {
        assert tablec != null : "fx:id=\"tablec\" was not injected: check your FXML file 'standf.fxml'.";
        assert tstand != null : "fx:id=\"tstand\" was not injected: check your FXML file 'standf.fxml'.";
        assert pstand != null : "fx:id=\"pstand\" was not injected: check your FXML file 'standf.fxml'.";
        assert dstand != null : "fx:id=\"dstand\" was not injected: check your FXML file 'standf.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> items = FXCollections.observableArrayList("v",
		        "b");
		ObservableList<Integer> itemss = FXCollections.observableArrayList(5,
		        10);
		//typestand.setItems(items);
		//procestand.setItems(itemss);
		tstand.setCellValueFactory(new PropertyValueFactory<Stand,String>("type_stand"));
		pstand.setCellValueFactory(new PropertyValueFactory<Stand,Float>("price_stand"));
		dstand.setCellValueFactory(new PropertyValueFactory<Stand,String>("description_stand"));
		
	try {
		InitialContext ctx;
		ctx = new InitialContext();
		StandServiceRemote proxy;
		proxy = (StandServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");
	ObservableList<Stand> data = FXCollections.observableArrayList(proxy.FindAllStandService());
	tablec.setItems(data);
		
	} catch (Exception e) {
    System.out.println("ex");	
		
	}
		
		
	}
		
	}

