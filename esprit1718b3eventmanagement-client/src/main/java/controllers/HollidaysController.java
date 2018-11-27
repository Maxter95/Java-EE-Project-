package controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import rhservices.DemandeCongeServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Conge;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;

public class HollidaysController extends AnchorPane implements Initializable {

	@FXML
	private TableView<Conge> tablec;

	@FXML
	private TableColumn<Conge, Date> cdate;

	@FXML
	private TableColumn<Conge, String> ctype;

	@FXML
	private TableColumn<Conge, Integer> ccertif;

	@FXML
	private TableColumn<Conge, Integer> cdays;

	@FXML
	private TableColumn<Conge, String> cstatus;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO Auto-generated method stub
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			DemandeCongeServiceRemote proxy;

			proxy = (DemandeCongeServiceRemote) ctx.lookup(
					"/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

			cdate.setCellValueFactory(new PropertyValueFactory<Conge, Date>("date_co"));
			ctype.setCellValueFactory(new PropertyValueFactory<Conge, String>("type_co"));
			ccertif.setCellValueFactory(new PropertyValueFactory<Conge, Integer>("certificat"));
			cdays.setCellValueFactory(new PropertyValueFactory<Conge, Integer>("nbjrs_co"));
			cstatus.setCellValueFactory(new PropertyValueFactory<Conge, String>("status_co"));
			ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindAllDemandeConge());
			tablec.setItems(data);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}
	}

	@FXML
	void bttraiter(ActionEvent event) throws NamingException {
		InitialContext ctx;
		ctx = new InitialContext();
		DemandeCongeServiceRemote proxy;
		proxy = (DemandeCongeServiceRemote) ctx.lookup(
				"/esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/DemandeCongeService!rhservices.DemandeCongeServiceRemote");

		ObservableList<Conge> data2 = FXCollections.observableArrayList(proxy.FindAllDemandeConge());
		for (Conge str : data2) {
			int k;
			k = str.getCin();
			System.out.println(proxy.ChangeDisponibility(str.getCin()).getNbjrscp());
			System.out.println(k);
			if ((str.getType_co()).equals("Medical") && (str.getCertificat()).equals("Available")) {
				str.setStatus_co("Accepted");
				proxy.UpdateDemandeConge(str);
				// ObservableList<Conge> data =
				// FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				tablec.setItems(data2);

			} else if ((str.getType_co()).equals("Medical") && (str.getCertificat()).equals("Unavailable")) {
				str.setStatus_co("Rejected");
				proxy.UpdateDemandeConge(str);
				// ObservableList<Conge> data =
				// FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				tablec.setItems(data2);

			} else if ((str.getType_co()).equals("Normal") && (str.getCertificat()).equals("Available")
					&& (proxy.ChangeDisponibility(str.getCin()).getNbjrscp() + str.getNbjrs_co()) <= 30) {
				str.setStatus_co("Your request is confusing");
				proxy.UpdateDemandeConge(str);
				// ObservableList<Conge> data =
				// FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				tablec.setItems(data2);

			} else if ((str.getType_co()).equals("Normal")
					&& (proxy.ChangeDisponibility(str.getCin()).getNbjrscp() + str.getNbjrs_co()) <= 30) {
				str.setStatus_co("Accepted");
				Staff ss = proxy.ChangeDisponibility(str.getCin());
				ss.setNbjrscp((ss.getNbjrscp()) + (str.getNbjrs_co()));
				// proxy.ChangeDisponibility(str.getCin()).setNbjrscp((proxy.ChangeDisponibility(str.getCin()).getNbjrscp())+str.getNbjrs_co());
				proxy.UpdateStaff(ss);
				proxy.UpdateDemandeConge(str);
				// ObservableList<Conge> data =
				// FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				tablec.setItems(data2);

			} else if ((str.getType_co()).equals("Normal")
					&& (proxy.ChangeDisponibility(str.getCin()).getNbjrscp() + str.getNbjrs_co()) > 30) {
				str.setStatus_co("Rejected");
				proxy.UpdateDemandeConge(str);
				// ObservableList<Conge> data =
				// FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(LoginController.user.getCin()));
				tablec.setItems(data2);

			}

		}
		Notifications notification11 = Notifications.create().title("Done !")
				.text("All holiday requests have been checked").graphic(null).hideAfter(Duration.seconds(5))
				.position(Pos.BOTTOM_RIGHT);

		notification11.darkStyle();
		notification11.showWarning();
	}

}
