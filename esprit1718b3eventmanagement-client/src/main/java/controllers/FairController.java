package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Fair;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.FairServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote;

public class FairController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Fair> tablec1;

    @FXML
    private TableColumn<Fair, String> typefair;

    @FXML
    private TableColumn<Fair, Integer> numberstand;

    @FXML
    private TableColumn<Fair, Float> fairprice;

    @FXML
    private TableColumn<Fair, String> fairname;

    @FXML
    private TableColumn<Fair, String> address;

    @FXML
    private TableColumn<Fair, Float> area;

    @FXML
    private JFXTextField fname;

    @FXML
    private JFXComboBox<Integer> snumber;
    
    @FXML
    private JFXComboBox<Float> pfair;

    @FXML
    private JFXButton b_submit;

    @FXML
    private JFXTextField tfair;

    @FXML
    private JFXComboBox<Float> tarea;

    @FXML
    private JFXComboBox<String> afair;

    @FXML
    private JFXButton bdelete;

    @FXML
    private JFXButton bupdate;

    @FXML
    void delete(ActionEvent event) {
    	

    }

    @FXML
    void submit_co(ActionEvent event) {
InitialContext ctx;
		
		if (!fname.getText().equals("") && !tfair.getText().equals("") && !tarea.getSelectionModel().getSelectedItem().equals("") && !pfair.getSelectionModel().getSelectedItem().equals("") && !snumber.getSelectionModel().getSelectedItem().equals("") && !afair.getSelectionModel().getSelectedItem().equals("")   ) {
			
			
			Fair f = new Fair(fname.getText(),snumber.getSelectionModel().getSelectedItem(),pfair.getSelectionModel().getSelectedItem(),tfair.getText(),afair.getSelectionModel().getSelectedItem(),tarea.getSelectionModel().getSelectedItem());


			//c.setUser(cin.getText());
			
			try {
				ctx = new InitialContext();
				FairServiceRemote proxy;
				
				proxy = (FairServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/FairService!tn.esprit.b3.esprit1718b3eventmanagement.services.FairServiceRemote");
			
				proxy.AddFairService(f);;
				
				
			} catch (Exception e) {
System.out.println(f);			}

			 System.out.println("done");	
				snumber.setPromptText("type");
				pfair.setPromptText("type");
				fname.clear();
			    tfair.clear();
			//ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(7));
			 //tablec.setItems(data);
			 
		} else {
			//erreur.setText("champs vide!!");
			
			 System.out.println("not done");
		

    }

    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tablec1 != null : "fx:id=\"tablec1\" was not injected: check your FXML file 'Fair.fxml'.";
        assert typefair != null : "fx:id=\"typefair\" was not injected: check your FXML file 'Fair.fxml'.";
        assert numberstand != null : "fx:id=\"numberstand\" was not injected: check your FXML file 'Fair.fxml'.";
        assert fairprice != null : "fx:id=\"fairprice\" was not injected: check your FXML file 'Fair.fxml'.";
        assert fairname != null : "fx:id=\"fairname\" was not injected: check your FXML file 'Fair.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'Fair.fxml'.";
        assert area != null : "fx:id=\"area\" was not injected: check your FXML file 'Fair.fxml'.";
        assert fname != null : "fx:id=\"fname\" was not injected: check your FXML file 'Fair.fxml'.";
        assert snumber != null : "fx:id=\"snumber\" was not injected: check your FXML file 'Fair.fxml'.";
        assert b_submit != null : "fx:id=\"b_submit\" was not injected: check your FXML file 'Fair.fxml'.";
        assert tfair != null : "fx:id=\"tfair\" was not injected: check your FXML file 'Fair.fxml'.";
        assert tarea != null : "fx:id=\"tarea\" was not injected: check your FXML file 'Fair.fxml'.";
        assert afair != null : "fx:id=\"afair\" was not injected: check your FXML file 'Fair.fxml'.";
        assert bdelete != null : "fx:id=\"bdelete\" was not injected: check your FXML file 'Fair.fxml'.";
        assert bupdate != null : "fx:id=\"bupdate\" was not injected: check your FXML file 'Fair.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> item = FXCollections.observableArrayList("v",
		        "b");
		ObservableList<Integer> items = FXCollections.observableArrayList(1,
		        2);
		List< Float> a = new ArrayList<>();
		ObservableList<Float> itemss = FXCollections.observableArrayList((float)1,
		        (float)2);
		List< Float> b = new ArrayList<>();
		ObservableList<Float> itemsss = FXCollections.observableArrayList((float)3,
		        (float)4);
		afair.setItems(item);
		snumber.setItems(items);
		tarea.setItems(itemss);
		pfair.setItems(itemsss);
		typefair.setCellValueFactory(new PropertyValueFactory<Fair,String>("event_type"));
		numberstand.setCellValueFactory(new PropertyValueFactory<Fair,Integer>("stand_number"));
		fairprice.setCellValueFactory(new PropertyValueFactory<Fair,Float>("fair_price"));
		fairname.setCellValueFactory(new PropertyValueFactory<Fair,String>("fair_name"));
		address.setCellValueFactory(new PropertyValueFactory<Fair,String>("address"));
		area.setCellValueFactory(new PropertyValueFactory<Fair,Float>("area"));
		
	try {
		InitialContext ctx;
		ctx = new InitialContext();
		FairServiceRemote proxy;
		proxy = (FairServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/FairService!tn.esprit.b3.esprit1718b3eventmanagement.services.FairServiceRemote");
	ObservableList<Fair> data = FXCollections.observableArrayList(proxy.FindAllFairService());
	tablec1.setItems(data);
		
	} catch (Exception e) {
System.out.println("ex");	
		
	}
		
		
	}
}

