package domain.service;

import java.util.List;

import domain.model.User;

public interface IUserService {

	User save(User user);

	User find(Long id);

	List<User> findAll();

	boolean remove(Long id);

	boolean verifyEmailAndPassword(String email, String password);

}
