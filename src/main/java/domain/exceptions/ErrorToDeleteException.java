package domain.exceptions;

public class ErrorToDeleteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorToDeleteException() {
		super("Erro ao deletar a entidade.");
	}

}
