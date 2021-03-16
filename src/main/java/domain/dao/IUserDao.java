package domain.dao;

import java.util.List;

import domain.model.User;

public interface IUserDao {

	User save(User user);

	List<User> findAll();

	User findById(Long id);

	boolean deleteById(Long id);

	User findByEmailAndPassword(String email, String password);

}
