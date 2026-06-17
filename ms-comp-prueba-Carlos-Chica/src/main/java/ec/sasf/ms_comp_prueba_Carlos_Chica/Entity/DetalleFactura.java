package ec.sasf.ms_comp_prueba_Carlos_Chica.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
    
}
