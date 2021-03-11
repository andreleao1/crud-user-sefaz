package domain.dao;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;

public class JpaUtilUnitTest {

	@Test
	public void must_pass_when_get_a_entity_manager() {
		EntityManager em = JpaUtil.getEntityManager();

		assertNotNull("Falha ao criar o entity manager.",em);

		em.close();
	}
}
