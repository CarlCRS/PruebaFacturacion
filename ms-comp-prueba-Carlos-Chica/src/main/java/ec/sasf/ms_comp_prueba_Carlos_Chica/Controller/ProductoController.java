package ec.sasf.ms_comp_prueba_Carlos_Chica.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Producto;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Service.ProductoService;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.ProductoDTO;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor

public class ProductoController {

    private final ProductoService prodservice;

    @PostMapping
    public ResponseEntity<Producto> crearProducto (@Valid @RequestBody ProductoDTO entity) {      
        return ResponseEntity.ok(prodservice.creaProducto(entity));
    }
    
    
}
