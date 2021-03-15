package web.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domain.model.User;
import domain.service.IUserService;
import domain.service.UserService;

@ManagedBean(name = "userListController")
@SessionScoped
public class UserListController {
	private User user;
	private IUserService userService;
	private List<User> listUsers;
	private User selectedUser;

	public UserListController() {
		this.user = new User();
		this.userService = new UserService();
		this.listUsers = userService.findAll();
		this.selectedUser = new User();
		System.out.println("Chamou o construtor padrão");
	}

	public UserListController(User user, List<User> listUsers, String nameEmail) {
		this.user = user;
		this.listUsers = listUsers;
		this.userService = new UserService();
		this.selectedUser = new User();
	}

	public void removeUser() {
		Long id = selectedUser.getId();
		this.userService.remove(id);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuário removido com sucesso!"));
		this.clear();
		this.reLoadPage();
	}

	public void loadPageUserForm() {
		if (this.selectedUser == null) {

		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("UserForm.xhtml");
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar a página"));
		}
	}

	public void atualizar(User user) {
		try {
			this.user = user;
			FacesContext.getCurrentInstance().getExternalContext().redirect("UserForm.xhtml");
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar a página"));
		}
	}

	public void exit() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar a página"));
		}
	}

	private void reLoadPage() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("UserList.xhtml");
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar a página"));
		}
	}

	private void clear() {
		this.user = new User();
		this.userService = new UserService();
		this.listUsers = userService.findAll();
		this.selectedUser = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
}
