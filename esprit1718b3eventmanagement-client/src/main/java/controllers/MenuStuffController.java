package controllers;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

	public class MenuStuffController extends AnchorPane implements Initializable{
    @FXML
    private AnchorPane proilePANE;
    
public static AnchorPane rootS;
    @FXML
    private JFXHamburger menuBTN;

    @FXML
    private ImageView imageLogo;

    @FXML
    private JFXDrawer menu;

    @FXML
    private TitledPane gr;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
         rootS = proilePANE;
         
         
         
          try {
            VBox box = FXMLLoader.load(getClass().getResource("/interfaces/VboxStaff.fxml"));
            menu.setSidePane(box);
        } catch (IOException ex) {
          
        }
                  HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menuBTN);
        transition.setRate(-1);
        menuBTN.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(menu.isShown())
            {
                menu.close();
            }else
                menu.open();
        });
        // TODO
        
    }   
    
     @FXML
   private void exitMenu() {

          if(menu.isShown())
            {
                menu.close();
            }
        }
    
       @FXML
   private void startMenu() {

          
                menu.open();
            
        }
   
}
