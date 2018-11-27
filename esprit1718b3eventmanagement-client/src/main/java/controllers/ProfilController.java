package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Admin;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Company;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.CompanyServiceRemote;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote;

public class ProfilController implements Initializable {

	Company company = null;
	private FileChooser filechooser;
	private File file;
	private Desktop desktop = Desktop.getDesktop();
	private Image image;
	private FileInputStream fis;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField tf_company_name;

	@FXML
	private JFXTextField tf_company_address;

	@FXML
	private JFXComboBox<String> cb_company_domain;

	@FXML
	private Pane pane_company;

	@FXML
	private JFXTextArea area_description_company;

	@FXML
	private Pane pane_user_info;

	@FXML
	private JFXTextField tf_first_name;

	@FXML
	private JFXTextField tf_last_name;

	@FXML
	private JFXTextField tf_phone;

	@FXML
	private JFXTextField tf_email;

	@FXML
	private JFXTextField tf_address;

	@FXML
	private Pane pane_profil_info;

	@FXML
	private JFXPasswordField tf_repeat_password;

	@FXML
	private JFXPasswordField tf_new_password;

	@FXML
	private JFXPasswordField tf_old_password;

	@FXML
	private JFXTextField tf_username;

	@FXML
	private Label label_company_name;

	@FXML
	private Label label_domain;

	@FXML
	private Label label_address_company;

	@FXML
	private Label label_first_name;

	@FXML
	private Label label_post;

	@FXML
	private Text label_edit;

	@FXML
	private ImageView image_profile;

	@FXML
	private HBox btn_edit_company;

    @FXML
    private JFXTextField tf_cin;

	@FXML
	void editCompany(MouseEvent event) {
		if (LoginController.user instanceof CompanyDirector) {

			if (!pane_company.isVisible()) {
				pane_profil_info.setVisible(false);
				pane_user_info.setVisible(false);
				pane_company.setVisible(true);
			} else {
				pane_profil_info.setVisible(false);
				pane_user_info.setVisible(false);
				pane_company.setVisible(false);
			}
		} else if (LoginController.user instanceof Admin) {
			tf_old_password.setVisible(false);
			pane_profil_info.setVisible(true);
			pane_user_info.setVisible(true);
		}

	}

	@FXML
	void editProfil(MouseEvent event) {
		tf_old_password.setVisible(true);
		if (LoginController.user instanceof CompanyDirector) {
			if (!(pane_profil_info.isVisible() && pane_user_info.isVisible())) {
				pane_profil_info.setVisible(true);
				pane_user_info.setVisible(true);
				pane_company.setVisible(false);
			} else {
				pane_profil_info.setVisible(false);
				pane_user_info.setVisible(false);
				pane_company.setVisible(false);
			}
		} else if (LoginController.user instanceof Admin) {
			pane_profil_info.setVisible(true);
		}

	}

	@FXML
	void saveChange(ActionEvent event) {

		if (LoginController.user instanceof CompanyDirector) {

			String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
			Context ctx;

			// RadioButton selectedRadioButton = (RadioButton)
			// type.getSelectedToggle();
			// String toogleGroupValue = selectedRadioButton.getText();
			try {
				ctx = new InitialContext();

				UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
				proxy.updateUser(ReternRole());
				System.out.println("update user");
				LoginController.user = ReternRole();
			} catch (Exception e) {
				System.out.println("ex");
			}
			clean();
			Refresh();
		}
		else if (LoginController.user instanceof Admin){
			String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
			Context ctx;

			// RadioButton selectedRadioButton = (RadioButton)
			// type.getSelectedToggle();
			// String toogleGroupValue = selectedRadioButton.getText();
			try {
				ctx = new InitialContext();

				UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
				Staff staff2= new Staff(Integer.parseInt(tf_cin.getText()), tf_first_name.getText(), tf_username.getText(), tf_repeat_password.getText(), tf_email.getText(), tf_last_name.getText(),Integer.parseInt(tf_phone.getText()) , tf_address.getText(), new Date(), "ACTIVE");
				
				proxy.addUser(staff2);
				System.out.println("add Staff");
				//LoginController.user = ReternRole();
			} catch (Exception e) {
				System.out.println("ex");
			}
			clean();
			Refresh();
		}

	}

