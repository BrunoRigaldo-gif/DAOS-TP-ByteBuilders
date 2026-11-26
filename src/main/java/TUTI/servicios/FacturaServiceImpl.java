package TUTI.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import TUTI.accesoDatos.IContratoRepo;
import TUTI.accesoDatos.IFacturaRepo;
import TUTI.entidades.Factura;
import TUTI.excepciones.Excepcion;
import TUTI.presentacion.facturas.FacturaDTO;
import jakarta.validation.Validator;

public class FacturaServiceImpl implements FacturaService {

	@Autowired
	IFacturaRepo facturaRepo;
	@Autowired
	private IContratoRepo contratoRepo;
	@Autowired
	Validator validator;

	@Override
	public List<Factura> getAll() {
		return facturaRepo.findAll();
	}

	@Override
	public List<Factura> getActivas() {
		return facturaRepo.findByEliminadoFalse();
	}

	@Override
	public Optional<Factura> getById(Long idFactura) throws Excepcion {
		return facturaRepo.findById(idFactura);
	}

	@Override
	public Long insert(FacturaDTO dto) throws Excepcion {
		Factura pojo = preparar(dto);
		if (facturaRepo.existsById(pojo.getId()))
			throw new Excepcion("id", "Ya existe un registro con ese numero.", 409);
		return facturaRepo.save(pojo).getId();
	}

	@Override
	public void delete(Long id) throws Excepcion {
		if (!facturaRepo.existsById(id)) {
			throw new Excepcion("id", "No se encuentra el registro que desea eliminar.", 404);
		}
		facturaRepo.deleteById(id);
	}

	@Override
	public Factura update(FacturaDTO dto, Long id) throws Excepcion {
		if (!facturaRepo.existsById(id))
			 throw new Excepcion("id", "No se encuentra el registro que desea modificar.", 404);
		Factura pojo = preparar(dto);
		if (!id.equals(pojo.getId()))
			throw new Excepcion("id", "El identificador del cuerpo debe coincidir con el de la URL.", 400);
		return facturaRepo.save(pojo);
	}

	private Factura preparar(FacturaDTO dto) throws Excepcion {
		var errores = validator.validate(dto);
		if (!errores.isEmpty()) {
			var error = errores.iterator().next();
			throw new Excepcion(error.getPropertyPath().toString(), error.getMessage(), 400);
		}
		Factura pojo = dto.toPojo();
		pojo.setContrato(contratoRepo.findById(dto.getNumeroContrato())
				.orElseThrow(() -> new Excepcion("numeroContrato", "El contrato no existe.", 404)));
		return pojo;
	}

}
