package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote;

public class StandController implements Initializable {

    
	public static Stand st = null ;
	
	float selectedValue = 0 ;
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
    private JFXComboBox<String> typestand;

    @FXML
    private JFXTextField description;

    @FXML
    private JFXComboBox<Float> procestand;

    @FXML
    private JFXButton sdelete;

    @FXML
    private JFXButton supdate;

    @FXML
    private JFXButton ssubmit;

    @FXML
    void delete(ActionEvent event) {
    	InitialContext ctx;
		try {
			ctx = new InitialContext();
			StandServiceRemote proxy;
			proxy = (StandServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");

			Integer selected = tablec.getSelectionModel().getSelectedIndex();

			if (tablec.getSelectionModel().isSelected(selected)) {
				proxy.DeleteStandService(tablec.getItems().get(selected));
				tablec.getItems().remove(tablec.getItems().get(selected));
				ObservableList<Stand> data = FXCollections.observableArrayList(proxy.FindStandService(7));
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
    	InitialContext ctx;
		
		if (!description.getText().equals("") && !procestand.getSelectionModel().getSelectedItem().equals("") && !typestand.getSelectionModel().getSelectedItem().equals("")    ) {
			
			
			Stand s = new Stand(description.getText(),procestand.getSelectionModel().getSelectedItem(),typestand.getSelectionModel().getSelectedItem());


			//c.setUser(cin.getText());
			
			try {
				ctx = new InitialContext();
				StandServiceRemote proxy;
				
				proxy = (StandServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");
			
				proxy.AddStandService(s);
				
				
			} catch (Exception e) {
System.out.println(s);			}

			 System.out.println("done");	
				typestand.setPromptText("type");
				procestand.setPromptText("type");
				description.clear();
			
			//ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(7));
			 //tablec.setItems(data);
			 
		} else {
			//erreur.setText("champs vide!!");
			
			 System.out.println("not done");
		

    }
    
    	

    }

    @FXML
    void update(ActionEvent event) throws NamingException {
    	try {
			System.out.println("1");
			InitialContext ctx = new InitialContext();
			StandServiceRemote proxy;
			proxy = (StandServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");
			List<Stand> list = proxy.FindAllStandService();
		} catch (Exception e) {
System.out.println("ex");			}
    	
    	
    	
    	Integer selected = tablec.getSelectionModel().getSelectedIndex();
		InitialContext ctx;
		ctx = new InitialContext();
		StandServiceRemote proxy;
		proxy = (StandServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");
      if (tablec.getSelectionModel().isSelected(selected)) {

			Stand s = (Stand) tablec.getItems().get(selected);
			s.setDescription_stand(description.getText());
			s.setType_stand(typestand.getSelectionModel().getSelectedItem());
			s.setPrice_stand(procestand.getSelectionModel().getSelectedItem());
			
			
			

			
		
			proxy.UpdateStandService(s);
			description.clear();
			procestand.setPromptText("Type");
			typestand.setPromptText("Type");
			

		}
      ObservableList<Stand> data = FXCollections.observableArrayList(proxy.FindStandService(7));
		 tablec.setItems(data);

    	

    }

    @FXML
    void initialize() {
       /* assert tablec != null : "fx:id=\"tablec\" was not injected: check your FXML file 'Stand.fxml'.";
        assert tstand != null : "fx:id=\"tstand\" was not injected: check your FXML file 'Stand.fxml'.";
        assert pstand != null : "fx:id=\"pstand\" was not injected: check your FXML file 'Stand.fxml'.";
        assert dstand != null : "fx:id=\"dstand\" was not injected: check your FXML file 'Stand.fxml'.";
        assert typestand != null : "fx:id=\"typestand\" was not injected: check your FXML file 'Stand.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'Stand.fxml'.";
        assert procestand != null : "fx:id=\"procestand\" was not injected: check your FXML file 'Stand.fxml'.";
        assert sdelete != null : "fx:id=\"sdelete\" was not injected: check your FXML file 'Stand.fxml'.";
        assert supdate != null : "fx:id=\"supdate\" was not injected: check your FXML file 'Stand.fxml'.";
        assert ssubmit != null : "fx:id=\"ssubmit\" was not injected: check your FXML file 'Stand.fxml'.";
*/
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Stage stage=null;
		ObservableList<String> items = FXCollections.observableArrayList("v",
		        "b");
		List< Float> a = new ArrayList<>();
		
		ObservableList<Float> itemss = FXCollections.observableArrayList((float)1,(float)2);
		
		typestand.setItems(items);
		procestand.setItems(itemss);
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
		
	 tablec.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
		    @Override
		    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
		        //Check whether item is selected and set value of selected item to Label
		        if(tablec.getSelectionModel().getSelectedItem() != null) 
		        {    
		           TableViewSelectionModel selectionModel = tablec.getSelectionModel();
		           ObservableList selectedCells = selectionModel.getSelectedCells();
		           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
		           Object val = tablePosition.getTableColumn().getCellData(newValue);
		           
		           
		           selectedValue=(float) val;
		           System.out.println(selectedValue);
		           try {
						 Stand stand=new Stand() ;
		        	   InitialContext ctxx = new InitialContext();
						StandServiceRemote proxy;
						proxy = (StandServiceRemote) ctxx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");
						stand =proxy.getStandById((int) selectedValue);
						st=stand ;
						
						System.out.println(stand+"a") ;
						System.out.println(st+"b");
						
						
						 
						if (stand instanceof Stand ) {
							Parent home_page_stand = FXMLLoader.load(getClass().getResource("/interfaces/ReservationSt.fxml"));
					        Scene home_page_scene = new Scene(home_page_stand);
					        Stage PrimaryStage = new Stage();
					        PrimaryStage.setScene(home_page_scene);
					        PrimaryStage.show(); 
					        System.out.println(stand+"c");
					        System.out.println(st+"d");
					        
					        
						}
					} catch (Exception e) {
		System.out.println(e);			
		}
		         
		        }
		         }
		     });
		
	}
    
}
