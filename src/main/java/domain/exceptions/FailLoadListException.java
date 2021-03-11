package domain.exceptions;

public class FailLoadListException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FailLoadListException(String listType) {
		super("Falha ao carregar a lista de " + listType);
	}

}
