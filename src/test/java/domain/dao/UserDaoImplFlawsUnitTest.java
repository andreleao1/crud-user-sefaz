package domain.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplFlawsUnitTest {

	IUserDao userDao = new UserDaoImpl();

	@Test
	public void a_must_return_null_when_save_a_user_null() {
		User user = null;

		assertNull(userDao.save(user));
	}

	@Test
	public void b_must_return_null_when_save_a_user_with_fields_null() {
		User user = new User();

		user.setEmail("joao.silva@gemail.com");

		assertNull(userDao.save(user));
	}

	@Test
	public void c_must_return_null_when_find_a_user_with_id_nonexistent() {
		User user = userDao.findById(999999L);

		assertNull(user);
	}

	@Test(expected = Exception.class)
	public void d_must_fail_when_find_a_user_with_name_nonexistent() {
		userDao.findByName("Teste de busca sem nome existente");
	}

	@Test(expected = Exception.class)
	public void e_must_fail_when_find_a_user_with_email_nonexistent() {
		userDao.findByName("testedebuscasememailexistente@teste.com");
	}

	@Test(expected = Exception.class)
	public void f_must_fail_when_find_a_user_with_email_and_or_password_nonexistent() {
		userDao.findByEmailAndPassword("testedebuscasememailexistente@teste.com", "testedebuscasememailexistente");
	}

	@Test
	public void g_must_return_null_when_remove_a_user_with_id_nonexistent() {
		assertFalse(userDao.deleteById(999999L));
	}
}
