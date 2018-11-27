package tn.esprit.b3.esprit1718b3eventmanagement.mBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;

import tn.esprit.b3.esprit1718b3eventmanagement.entities.Admin;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.CompanyDirector;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.Staff;
import tn.esprit.b3.esprit1718b3eventmanagement.entities.User;
import tn.esprit.b3.esprit1718b3eventmanagement.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private boolean isLogged = false;
	private User user = new User();
	@EJB
	private UserServiceLocal userServiceLocal;

	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServiceLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Staff) {
				isLogged = true;
				user = userLoggedIn;
				navigateTo = "/template/index3?faces-redirect=true";
			}
			if (userLoggedIn instanceof Admin) {
				isLogged = true;
				user = userLoggedIn;
				navigateTo = "/template/index2?faces-redirect=true";
			}
			if (userLoggedIn instanceof CompanyDirector) {
				isLogged = true;
				user = userLoggedIn;
				navigateTo = "/StandDetail?faces-redirect=true";
			}

			if (userLoggedIn instanceof tn.esprit.b3.esprit1718b3eventmanagement.entities.Client) {
				isLogged = true;
				user = userLoggedIn;
				navigateTo = "/template/productPage?faces-redirect=true";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez insérer un login et un mot de passe valide", ""));
			return "/login?faces-redirect=true";

		}
		return navigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

}
