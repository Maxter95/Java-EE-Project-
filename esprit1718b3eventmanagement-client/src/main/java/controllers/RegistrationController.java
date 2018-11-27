package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.controlsfx.control.Notifications;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Organizer;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote;
import gui.MainGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

public class RegistrationController implements Initializable {

	public static User userRegistre = null;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane pane;

	@FXML
	private Pane pane_page2;

	@FXML
	private JFXTextField tf_first_name;

	@FXML
	private JFXTextField tf_last_name;

	@FXML
	private JFXTextField tf_phone_numbre;

	@FXML
	private JFXTextField tf_position;

	@FXML
	private JFXTextField tf_address;

	@FXML
	private JFXTextArea tf_compant_description;

	@FXML
	private JFXButton btn_registre2;

	@FXML
	private Pane pane_page1;

	@FXML
	private JFXTextField tf_cin;

	@FXML
	private JFXTextField tf_username;

	@FXML
	private JFXTextField tf_email;

	@FXML
	private JFXPasswordField tf_password;

	@FXML
	private JFXPasswordField tf_repeat_pass;

	@FXML
	private JFXRadioButton radio_organizer;

	@FXML
	private ToggleGroup type;

	@FXML
	private JFXRadioButton radio_company;

	@FXML
	private JFXTextField tf_company_name;

	@FXML
	private StackPane myStackPane;

	@FXML
	private Label label_cin_ereur;

	@FXML
	private ImageView img_cin_ereur;

	@FXML
	private Label label_username_ereur;

	@FXML
	private ImageView img_username_ereur;

	@FXML
	private Label label_email_ereur;

	@FXML
	private ImageView img_email_ereur;

	@FXML
	private Label label_pass_ereur;

	@FXML
	private ImageView img_pass_ereur;

	@FXML
	private Label label_pass_ereur1;

	@FXML
	void back_menu(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Login.fxml"));
		MainGUI.stage.getScene().setRoot(root);

	}

