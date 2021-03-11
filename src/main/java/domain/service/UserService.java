package domain.service;

import java.util.List;
import java.util.Objects;

import domain.dao.IUserDao;
import domain.dao.UserDaoImpl;
import domain.exceptions.EntityNotFoundException;
import domain.exceptions.ErrorToSaveEntityException;
import domain.exceptions.FailLoadListException;
import domain.model.User;

public class UserService implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User save(User user) {
		User savedUser = this.userDao.save(user);

		if (!Objects.nonNull(savedUser)) {
			throw new ErrorToSaveEntityException();
		}

		return savedUser;
	}

	@Override
	public User find(Long id) {
		User user = this.userDao.findById(id);

		if (!Objects.nonNull(user)) {
			throw new EntityNotFoundException("id", id.toString());
		}

		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = this.userDao.findAll();

		if (!Objects.nonNull(users)) {
			throw new FailLoadListException("usuários");
		}

		return users;
	}

	@Override
	public boolean remove(Long id) {
		boolean isRemovedUser = this.userDao.deleteById(id);

		if (!isRemovedUser) {
			throw new EntityNotFoundException("id", id.toString());
		}

		return isRemovedUser;
	}

	@Override
	public User findByName(String name) {
		User user = this.userDao.findByName(name);

		if (!Objects.nonNull(user)) {
			throw new EntityNotFoundException("nome", name);
		}

		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = this.userDao.findByEmail(email);

		if (!Objects.nonNull(user)) {
			throw new EntityNotFoundException("email", email);
		}
		return user;
	}

	@Override
	public boolean verifyEmailAndPassword(String email, String password) {
		User user = this.userDao.findByEmailAndPassword(email, password);

		if (!Objects.nonNull(user)) {
			return false;
		}

		return true;
	}

}
