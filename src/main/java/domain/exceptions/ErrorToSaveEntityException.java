package domain.exceptions;

public class ErrorToSaveEntityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ErrorToSaveEntityException() {
		super("Erro ao salvar entidade");
	}

}
