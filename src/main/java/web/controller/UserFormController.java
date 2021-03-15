package web.controller;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domain.model.Phone;
import domain.model.TypePhone;
import domain.model.User;
import domain.service.IUserService;
import domain.service.UserService;
import jakarta.annotation.PostConstruct;

@ManagedBean(name = "userFormController")
@SessionScoped
public class UserFormController {

	private User user;
	private Phone phone;
	private String typePhoneChosen;
	private Set<Phone> phones;

	private IUserService userService;

	public UserFormController() {
		if(this.user == null) {
			this.user = new User();
			this.phone = new Phone();
			this.phones = new HashSet<Phone>();
			this.userService = new UserService();
			System.out.println("Chamou o construtor padrão.");
			System.out.println(this.user.toString());
		} else {

			System.out.println("Pulou a verificação");
			System.out.println(this.user.toString());
		}
		//System.out.println(this.user.toString());
		
	}

	public UserFormController(User user) {
		this.user = user;
		System.out.println(this.user.toString());
		System.out.println("Chamou o construtor com usuário");
	}

	public UserFormController(User user, Phone phone, String typePhoneChosen, Set<Phone> phones) {
		this.user = user;
		this.phone = phone;
		this.phones = phones;
		this.typePhoneChosen = typePhoneChosen;
		System.out.println("Chamou o construtor com todos os atributos.");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String getTypePhoneChosen() {
		return typePhoneChosen;
	}

	public void setTypePhoneChosen(String typePhoneChosen) {
		this.typePhoneChosen = typePhoneChosen;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public void save() {
		if (Objects.nonNull(this.phone)) {
			assignPhoneToUser(this.phone);
		}
		this.userService.save(this.user);
		clear();
		loadPageUserList();
	}
	
	public void loadUserInForm(User user) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("UserForm.xhtml");
			System.out.println("Vai chamar o construtor agora");
		} catch (Exception e) {
			System.out.println(e.getStackTrace().toString());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao carregar a página"));
		}		
	}

	public void loadPageUserList() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("UserList.xhtml");
			//clear();
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

	private void assignPhoneToUser(Phone phone) {
		setTypePhone(typePhoneChosen);
		this.phones.add(this.phone);
		this.user.setPhones(phones);
	}

	private void setTypePhone(String typePhone) {
		if (typePhone.equals("CELULAR")) {
			this.phone.setTypePhone(TypePhone.CELULAR);
		} else {
			this.phone.setTypePhone(TypePhone.FIXO);
		}
	}

	private void clear() {
		this.user = new User();
		this.phone = new Phone();
		this.typePhoneChosen = null;
		this.phones = new HashSet<Phone>();
	}
}
