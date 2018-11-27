package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import rhservices.DemandeCongeServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class StaffController  implements Initializable {
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private FontAwesomeIcon parametre;
	    
	    @FXML
	    private Pane content_area;


	    @FXML
	      void menuParametre(MouseEvent event) {
	    	FontAwesomeIcon log = new FontAwesomeIcon();
	        log.setIconName("BELL");
	            JFXButton logout = new JFXButton("logout",log);
	            //JFXButton profile = new JFXButton("Profil");
	            //JFXButton profil = new JFXButton("Profil");
	            
	            logout.getStyleClass().add("popupBtn");
	            //profile.getStyleClass().add("popupBtn");
	            //profil.getStyleClass().add("popupBtn");
	            
	        VBox vbox = new VBox(logout);
	        JFXPopup popup = new JFXPopup(vbox);
	        popup.show(parametre,PopupVPosition.TOP,JFXPopup.PopupHPosition.LEFT,-60,5);
	        logout.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent __) {
	            	Parent home_page_parent;
					try {
					home_page_parent = FXMLLoader.load(getClass().getResource("/interfaces/Login.fxml"));
			        Scene home_page_scene = new Scene(home_page_parent);
			        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        
			        Stage new_stage = new Stage();        
			        app_stage.hide(); 
		            new_stage.setScene(home_page_scene);
		            new_stage.initStyle(StageStyle.TRANSPARENT);
		            new_stage.show();  
					} catch (Exception e) {
						System.out.println("ex login");
					}
	            }
	        });
	    }
	    
	   

	   
	    
	    @FXML
	    void HQuest(MouseEvent event) {
	    	Parent fxml;
			try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Hollidayrequest.fxml"));

	    	content_area.getChildren().removeAll();
	    	content_area.getChildren().setAll(fxml);
			} catch (Exception e) {
				System.out.println("ex go to holly");
			}

	    }

	    @FXML
	    void avai(MouseEvent event)throws NamingException {
	    	InitialContext ctx;
			ctx = new InitialContext();
			DemandeCongeServiceRemote proxy;
			proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");
			Staff ss = proxy.ChangeDisponibility(LoginController.user.getCin());
			ss.setDisponibilite(1);
			proxy.UpdateStaff(ss);
			Notifications notification11 = Notifications.create().title("Done !")
					.text("You are now available ").graphic(null).hideAfter(Duration.seconds(5))
					.position(Pos.BOTTOM_RIGHT);

			notification11.darkStyle();
			notification11.showWarning();
	    
	    }

	    

	    @FXML
	    void unavai(MouseEvent event) throws NamingException {
	    	InitialContext ctx;
			ctx = new InitialContext();
			DemandeCongeServiceRemote proxy;
			proxy = (DemandeCongeServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");
			Staff ss = proxy.ChangeDisponibility(LoginController.user.getCin());
			ss.setDisponibilite(0);
			proxy.UpdateStaff(ss);
			Notifications notification11 = Notifications.create().title("Done !")
					.text("You are now unavailable ").graphic(null).hideAfter(Duration.seconds(5))
					.position(Pos.BOTTOM_RIGHT);

			notification11.darkStyle();
			notification11.showWarning();

	    }

	    @FXML
	    void initialize() {
	        assert content_area != null : "fx:id=\"content_area\" was not injected: check your FXML file 'AdminDashboard.fxml'.";

	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
	}

