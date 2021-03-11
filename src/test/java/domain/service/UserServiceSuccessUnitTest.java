package domain.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.model.Phone;
import domain.model.TypePhone;
import domain.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceSuccessUnitTest {
	
	IUserService userService = new UserService();

	@Test
	public void a_must_return_a_user_when_save() {
		Phone phone = new Phone();
		User user = new User();
		Set<Phone> phones = new HashSet<Phone>();

		phone.setDdd("81");
		phone.setNumber("999999999");
		phone.setTypePhone(TypePhone.CELULAR);
		phones.add(phone);

		user.setName("João da Silva");
		user.setEmail("joao.silva@gmail.com");
		user.setPassword("123456");
		user.setPhones(phones);
		
		User savedUser = userService.save(user);
		
		assertNotNull(savedUser);
	}
	
	@Test
	public void b_must_return_a_user_when_find_user_by_id() {
		List<User> users = userService.findAll();

		User user = userService.find(users.get(users.size()-1).getId());

		assertNotNull("Falha ao buscar usuário pelo id.", user);
	}
	
	@Test
	public void c_must_return_a_list_od_user_when_find_all() {
		List<User> users = userService.findAll();

		assertNotNull("Falha ao carregar a lista de usuários.", users);
	}
	
	@Test
	public void d_must_return_a_user_when_find_user_by_name() {

		User user = userService.findByName("João da Silva");

		assertNotNull("Falha ao buscar usuário pelo nome.", user);
	}
	
	@Test
	public void e_must_return_a_user_when_find_user_by_email() {

		User user = userService.findByEmail("joao.silva@gmail.com");

		assertNotNull("Falha ao buscar usuário pelo email.", user);
	}
	
	@Test
	public void f_must_return_true_when_email_and_password_is_correct() {
		String email = "joao.silva@gmail.com";
		String password = "123456";
		
		boolean result = userService.verifyEmailAndPassword(email, password);
		
		assertTrue("Falha na verificação de email e senha.", result);
	}
	
	@Test
	public void g_must_return_true_when_delete_a_user() {
		List<User> users = userService.findAll();
		boolean response = userService.remove(users.get(users.size()-1).getId());

		assertTrue("Falha do remover usuário com o id " + users.get(users.size()-1).getId() + ".", response);
	}
}
