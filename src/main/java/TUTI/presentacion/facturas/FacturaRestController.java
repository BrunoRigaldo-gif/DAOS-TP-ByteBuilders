package TUTI.presentacion.facturas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "facturas", produces = "application/json")
@Tag(name = "Facturas", description = "Operaciones CRUD sobre facturas")
public class FacturaRestController {

}
