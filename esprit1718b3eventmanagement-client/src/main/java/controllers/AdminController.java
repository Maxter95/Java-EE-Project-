package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class AdminController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private FontAwesomeIcon parametre;
    
    @FXML
    private Pane content_area;
    
    @FXML
    private Label stand;


    @FXML
      void menuParametre(MouseEvent event) {
    	FontAwesomeIcon log = new FontAwesomeIcon();
    	log.setIconName("BELL");
        JFXButton logout = new JFXButton("logout",log);
    	FontAwesomeIcon pro = new FontAwesomeIcon();
        pro.setIconName("USER");
        JFXButton profile = new JFXButton("Profil",pro);
        profile.getStyleClass().add("popupBtn");


     
            //JFXButton profile = new JFXButton("Profil");
            //JFXButton profil = new JFXButton("Profil");
            
            logout.getStyleClass().add("popupBtn");
            //profile.getStyleClass().add("popupBtn");
            //profil.getStyleClass().add("popupBtn");
            
         VBox vbox = new VBox(logout,profile);
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
        profile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent __) {
            	Parent fxml;
        		try {
        			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Profil.fxml"));

            	content_area.getChildren().removeAll();
            	content_area.getChildren().setAll(fxml);
        		} catch (Exception e) {
        			System.out.println(e);
        		}  	
				
            }
        });
        
        
    }
    
    @FXML
    void goToListUser(MouseEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/ListeUser.fxml"));

    	content_area.getChildren().removeAll();
    	content_area.getChildren().setAll(fxml);
		} catch (Exception e) {
			System.out.println("ex go to list");
		}
    }

    @FXML
    void Gotoholly(MouseEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Hollydays.fxml"));

    	content_area.getChildren().removeAll();
    	content_area.getChildren().setAll(fxml);
		} catch (Exception e) {
			System.out.println("ex go to holly");
		}
    }
    @FXML
    void GoToSal(MouseEvent event) {
    	Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Salaire.fxml"));

    	content_area.getChildren().removeAll();
    	content_area.getChildren().setAll(fxml);
		} catch (Exception e) {
			System.out.println("ex go to holly");
		}

    }
    @FXML
    void initialize() {
        assert content_area != null : "fx:id=\"content_area\" was not injected: check your FXML file 'AdminDashboard.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Parent fxml;
		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/ListeUser.fxml"));

    	content_area.getChildren().removeAll();
    	content_area.getChildren().setAll(fxml);
		} catch (Exception e) {
			System.out.println("ex go to list");
		}
		
		
	}
	@FXML
    void standad(MouseEvent event){
		Parent fxml;		try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/StandAdmin.fxml"));

    	content_area.getChildren().removeAll();
    	content_area.getChildren().setAll(fxml);
		} catch (Exception e) {
			System.out.println("ex go to holly");
		}

    }
}