	@FXML
	void registration(ActionEvent event) throws IOException {
		if (tf_cin.getText().equals("") || tf_username.getText().equals("") || tf_email.getText().equals("")
				|| tf_password.getText().equals("") || tf_repeat_pass.getText().equals("") ) {
			BoxBlur blur = new BoxBlur(3, 3, 3);
			JFXDialogLayout dialogContent = new JFXDialogLayout();
			dialogContent.setHeading(new Text("WARNING"));
			dialogContent.setBody(new Text("Please verify your information."));
			JFXButton close = new JFXButton("Close");
			close.setButtonType(JFXButton.ButtonType.RAISED);
			close.getStyleClass().add("loginBtn");
			dialogContent.setActions(close);
			JFXDialog dialog = new JFXDialog(myStackPane, dialogContent, JFXDialog.DialogTransition.CENTER);
			close.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent __) {
					dialog.close();
					pane.setEffect(null);
				}
			});
			dialog.show();
			pane.setEffect(blur);
		} else {

			String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
			Context ctx;

			// RadioButton selectedRadioButton = (RadioButton)
			// type.getSelectedToggle();
			// String toogleGroupValue = selectedRadioButton.getText();
			try {
				ctx = new InitialContext();

				UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
				proxy.addUser(ReternRole());
				System.out.println("add");
			} catch (Exception e) {
				System.out.println("ex");
			}
			pane_page1.setVisible(false);
			pane_page2.setVisible(true);
			
			
			Image icon_erreur = new Image("/images/logo_erreur.png");

			RequiredFieldValidator validator_first_name = new RequiredFieldValidator();
			validator_first_name.setMessage("No Input Given");
			validator_first_name.setIcon(new ImageView(icon_erreur));
			tf_first_name.getValidators().add(validator_first_name);
			tf_first_name.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						tf_first_name.validate();
					}
				}
			});

			RequiredFieldValidator validator_last_name = new RequiredFieldValidator();
			validator_last_name.setMessage("No Input Given");
			validator_last_name.setIcon(new ImageView(icon_erreur));
			tf_last_name.getValidators().add(validator_first_name);
			tf_last_name.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						tf_last_name.validate();
					}
				}
			});


			NumberValidator validator_phone = new NumberValidator();
			validator_phone.setMessage("Only number are supported");
			validator_phone.setIcon(new ImageView(icon_erreur));
			tf_phone_numbre.getValidators().add(validator_first_name);
			tf_phone_numbre.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						tf_phone_numbre.validate();
					}
				}
			});

			RequiredFieldValidator validator_position = new RequiredFieldValidator();
			validator_position.setMessage("No Input Given");
			validator_position.setIcon(new ImageView(icon_erreur));
			tf_position.getValidators().add(validator_first_name);
			tf_position.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						tf_position.validate();
					}
				}
			});

			RequiredFieldValidator validator_address = new RequiredFieldValidator();
			validator_address.setMessage("No Input Given");
			validator_address.setIcon(new ImageView(icon_erreur));
			tf_address.getValidators().add(validator_first_name);
			tf_address.focusedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (!newValue) {
						tf_address.validate();
					}
				}
			});

		}
	}

	@FXML
	void registrationPage2(ActionEvent event) throws IOException {
		if (tf_first_name.getText().equals("") || tf_last_name.getText().equals("")
				|| tf_phone_numbre.getText().equals("") || tf_position.getText().equals("")
				|| tf_address.getText().equals("")) {

			BoxBlur blur = new BoxBlur(3, 3, 3);
			JFXDialogLayout dialogContent = new JFXDialogLayout();
			dialogContent.setHeading(new Text("WARNING"));
			dialogContent.setBody(new Text("Please verify your information. "));
			JFXButton close = new JFXButton("Close");
			close.setButtonType(JFXButton.ButtonType.RAISED);
			close.getStyleClass().add("loginBtn");
			dialogContent.setActions(close);
			JFXDialog dialog = new JFXDialog(myStackPane, dialogContent, JFXDialog.DialogTransition.CENTER);
			close.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent __) {
					dialog.close();
					pane.setEffect(null);
				}
			});
			dialog.show();
			pane.setEffect(blur);

		} else {
			String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
			Context ctx;

			try {
				ctx = new InitialContext();
				UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
				User us = proxy.find(ReternRole().getCin());
				us.setFirst_name(tf_first_name.getText());
				us.setLast_name(tf_last_name.getText());
				us.setAddress(tf_address.getText());
				us.setPhone_number(Integer.parseInt(tf_phone_numbre.getText()));
				us.setAccount_date(new Date());
				us.setState_account("ACTIVE");
				proxy.update(us);
				userRegistre = us;
				System.out.println("add");

				try {
					String host = "smtp.gmail.com";
					String user = "manegementevent@gmail.com";
					String pass = "20778737";
					String to = us.getEmail();
					String from = "manegementevent@gmail.com";
					String subject = "Welcom";
					String messageText = "Registration Completed Successfully ";
					boolean sessionDebug = false;

					Properties props = System.getProperties();

					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.required", "true");

					java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
					Session mailSession = Session.getDefaultInstance(props, null);
					mailSession.setDebug(sessionDebug);
					Message msg = new MimeMessage(mailSession);
					msg.setFrom(new InternetAddress(from));
					InternetAddress[] address = { new InternetAddress(to) };
					msg.setRecipients(Message.RecipientType.TO, address);
					msg.setSubject(subject);
					msg.setSentDate(new Date());
					msg.setText(messageText);

					Transport transport = mailSession.getTransport("smtp");
					transport.connect(host, user, pass);
					transport.sendMessage(msg, msg.getAllRecipients());
					transport.close();
					System.out.println("message send successfully");

					Image img = new Image("/images/small_ticks.png");
					Notifications notificationRegistre = Notifications.create()
							.title("Registration Completed Successfully").text("You Are Welcom")
							.graphic(new ImageView(img)).hideAfter(Duration.seconds(5)).position(Pos.TOP_RIGHT)
							.onAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent event) {
									System.out.println("notification");
								}
							});
					notificationRegistre.darkStyle();
					notificationRegistre.show();

				} catch (Exception ex) {
					System.out.println(ex);
				}

			} catch (Exception e) {
				System.out.println("ex");
			}
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Login.fxml"));
			MainGUI.stage.getScene().setRoot(root);
		}
	}

	@FXML
	void companySelected(ActionEvent event) {
		tf_company_name.setPromptText("Position In Company");
		tf_company_name.setVisible(true);
	}

	@FXML
	void organizerSeleceted(ActionEvent event) {
		tf_company_name.setPromptText("Company Name");
		tf_company_name.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image icon_erreur = new Image("/images/logo_erreur.png");

		NumberValidator validator_cin = new NumberValidator();
		validator_cin.setMessage("Only number are supported");
		validator_cin.setIcon(new ImageView(icon_erreur));
		tf_cin.getValidators().add(validator_cin);
		tf_cin.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_cin.validate();
					label_cin_ereur.setVisible(false);
					img_cin_ereur.setVisible(false);
				}
				if (searchUserByCIN(Integer.parseInt(tf_cin.getText())) != null) {
					System.out.println(searchUserByCIN(Integer.parseInt(tf_cin.getText())));
					label_cin_ereur.setVisible(true);
					img_cin_ereur.setVisible(true);
				}
				if (searchUserByCIN(Integer.parseInt(tf_cin.getText())) == null) {
					label_cin_ereur.setVisible(false);
					img_cin_ereur.setVisible(false);
				}

			}
		});

		RequiredFieldValidator validatorUsername = new RequiredFieldValidator();
		validatorUsername.setMessage("No Input Given");
		validatorUsername.setIcon(new ImageView(icon_erreur));
		tf_username.getValidators().add(validatorUsername);
		tf_username.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_username.validate();
				}
				if (searchUserByLogin(tf_username.getText()) != null) {
					System.out.println(searchUserByLogin(tf_cin.getText()));
					label_username_ereur.setVisible(true);
					img_username_ereur.setVisible(true);
				}
				if (searchUserByLogin(tf_username.getText()) == null) {
					label_username_ereur.setVisible(false);
					img_username_ereur.setVisible(false);
				}
			}
		});

		RequiredFieldValidator validatoremail = new RequiredFieldValidator();
		validatoremail.setMessage("No Input Given");
		validatoremail.setIcon(new ImageView(icon_erreur));
		tf_email.getValidators().add(validatoremail);
		tf_email.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_email.validate();
				}
				if (searchUserByEmail(tf_email.getText()) != null) {
					System.out.println(searchUserByEmail(tf_cin.getText()));
					label_email_ereur.setVisible(true);
					img_email_ereur.setVisible(true);
				}
				if (searchUserByEmail(tf_email.getText()) == null) {
					label_email_ereur.setVisible(false);
					img_email_ereur.setVisible(false);
				}
			}
		});

		RequiredFieldValidator validator_password = new RequiredFieldValidator();
		validator_password.setMessage("No Input Given");
		validator_password.setIcon(new ImageView(icon_erreur));
		tf_password.getValidators().add(validator_password);
		tf_password.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_password.validate();
				}
			}
		});

		RequiredFieldValidator validator_username = new RequiredFieldValidator();
		validator_username.setMessage("No Input Given");
		validator_username.setIcon(new ImageView(icon_erreur));
		tf_repeat_pass.getValidators().add(validator_username);
		tf_repeat_pass.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_repeat_pass.validate();
					
				}
				
				
				
				if ((tf_repeat_pass.getText().equals(tf_password.getText()))&&(!tf_repeat_pass.getText().equals(""))&&(!tf_password.getText().equals(" "))) {
					label_pass_ereur.setVisible(false);
					label_pass_ereur1.setVisible(false);
					img_pass_ereur.setVisible(false);
					System.out.println("wi");
				}
				if ((!tf_repeat_pass.getText().equals(tf_password.getText()))&&(!tf_repeat_pass.getText().equals(""))&&(!tf_password.getText().equals(" "))) {
					label_pass_ereur.setVisible(true);
					label_pass_ereur1.setVisible(true);
					img_pass_ereur.setVisible(true);
					System.out.println("wi");
				}
			}
		});

		RequiredFieldValidator validator_name_company = new RequiredFieldValidator();
		validator_name_company.setMessage("No Input Given");
		validator_name_company.setIcon(new ImageView(icon_erreur));
		tf_company_name.getValidators().add(validator_name_company);
		tf_company_name.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_company_name.validate();
				}
			}
		});

		
	}

	public User ReternRole() {
		if (radio_company.isSelected()) {
			CompanyDirector dir = new CompanyDirector(Integer.parseInt(tf_cin.getText()), tf_username.getText(),
					tf_password.getText(), tf_email.getText(), tf_company_name.getText());
			return dir;
		}
		if (radio_organizer.isSelected()) {
			Organizer org = new Organizer(Integer.parseInt(tf_cin.getText()), tf_username.getText(),
					tf_password.getText(), tf_email.getText(), tf_company_name.getText());
			return org;
		}

		return null;
	}

	@FXML
	void close_app(MouseEvent event) {
		System.exit(0);
	}

	public User searchUserByCIN(int cin) {
		String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
		Context ctx;

		try {
			ctx = new InitialContext();

			UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
			User use = proxy.findById(cin);
			System.out.println(use);
			return use;
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

	public User searchUserByLogin(String Login) {
		String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
		Context ctx;

		try {
			ctx = new InitialContext();
			UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
			User use = proxy.findUserByLogin(Login);
			System.out.println(use);
			return use;
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

	public User searchUserByEmail(String email) {
		String jndiName = "esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
		Context ctx;

		try {
			ctx = new InitialContext();
			UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
			User use = proxy.findUserByEmail(email);
			System.out.println(use);
			return use;
		} catch (Exception e) {
			System.out.println();
		}
		return null;
	}

}
