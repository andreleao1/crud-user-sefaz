package domain.service;

import static org.junit.Assert.assertFalse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.exceptions.EntityNotFoundException;
import domain.exceptions.ErrorToSaveEntityException;
import domain.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceFlawsUnitTest {

	IUserService userService = new UserService();

	@Test(expected = ErrorToSaveEntityException.class)
	public void a_must_fail_when_save_a_user_null() {
		User user = null;
		userService.save(user);
	}

	@Test(expected = ErrorToSaveEntityException.class)
	public void b_must_fail_when_save_a_user_with_one_or_more_fields_null() {
		User user = new User();

		user.setEmail("joao.silva@gemail.com");
		userService.save(user);
	}

	@Test(expected = EntityNotFoundException.class)
	public void c_must_fail_when_find_a_user_noexistent() {
		userService.find(999999L);
	}
	
	public void d_must_return_false_when_find_a_user_with_email_and_or_password_nonexistent() {
		assertFalse("Falha na verificação de email e senha.", userService
				.verifyEmailAndPassword("testedebuscasememailexistente@teste.com", "testedebuscasememailexistente"));
	}

	@Test(expected = EntityNotFoundException.class)
	public void e_must_fail_when_remove_a_user_with_id_nonexistent() {
		userService.remove(999999L);
	}
}
