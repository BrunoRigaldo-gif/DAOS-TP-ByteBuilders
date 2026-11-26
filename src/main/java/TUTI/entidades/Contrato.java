package TUTI.entidades;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Contrato {

	@Id
	private Long numero;

	private Date fecha;
	
	@NotNull
	@Positive
	private Integer mesesVigencia;

	@ManyToOne
	private Persona inquilino;
	@ManyToOne
	private Persona propietario;
	
	@NotNull
	private Boolean eliminado = false;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getInquilino() {
		return inquilino;
	}

	public void setInquilino(Persona inquilino) {
		this.inquilino = inquilino;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

}
