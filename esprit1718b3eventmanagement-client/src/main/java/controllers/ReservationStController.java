package controllers;

import java.beans.EventHandler;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import antlr.debug.Event;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.ReservationStand;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Stand;
import tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote;



public class ReservationStController implements Initializable {
	
	
	private List <ReservationStand> dt= null;
	int selectedValue =0;
	private ReservationStand rs = null ;
	
	

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
    	
    	
    	System.out.println(selectedValue+100);
    	String jndiName ="/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote";
    	Context ctx;
    	
		
		if (!stSize.getSelectionModel().getSelectedItem().equals("") && !starthour.getText().equals("") && !endhour.getText().equals("") && !cin.getText().equals("")  ) {
			
			Date d;
			
			if (dates.getValue() == null) {
				d = new Date(0);
				
			} else {
				LocalDate localDate = dates.getValue();
				System.out.println(localDate);
				//System.out.println(localDate);
				Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
				 localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
				 
				
				
				d = new Date(dates.getValue().getYear() - 1900, dates.getValue().getMonthValue() - 1,
						dates.getValue().getDayOfMonth());
				//System.out.println(d);
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				format.format(d.getDate());
				
				try {
					
					ctx = new InitialContext();
					ReservationServiceRemote proxy;
					System.out.println("a");
					proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
					System.out.println("b");
					rs=proxy.FindReservationLocalDayService(localDate);
					
					
					System.out.println("local date"+localDate);
					System.out.println("rs"+rs);
					//System.out.println(d) ;
					
					
				} catch (Exception e) {
		System.out.println(e);			
		}
				
			}
			System.out.println(selectedValue+"b");
			Stand stand = null;
				
			try {
				ctx = new InitialContext();
				StandServiceRemote proxy;
				proxy = (StandServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/StandService!tn.esprit.b3.esprit1718b3eventmanagement.services.StandServiceRemote");
				stand =proxy.getStandById(selectedValue);
				System.out.println(stand+"c") ;
			} catch (Exception e) {
System.out.println(e);			
}
			
			
			//ReservationStand r = new ReservationStand(5,Integer.parseInt(cin.getText()), d, Integer.parseInt(starthour.getText()), Integer.parseInt(endhour.getText()), stSize.getSelectionModel().getSelectedItem());
			System.out.println(stand);
			ReservationStand r = new ReservationStand(11, Integer.parseInt(cin.getText()), d, Integer.parseInt(starthour.getText()), Integer.parseInt(endhour.getText()), stSize.getSelectionModel().getSelectedItem(), LoginController.user, StandController.st);

			//c.setUser(cin.getText());
			r.setDay(d);
			System.out.println(rs);
			if (rs==null) {
			try {
				ctx = new InitialContext();
				ReservationServiceRemote proxy;
				proxy = (ReservationServiceRemote) ctx.lookup("/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote");
				proxy.AddReservationService(r);
				System.out.println("date mouch mrigla") ;
			} catch (Exception e) {
System.out.println(r);			
}} 

			 System.out.println("done");	
			    starthour.clear();
			    endhour.clear();
				stSize.setPromptText("type");
				dates.setPromptText("");
				cin.clear();
			
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

    }

	@Override
	public void initialize(URL location, ResourceBundle resources ) {
        System.out.println("d5al");
		String jndiName ="/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/ReservationService!tn.esprit.b3.esprit1718b3eventmanagement.services.ReservationServiceRemote";
    	Context ctx;
         
		try {
			ctx = new InitialContext();
		
		ReservationServiceRemote proxy = (ReservationServiceRemote) ctx.lookup(jndiName);
		ObservableList<ReservationStand> data = FXCollections.observableArrayList(proxy.FindReservationService(StandController.st.getId_s()));
		System.out.println(data+"abc");
		tablec.setItems(data);
		dt=data ;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
    		System.out.println(e);
    		System.out.println("abcd");
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
	 /*tablec.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
		    @Override
		    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
		        //Check whether item is selected and set value of selected item to Label
		        if(tablec.getSelectionModel().getSelectedItem() != null) 
		        {    
		           TableViewSelectionModel selectionModel = tablec.getSelectionModel();
		           ObservableList selectedCells = selectionModel.getSelectedCells();
		           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
		           Object val = tablePosition.getTableColumn().getCellData(newValue);
		          System.out.println(val);
		           //selectedValue=(int) val;
		          selectedValue=(int) val;
		         
		        }
		         }
		     });*/
	
	

}
