package controllers;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.teknikindustries.bulksms.SMS;

import gui.MainGUI;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote;

public class ForgetPassewordController implements Initializable {

	int code =0;
	int newpass=0;
	User u = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private Pane Pane_confirmation;

    @FXML
    private JFXTextField tf_code;

    @FXML
    private Pane pane1;

    @FXML
    private JFXTextField tf_cin;

    @FXML
    private JFXTextField tf_email;

    @FXML
    private JFXTextField tf_phone;
    
    @FXML
    private ImageView img_code_erreur;

    @FXML
    private Label label_erreur_code;


    @FXML
    void ConfirmFormReset(ActionEvent event) {
    	
    	String jndiName ="esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
    	Context ctx;

			try {
				ctx = new InitialContext();
			
			UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
			
			u = proxy.find(Integer.parseInt(tf_cin.getText()));
			} catch (Exception e) {
				System.out.println("ex");
			}

			if (u!= null){
				if(((tf_email.getText()==u.getEmail())||(tf_email.getText().equals(u.getEmail())))&&( (Integer.parseInt(tf_phone.getText())==u.getPhone_number())||(tf_phone.getText().equals(u.getPhone_number())))){
			    	Random r = new Random();
			    	code = 2458 + r.nextInt(9999 - 2458);
					SMS sms = new SMS();
					sms.SendSMS("fadhellouati", "20778737", "Please do enter the following code :", "+216"+u.getPhone_number(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
					System.out.println(code);
					System.out.println("send sms");
					pane1.setVisible(false);
					Pane_confirmation.setVisible(true);
					Image icon_erreur = new Image("/images/logo_erreur.png");
					NumberValidator validator_code = new NumberValidator();
					validator_code.setMessage("Only number are supported");
					validator_code.setIcon(new ImageView(icon_erreur));
					tf_code.getValidators().add(validator_code);
					tf_code.focusedProperty().addListener(new ChangeListener<Boolean>() {
						@Override
						public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
							if (!newValue) {
								tf_code.validate();
							}
							if(!tf_code.getText().equals(code)&& !tf_code.getText().equals("")){
								label_erreur_code.setVisible(false);
								img_code_erreur.setVisible(false);
							}
						}
					});
				
				}
				
			}
    }

    @FXML
    void ResetPassword(ActionEvent event) {
    	if ((tf_code.getText().equals(code))||Integer.parseInt(tf_code.getText())==code){
	    	Random r = new Random();
	    	newpass = 2458 + r.nextInt(9999 - 2458);
	    	String jndiName ="esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
	    	Context ctx;
    		try{
	            String host ="smtp.gmail.com" ;
	            String user = "manegementevent@gmail.com";
	            String pass = "20778737";
	            String to = u.getEmail();
	            String from = "manegementevent@gmail.com";
	            String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
	            String messageText = "Your account is reset Your can connect with your email and password="+newpass+"/n"+"This new parametre is valable only 3 day";
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
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);

	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();

	           System.out.println("Your account has been refreshed , You can now connect with your current email and the following password:"+newpass);
	          
	           ctx = new InitialContext();				
				UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
				String newpassword = String.valueOf(newpass);
				u.setPassword(newpassword);
				u.setLogin(u.getEmail());
				u.setModified_date(new Date());
				proxy.update(u);
				System.out.println("add");
    		
    		
    		}
	           catch (Exception e) {
	        	   System.out.println(e);
			}
    		
    		
    		
    		
    	}

    }

    @FXML
    void back_menu(MouseEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Login.fxml"));
    	MainGUI.stage.getScene().setRoot(root);
    }

    @FXML
    void close_app(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert Pane_confirmation != null : "fx:id=\"Pane_confirmation\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert tf_code != null : "fx:id=\"tf_code\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert tf_cin != null : "fx:id=\"tf_cin\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert tf_email != null : "fx:id=\"tf_email\" was not injected: check your FXML file 'ForgetPassword.fxml'.";
        assert tf_phone != null : "fx:id=\"tf_phone\" was not injected: check your FXML file 'ForgetPassword.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pane1.setVisible(true);
		Pane_confirmation.setVisible(false);
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
				}
			}
		});
		
		NumberValidator validator_phone = new NumberValidator();
		validator_phone.setMessage("Only number are supported");
		validator_phone.setIcon(new ImageView(icon_erreur));
		tf_phone.getValidators().add(validator_phone);
		tf_phone.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					tf_phone.validate();
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
			}
		});
		
	}
}
