package domain.exceptions;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String field, String fieldValue) {
		super(String.format("Não existe entidade cadastrada com %s %s", field, fieldValue));
	}

}
