package controllers;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;


public class OrganizerController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Text tf_username;

    @FXML
    private FontAwesomeIcon parametre;

    @FXML
    void back_menu(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		tf_username.setText(LoginController.user.getLogin()); 
	}
}
