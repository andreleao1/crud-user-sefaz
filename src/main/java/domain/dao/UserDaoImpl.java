package domain.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import domain.exceptions.ErrorToDeleteException;
import domain.model.User;

public class UserDaoImpl implements IUserDao {
	
	private EntityManager em;

	@Override
	public User save(User user) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<User> findAll() {
		em = JpaUtil.getEntityManager();
		String jpql = "FROM User";
		Query query = em.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		em.close();

		return users;
	}

	@Override
	public User findById(Long id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}

	@Override
	public User findByName(String name) {
		String jpql = "FROM User AS user WHERE user.name = :name";
		em = JpaUtil.getEntityManager();
		Query query = em.createQuery(jpql);
		query.setParameter("name", name);
		User user = (User) query.getSingleResult();
		em.close();
		return user;
	}

	@Override
	public User findByEmail(String email) {
		String jpql = "FROM User AS user WHERE user.email = :email";
		em = JpaUtil.getEntityManager();
		Query query = em.createQuery(jpql);
		query.setParameter("email", email);
		User user = (User) query.getSingleResult();
		em.close();
		return user;
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		String jpql = "FROM User AS user WHERE user.email = :email AND user.password = :password";
		em = JpaUtil.getEntityManager();
		Query query = em.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = (User) query.getSingleResult();
		em.close();
		return user;
	}

	@Override
	public boolean deleteById(Long id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, id);

		if (Objects.nonNull(user)) {
			try {
				em.remove(user);
				em.getTransaction().commit();
				em.close();
				return true;
			} catch (Exception e) {
				throw new ErrorToDeleteException();
			}
		}
		return false;
	}
}
