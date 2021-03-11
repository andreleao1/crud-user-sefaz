package domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private Long id;

	@Column(length = 2, nullable = false)
	private String ddd;

	@Column(length = 9, nullable = false)
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_phone", nullable = false)
	private TypePhone typePhone;

	public Phone() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TypePhone getTypePhone() {
		return typePhone;
	}

	public void setTypePhone(TypePhone typePhone) {
		this.typePhone = typePhone;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", ddd=" + ddd + ", number=" + number + ", typePhone=" + typePhone + "]";
	}
}
