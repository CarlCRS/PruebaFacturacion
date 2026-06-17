package ec.sasf.ms_comp_prueba_Carlos_Chica.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Factura;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Service.FacturaService;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.FacturaRequestDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/facturas")
@RequiredArgsConstructor
public class FacturaController {
    private final FacturaService facturaService;

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@Valid @RequestBody FacturaRequestDTO entity) {
        return ResponseEntity.ok(facturaService.crearFactura(entity));
    }
}
