package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import rhservices.DemandeCongeServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;

public class SalaireController extends AnchorPane implements Initializable {
	@FXML
	private JFXTextField Tfilter;
	@FXML
	private TableView<Staff> Cstaff;

	@FXML
	private TableColumn<Staff, Integer> Ccin;

	@FXML
	private TableColumn<Staff, Integer> Cyrsofw;
	@FXML
    private TableColumn<Staff, String> Cfname;

    @FXML
    private TableColumn<Staff, String> Clname;

	@FXML
	private TableColumn<Staff, Integer> CsalaryIn;

	@FXML
	private TableColumn<Staff, Float> Csalary;

	@FXML
	private JFXButton Bsalary;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			DemandeCongeServiceRemote proxy;

			proxy = (DemandeCongeServiceRemote) ctx.lookup(
					"/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

			Ccin.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("cin"));
			Cyrsofw.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("yearswork"));
			CsalaryIn.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("increase"));
			Csalary.setCellValueFactory(new PropertyValueFactory<Staff, Float>("salary_staff"));
			Cfname.setCellValueFactory(new PropertyValueFactory<Staff, String>("first_name"));
			Clname.setCellValueFactory(new PropertyValueFactory<Staff, String>("last_name"));

			ObservableList<Staff> data = FXCollections.observableArrayList(proxy.FindAllStaff());
			Cstaff.setItems(data);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}
		Tfilter.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
					filter(oldValue,newValue);
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             
            }
       
   }); 

		

	}

	@FXML
	void Salaryy(ActionEvent event) throws NamingException {
		InitialContext ctx;
		ctx = new InitialContext();
		DemandeCongeServiceRemote proxy;
		proxy = (DemandeCongeServiceRemote) ctx.lookup(
				"/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

		ObservableList<Staff> data3 = FXCollections.observableArrayList(proxy.FindAllStaff());
		for (Staff str : data3) {
			if (str.getIncrease() < str.getYearswork()) {
				Staff ss = proxy.ChangeDisponibility(str.getCin());
				ss.setSalary_staff((((str.getYearswork()) - (str.getIncrease())) * 2 * (str.getSalary_staff() / 100))
						+ str.getSalary_staff());
				ss.setIncrease(str.getIncrease() + ((str.getYearswork()) - (str.getIncrease())));
				proxy.UpdateStaff(ss);
				ObservableList<Staff> data = FXCollections.observableArrayList(proxy.FindAllStaff());
				Cstaff.setItems(data);
			}

		}
		Notifications notification11 = Notifications.create()
                .title("Done !")
                .text("All salary have been checked")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);

        notification11.darkStyle();
        notification11.showWarning();

	}
	@FXML
    public void filter(String oldValue,String newValue)throws NamingException{
		InitialContext ctx;
		ctx = new InitialContext();
		DemandeCongeServiceRemote proxy;
		proxy = (DemandeCongeServiceRemote) ctx.lookup(
				"/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");


		ObservableList<Staff> data = FXCollections.observableArrayList(proxy.FindAllStaff());
		if (newValue==null ||oldValue.length()==newValue.length()||oldValue==null){
			Cstaff.setItems(data);
        }
        else{
            ObservableList<Staff> filter=FXCollections.observableArrayList();
            for(Staff h:data){
                if (h.getFirst_name().contains(newValue) || h.getLast_name().contains(newValue))
                filter.add(h);
            }
            Cstaff.setItems(filter);
        }
        

	}}
