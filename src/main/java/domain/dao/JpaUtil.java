package domain.dao;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.exceptions.EntityManagerFailException;

public class JpaUtil {

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-sefaz");
		EntityManager em = emf.createEntityManager();

		if (Objects.isNull(em)) {
			throw new EntityManagerFailException();
		}

		return em;
	}
}
