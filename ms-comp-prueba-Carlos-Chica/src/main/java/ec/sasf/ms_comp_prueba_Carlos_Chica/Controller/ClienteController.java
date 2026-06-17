package ec.sasf.ms_comp_prueba_Carlos_Chica.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Cliente;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Service.ClienteService;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteservice;

    @PostMapping
    public ResponseEntity<Cliente> crearcliente(@Valid @RequestBody ClienteDTO entity) {
        return ResponseEntity.ok(clienteservice.creaCliente(entity));
    }
}
