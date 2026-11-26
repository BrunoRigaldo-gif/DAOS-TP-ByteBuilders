package TUTI.accesoDatos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TUTI.entidades.Factura;

@Repository
public interface IFacturaRepo extends JpaRepository<Factura,Long>{

	List<Factura> findByEliminadoFalse();

}
