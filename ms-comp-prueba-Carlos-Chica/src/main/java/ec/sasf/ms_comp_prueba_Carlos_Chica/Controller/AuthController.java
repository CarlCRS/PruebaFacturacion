package ec.sasf.ms_comp_prueba_Carlos_Chica.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Service.AuthService;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.AuthRespuesta;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.LoginRequest;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.RegistroDTO;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthRespuesta> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistroDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }
}