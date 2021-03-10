package domain.model;

public enum TypePhone {

	CELULAR("Celular"), FIXO("Fixo");

	private String typePhone;

	private TypePhone(String typePhone) {
		this.typePhone = typePhone;
	}

	public String getTypePhone() {
		return this.typePhone;
	}
}
