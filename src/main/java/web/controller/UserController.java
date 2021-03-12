package web.controller;

import java.util.HashSet;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domain.model.Phone;
import domain.model.User;
import domain.service.IUserService;
import domain.service.UserService;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController {

	private User user;
	private IUserService userService;

	public UserController() {
		this.user = new User();
		this.user.setPhones(new HashSet<Phone>());
		this.userService = new UserService();
	}

	public void save(User user) {
		try {
			User savedUser = this.userService.save(this.user);

			if (!Objects.nonNull(savedUser)) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Falha ao salvar o usuário"));
			}

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Sucesso."));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}
	}
}
