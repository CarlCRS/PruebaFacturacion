package ec.sasf.ms_comp_prueba_Carlos_Chica.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacturaRequestDTO {
    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;
    @NotEmpty(message = "Debe incluir al menos un detalle")
    @Valid
    private List<DetalleRequestDTO> detalles;
}
