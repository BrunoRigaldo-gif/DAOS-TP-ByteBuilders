package TUTI.presentacion.contratos;

import java.util.Collection;
import java.util.Date;
import TUTI.entidades.Contrato;
import jakarta.validation.constraints.*;

public class ContratoDTO {
	@NotNull
	@Positive
	private Long numero;
	@NotNull
	private Date fecha;
	@NotNull
	@Positive
	private Long dniInquilino;
	@NotNull
	@Positive
	private Long dniPropietario;

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

	public Long getDniInquilino() {
		return dniInquilino;
	}

	public void setDniInquilino(Long dniInquilino) {
		this.dniInquilino = dniInquilino;
	}

	public Long getDniPropietario() {
		return dniPropietario;
	}

	public void setDniPropietario(Long dniPropietario) {
		this.dniPropietario = dniPropietario;
	}

	public Contrato toPojo() {
		Contrato pojo = new Contrato();
		pojo.setNumero(numero);
		pojo.setFecha(fecha);
		return pojo;
	}
}
