package ec.sasf.ms_comp_prueba_Carlos_Chica.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Rol;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Usuario;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Exception.GlobalExcepcion;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.UsuarioRepository;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Security.JwtUtil;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.AuthRespuesta;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.LoginRequest;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.RegistroDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthRespuesta login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getPassword())
        );
        Usuario user = usuarioRepo.findByCorreo(request.getCorreo())
            .orElseThrow(() -> new GlobalExcepcion("Usuario no encontrado"));
        return AuthRespuesta.builder().token(jwtUtil.getToken(user)).build();
    }

    public String register(RegistroDTO request) {
        if (usuarioRepo.existsByCorreo(request.getCorreo()))
            throw new GlobalExcepcion("El usuario ya existe");

        Usuario user = Usuario.builder()
                .correo(request.getCorreo())
                .nombre(request.getNombre())
                .password(passwordEncoder.encode(request.getPassword()))
                //Lo dejo por defecto como admin nomas
                .rol(Rol.ADMIN)
                .build();
        usuarioRepo.save(user);
        return "Usuario registrado exitosamente";
    }
}
