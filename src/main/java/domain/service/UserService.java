package domain.service;

import java.util.List;
import java.util.Objects;

import javax.persistence.NoResultException;

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
	public boolean verifyEmailAndPassword(String email, String password) {
		User user = null;
		try {
			user = this.userDao.findByEmailAndPassword(email, password);
		} catch (NoResultException e) {
			System.out.println("Error! \nMenssagem: " + e.getMessage());
		}

		if (!Objects.nonNull(user)) {
			return false;
		}

		return true;
	}

}