	@FXML
	void saveChangeCompany(ActionEvent event) {

		String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/CompanyService!tn.esprit.b3.esprit1718b3eventmanagement.services.CompanyServiceRemote";
		Context ctx;

		try {
			ctx = new InitialContext();
			CompanyDirector company_director = (CompanyDirector) LoginController.user;
			CompanyServiceRemote proxy = (CompanyServiceRemote) ctx.lookup(jndiName);
			Company new_company = new Company(company.getId_c(), tf_company_name.getText(),
					area_description_company.getText(), cb_company_domain.getValue(), tf_company_address.getText(),
					company_director);
			proxy.update(new_company);
			System.out.println(company + " update");
		} catch (Exception e) {
			System.out.println("ex");
		}
		clean();
		Refresh();
	}

	@FXML
	void Browse(ActionEvent event) {
		filechooser = new FileChooser();
		file = filechooser.showOpenDialog(new Stage());
		if (file != null) {
			image = new Image(file.toURI().toString(), 100, 150, true, true);
			image_profile.setImage(image);
		}
	}

	@FXML
	void initialize() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Refresh();
	}

	public User ReternRole() throws FileNotFoundException, SQLException {

		// fis = new FileInputStream(file);
		// BinaryStream b ;

		// Blob ba = null ;
		// ba.setBinaryStream(file.length());
		CompanyDirector dir = new CompanyDirector(LoginController.user.getCin(), tf_first_name.getText(),
				tf_username.getText(), tf_repeat_password.getText(), tf_email.getText(), tf_last_name.getText(),
				Integer.parseInt(tf_phone.getText()), tf_address.getText());
		dir.setModified_date(new Date());
		return dir;

	}

	public void Refresh() {

		ObservableList<String> items_domain = FXCollections.observableArrayList("IT", "yosri");
		cb_company_domain.setItems(items_domain);
		label_first_name.setText(LoginController.user.getFirst_name() + " " + LoginController.user.getLast_name());

		if (LoginController.user instanceof CompanyDirector) {

			CompanyDirector company_director = (CompanyDirector) LoginController.user;
			label_post.setText(company_director.getPosition());

			String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/CompanyService!tn.esprit.b3.esprit1718b3eventmanagement.services.CompanyServiceRemote";
			Context ctx;

			try {
				ctx = new InitialContext();

				CompanyServiceRemote proxy = (CompanyServiceRemote) ctx.lookup(jndiName);
				company = proxy.findCompanyByDirector(company_director);
				System.out.println(company_director + "ok");
			} catch (Exception e) {
				System.out.println(e);
			}

			label_company_name.setText(company.getName_company());
			label_address_company.setText(company.getAddress_company());
			label_domain.setText(company.getDomain_company());

			pane_company.setVisible(false);
			pane_profil_info.setVisible(false);
			pane_user_info.setVisible(false);
			label_edit.setText("Edit Company");

		} else if (LoginController.user instanceof Admin) {
			label_company_name.setText(LoginController.user.getClass().getSimpleName());
			label_address_company.setVisible(false);
			label_domain.setVisible(false);
			// btn_edit_company.setVisible(false);
			label_edit.setText("Add new Staff");

		}
	}

	public void clean() {
		tf_address.clear();
		tf_company_address.clear();
		tf_company_name.clear();
		tf_email.clear();
		tf_first_name.clear();
		tf_last_name.clear();
		tf_new_password.clear();
		tf_old_password.clear();
		tf_phone.clear();
		tf_repeat_password.clear();
		tf_username.clear();
		area_description_company.clear();
		cb_company_domain.setValue("");
	}

}
