package ec.sasf.ms_comp_prueba_Carlos_Chica.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Cliente;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Usuario;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.ClienteRepo;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.UsuarioRepository;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.ClienteDTO;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepo clienterepo;
    private UsuarioRepository usuariorepo;

    public Cliente creaCliente(ClienteDTO dto) {
        Usuario usuarioencontrado = usuariorepo.findById(dto.getIdUsuario())
         .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Cliente clientenuevo = new Cliente();
        clientenuevo.setUsuario(usuarioencontrado);
        clientenuevo.setIdentificacion(dto.getIdentificacion());
        clientenuevo.setTelefono(dto.getTelefono());
        clientenuevo.setDireccion(dto.getDireccion());
        return clienterepo.save(clientenuevo);
    }
}
