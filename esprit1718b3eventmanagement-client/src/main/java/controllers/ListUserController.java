package controllers;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote;
import javafx.scene.layout.FlowPane;


public class ListUserController implements Initializable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTreeTableView<User>  table_user;

    @FXML
    private FlowPane main;
    
    @FXML
    private JFXTextField tf_filter;
    

    @FXML
    void initialize() {
        assert main != null : "fx:id=\"main\" was not injected: check your FXML file 'ListeUser.fxml'.";

    }
    
    ObservableList<User> users;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		JFXTreeTableColumn<User, String> col_first_name = new JFXTreeTableColumn<>("First Name");
		col_first_name.setPrefWidth(100);
		col_first_name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                StringProperty first = new SimpleStringProperty(param.getValue().getValue().getFirst_name());
            	return first;
            }
        });
		
		JFXTreeTableColumn<User, String> col_last_name = new JFXTreeTableColumn<>("Last Name");
		col_last_name.setPrefWidth(100);
		col_last_name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                StringProperty last = new SimpleStringProperty(param.getValue().getValue().getLast_name());
            	return last;
            }
        });
		
		JFXTreeTableColumn<User, String> col_username = new JFXTreeTableColumn<>("Username");
		col_username.setPrefWidth(100);
		col_username.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                StringProperty username = new SimpleStringProperty(param.getValue().getValue().getLogin());
            	return username;
            }
        });
		
		JFXTreeTableColumn<User, String> col_role = new JFXTreeTableColumn<>("Role");
		col_role.setPrefWidth(100);
		col_role.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                StringProperty role = new SimpleStringProperty(param.getValue().getValue().getClass().getSimpleName());
            	return role;
            }
        });

        JFXTreeTableColumn<User, String> col_cin = new JFXTreeTableColumn<>("Natinal Id Card");
        col_cin.setPrefWidth(100);
        col_cin.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
            	int c =param.getValue().getValue().getCin();
                StringProperty cin = new SimpleStringProperty(Integer.toString(c));
            	return cin;
            }
        });
        
        JFXTreeTableColumn<User, String> col_phone = new JFXTreeTableColumn<>("Phone Number");
        col_phone.setPrefWidth(100);
        col_phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
            	int p =param.getValue().getValue().getPhone_number();
                StringProperty phone = new SimpleStringProperty(Integer.toString(p));
            	return phone;
            }
        });
        
		JFXTreeTableColumn<User, String> col_email = new JFXTreeTableColumn<>("Email");
		col_email.setPrefWidth(100);
		col_email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                StringProperty email = new SimpleStringProperty(param.getValue().getValue().getEmail());
            	return email;
            }
        });

        

        List<User> userr = null;
        String jndiName ="esprit1718b3eventmanagement-ear/esprit1718b3eventmanagement-service/UserService!tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceRemote";
    	Context ctx;
    	
			try {
				ctx = new InitialContext();
			
			UserServiceRemote proxy = (UserServiceRemote) ctx.lookup(jndiName);
			userr = proxy.getAllUser();
			} catch (Exception e) {
	    		System.out.println("ex"+userr);
			}
			users = FXCollections.observableArrayList(userr);
			System.out.println(userr);

        final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);
        System.out.println(userr);
        System.out.println(users);
        table_user.getColumns().setAll(col_username,col_first_name, col_last_name,col_cin,col_phone,col_email,col_role);
        table_user.setRoot(root);
        table_user.setShowRoot(false);
        table_user.getRoot().getChildren().add(new TreeItem (new User()));

	tf_filter.textProperty().addListener(new ChangeListener<String>() {
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			
				table_user.setPredicate(new Predicate<TreeItem<User>>() {
					
					@Override
					public boolean test(TreeItem<User> user) {
						Boolean flag=false;
						try {
					flag =user.getValue().getLast_name().contains(newValue);
					System.out.println("search");
				} catch (Exception e) {
						System.out.println(e);
				}
					
					return flag;		
					}
				});
	
			

		}
	});

        	
        
        
        
	}
	
}
