package web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import domain.service.IUserService;
import domain.service.UserService;

@ManagedBean(name = "loginController")
public class LoginController {

	private String email;

	private String password;

	public LoginController() {

	}

	public LoginController(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void authenticate() {
		IUserService userService = new UserService();
		if (userService.verifyEmailAndPassword(email, password)) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("pages/UserList.xhtml");
			} catch (Exception e) {
				System.out.println(e.getStackTrace().toString());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Erro ao carregar a página"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Não autenticou."));
		}
	}
}
