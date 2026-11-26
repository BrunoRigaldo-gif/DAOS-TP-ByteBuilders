package TUTI.servicios;

import java.util.List;
import TUTI.entidades.Factura;
import TUTI.presentacion.facturas.FacturaDTO;

public interface FacturaService {
	
	List<Factura> getActivas();

	List<Factura> getAll();

	public void save(Factura f) throws Exception;

	public void delete(Long id);

	Long insert(FacturaDTO dto) throws Exception;

	Factura update(FacturaDTO dto, Long id) throws Exception;

}
