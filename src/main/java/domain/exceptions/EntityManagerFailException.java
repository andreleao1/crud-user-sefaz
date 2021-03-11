package domain.exceptions;

public class EntityManagerFailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntityManagerFailException() {
		super("Erro para criar EntityManager.");
	}
}
