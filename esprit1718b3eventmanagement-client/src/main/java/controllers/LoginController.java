package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;



import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Admin;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Organizer;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote;

public class LoginController implements Initializable {

	static User user;
	// public Stage stage;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private StackPane myStackPane;

	@FXML
	private Pane rootPane;

	@FXML
	private Pane content_area;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton btn_login;

	@FXML
	private Label label_correct;

	@FXML
	private ImageView img_correct;

	@FXML
	private ImageView image_splash;

	@FXML
	void login(ActionEvent event) throws IOException {

		String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
		Context ctx;

		try {
			ctx = new InitialContext();

			UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
			user = proxy.login(username.getText(), password.getText());
			RegistrationController.userRegistre = user;
			System.out.println(user + username.getText() + password.getText());
		} catch (Exception e) {
			System.out.println("ex" + user);
		}
		if (user != null && user.getState_account().equals("ACTIVE")) {
			System.out.println(user);
			Date date = new Date();
			System.out.println((date.getTime() - user.getAccount_date().getTime()) / (24 * 60 * 60 * 1000));

			if (user instanceof Admin) {

				Parent home_page_parent = FXMLLoader.load(getClass().getResource("/interfaces/AdminDashboard.fxml"));
				Scene home_page_scene = new Scene(home_page_parent);
				Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Stage new_stage = new Stage();
				app_stage.hide();
				new_stage.setScene(home_page_scene);
				new_stage.initStyle(StageStyle.DECORATED);
				new_stage.show();
				System.out.println("admin");
			}

			else if (user instanceof Organizer) {
				Parent home_page_parent = FXMLLoader
						.load(getClass().getResource("/interfaces/OrganizerDashboard.fxml"));
				Scene home_page_scene = new Scene(home_page_parent);
				Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Stage new_stage = new Stage();
				app_stage.hide();
				new_stage.setScene(home_page_scene);
				new_stage.initStyle(StageStyle.DECORATED);
				new_stage.show();
				System.out.println("organizer");
			} else if (user instanceof Staff) {
				Parent home_page_parent = FXMLLoader.load(getClass().getResource("/interfaces/StaffDashboard.fxml"));
				Scene home_page_scene = new Scene(home_page_parent);
				Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Stage new_stage = new Stage();
				app_stage.hide();
				new_stage.setScene(home_page_scene);
				new_stage.initStyle(StageStyle.DECORATED);
				new_stage.show();
				System.out.println("Staff");
			} else if (user instanceof CompanyDirector) {
				Parent home_page_parent = FXMLLoader.load(getClass().getResource("/interfaces/CompanyDashboard.fxml"));
				Scene home_page_scene = new Scene(home_page_parent);
				Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Stage new_stage = new Stage();
				app_stage.hide();
				new_stage.setScene(home_page_scene);
				new_stage.initStyle(StageStyle.DECORATED);
				new_stage.show();
				System.out.println("Company");
			} else {
				username.clear();
				password.clear();
				BoxBlur blur = new BoxBlur(3, 3, 3);

				JFXDialogLayout dialogContent = new JFXDialogLayout();
				dialogContent.setHeading(new Text("WARNING"));
				dialogContent.setBody(new Text("You Entered Wrong Username Or Password."));
				JFXButton close = new JFXButton("Close");
				close.setButtonType(JFXButton.ButtonType.RAISED);
				close.getStyleClass().add("loginBtn");
				dialogContent.setActions(close);
				JFXDialog dialog = new JFXDialog(myStackPane, dialogContent, JFXDialog.DialogTransition.CENTER);
				close.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent __) {
						dialog.close();
						rootPane.setEffect(null);
					}
				});
				dialog.show();
				rootPane.setEffect(blur);
				System.out.println("Login or passeword incorrect");
			}
		} else {
			username.clear();
			password.clear();
			BoxBlur blur = new BoxBlur(3, 3, 3);

			JFXDialogLayout dialogContent = new JFXDialogLayout();
			dialogContent.setHeading(new Text("WARNING"));
			dialogContent.setBody(new Text("You Entered Wrong Username Or Password."));
			JFXButton close = new JFXButton("Close");
			close.setButtonType(JFXButton.ButtonType.RAISED);
			close.getStyleClass().add("loginBtn");
			dialogContent.setActions(close);
			JFXDialog dialog = new JFXDialog(myStackPane, dialogContent, JFXDialog.DialogTransition.CENTER);
			close.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent __) {
					dialog.close();
					rootPane.setEffect(null);
				}
			});
			dialog.show();		
			rootPane.setEffect(blur);
		}

	}

	@FXML
	void registration(MouseEvent event) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("/interfaces/Registration.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(fxml);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadSplashScreen();
		if (RegistrationController.userRegistre != null) {
			password.setText(RegistrationController.userRegistre.getPassword());
			username.setText(RegistrationController.userRegistre.getLogin());
		}

		
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setMessage("No Input Given");
		Image icon_erreur = new Image("/images/logo_erreur.png");
		validator.setIcon(new ImageView(icon_erreur));

		// ValidationSupport validation = new ValidationSupport();
		// validation.registerValidator(username,
		// Validator.createEmptyValidator(""));
		
		username.getValidators().add(validator);
		username.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					username.validate();
				}
			}
		});
		
		RequiredFieldValidator validatorpass = new RequiredFieldValidator();
		validatorpass.setMessage("No Input Given");
		validatorpass.setIcon(new ImageView(icon_erreur));
		
		password.getValidators().add(validatorpass);
		
		password.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					password.validate();
				}
			}
		});

	}

	@FXML
	void initialize() {
		assert myStackPane != null : "fx:id=\"myStackPane\" was not injected: check your FXML file 'Login.fxml'.";
		assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'Login.fxml'.";
		assert content_area != null : "fx:id=\"content_area\" was not injected: check your FXML file 'Login.fxml'.";
		assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Login.fxml'.";
		assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";

	}

	private void loadSplashScreen() {

		Image image1 = new Image("/images/Picture1.png");
		Image image2 = new Image("/images/Picture2.png");
		Image image3 = new Image("/images/Picture3.png");
		Image image4 = new Image("/images/Picture4.png");
		Image image5 = new Image("/images/Picture2.png");
		image_splash.setImage(image1);
		FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), image_splash);
		fadeIn.setFromValue(0);
		fadeIn.setToValue(1);
		fadeIn.setCycleCount(1);

		FadeTransition fadeOut = new FadeTransition(Duration.seconds(5), image_splash);
		fadeOut.setFromValue(1);
		fadeOut.setToValue(0);
		fadeOut.setCycleCount(1);

		fadeIn.play();

		fadeIn.setOnFinished((e) -> {
			fadeOut.play();
		});

		fadeOut.setOnFinished((e) -> {
			if (image_splash.getImage() == image1) {
				image_splash.setImage(image2);
			} else if (image_splash.getImage() == image2) {
				image_splash.setImage(image3);
			} else if (image_splash.getImage() == image3) {
				image_splash.setImage(image4);
			} else if (image_splash.getImage() == image4) {
				image_splash.setImage(image5);
			} else {
				image_splash.setImage(image1);
			}
			fadeIn.play();
		});

	}

	@FXML
	void ForgetPassword(MouseEvent event) throws IOException {
		Parent fxml = FXMLLoader.load(getClass().getResource("/interfaces/ForgetPassword.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(fxml);
	}

	@FXML
	void close_app(MouseEvent event) {
		System.exit(0);
	}

}
