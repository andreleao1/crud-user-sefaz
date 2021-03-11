package domain.dao;

import java.util.List;

import domain.model.User;

public interface IUserDao {

	User save(User user);

	List<User> findAll();

	User findById(Long id);

	boolean deleteById(Long id);

	User findByName(String name);

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
