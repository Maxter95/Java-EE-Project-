package controllers;
import static controllers.MenuStuffController.rootS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class VboxStaffController  implements Initializable {
	  
    @FXML
    private JFXButton btnAff;

    @FXML
    private JFXButton btnAjou;

    @FXML
    private JFXButton modisuppp;

    @FXML
    private JFXButton btnModi;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    // public void ajou(ActionEvent event) throws IOException {
        
      
    
 //AnchorPane pane  = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//FXML1Controller.rootS.getChildren().clear();
 // FXML1Controller.rootS.getChildren().add(pane);
  
  //  }
  //   public void modisupp(ActionEvent event) throws IOException {
        
      
    
// AnchorPane pane  = FXMLLoader.load(getClass().getResource("FXMLModifSupp.fxml"));
// FXML1Controller.rootS.getChildren().clear();
 // FXML1Controller.rootS.getChildren().add(pane);
  
 //   }
   @FXML
  private void ExitAction(ActionEvent event) {
      Stage stage = (Stage) rootS.getScene().getWindow();
stage.close(); 
   }
   // public void aff(ActionEvent event) throws IOException {
        
      
    
// AnchorPane pane  = FXMLLoader.load(getClass().getResource("reservation_hebergement.fxml"));
 //FXML1Controller.rootS.getChildren().clear();
  //FXML1Controller.rootS.getChildren().add(pane);
  
  //  }

}
