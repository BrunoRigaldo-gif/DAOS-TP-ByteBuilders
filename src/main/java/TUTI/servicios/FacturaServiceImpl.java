package TUTI.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import TUTI.accesoDatos.IFacturaRepo;
import TUTI.entidades.Factura;
import TUTI.excepciones.Excepcion;
import TUTI.presentacion.facturas.FacturaDTO;
import jakarta.validation.Validator;

public class FacturaServiceImpl implements FacturaService {

	@Autowired
	IFacturaRepo facturaRepo;
	@Autowired
	private ContratoService contratoService;
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
	public void save(Factura f) throws Exception {

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long insert(FacturaDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura update(FacturaDTO dto, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
