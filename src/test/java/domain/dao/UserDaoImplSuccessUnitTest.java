package domain.dao;

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
public class UserDaoImplSuccessUnitTest {

	IUserDao userDao = new UserDaoImpl();

	@Test
	public void a_must_pass_when_save_a_user() {
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

		User savedUser = userDao.save(user);

		assertNotNull("Falha no teste de inserção de usuário", savedUser);
	}

	@Test
	public void b_must_return_true_when_find_all_users() {
		List<User> users = userDao.findAll();

		assertTrue("Falha ao buscar todos os usuários do sistema.", !users.isEmpty());
	}

	@Test
	public void c_must_pass_when_find_a_user_by_id() {
		List<User> users = userDao.findAll();

		User user = userDao.findById(users.get(users.size()-1).getId());

		assertNotNull("Falha ao buscar usuário pelo id.", user);
	}

	@Test
	public void d_must_pass_when_find_a_user_by_email_and_password() {
		String email = "joao.silva@gmail.com";
		String password = "123456";
		User user = userDao.findByEmailAndPassword(email, password);

		assertNotNull("Falha ao buscar usuário por email e senha.", user);
	}

	@Test
	public void e_must_return_true_when_remove_a_user() {
		List<User> users = userDao.findAll();
		boolean response = userDao.deleteById(users.get(users.size()-1).getId());

		assertTrue("Falha do remover usuário com o id " + users.get(users.size()-1).getId() + ".", response);
	}
}
