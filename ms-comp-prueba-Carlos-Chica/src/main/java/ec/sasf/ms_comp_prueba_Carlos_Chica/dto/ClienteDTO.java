package ec.sasf.ms_comp_prueba_Carlos_Chica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    @NotNull(message = "El id del usuario es obligatorio")
    private Long idUsuario;
    @NotBlank(message = "La identificacion es obligatoria")
    private String identificacion;
    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;
    @NotBlank(message = "La direccion es obligatoria")
    private String direccion;
}
