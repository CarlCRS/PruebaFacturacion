package ec.sasf.ms_comp_prueba_Carlos_Chica.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Cliente;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.DetalleFactura;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Factura;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Producto;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Usuario;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.ClienteRepo;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.DetalleFacturaRepo;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.FacturaRepo;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.ProductoRepo;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.DetalleRequestDTO;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.FacturaRequestDTO;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepo facturaRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private DetalleFacturaRepo detalleFacturaRepo;

    public Factura crearFactura(FacturaRequestDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        Factura factura = Factura.builder()
                .cliente(cliente)
                .fechaEmision(LocalDate.now())
                .subtotal(BigDecimal.ZERO)
                .impuesto(BigDecimal.ZERO)
                .total(BigDecimal.ZERO)
                .estado("EMITIDA")
                .numeroFactura("FAC-" + System.currentTimeMillis())
                .build();

        factura = facturaRepo.save(factura);

        BigDecimal subtotalGlobal = BigDecimal.ZERO;

        //Añado el detalle de la factura por cada producto
        for (DetalleRequestDTO det : dto.getDetalles()) {
            Producto producto = productoRepo.findById(det.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no existe"));

            if (det.getCantidad() > producto.getStock()) {
                throw new RuntimeException("No hay suficiente stock de " + producto.getNombre());
            }

            BigDecimal precio = producto.getPrecioUnitario();
            BigDecimal subtotalLinea = precio.multiply(BigDecimal.valueOf(det.getCantidad()));

            DetalleFactura detalle = new DetalleFactura();
            detalle.setFactura(factura);
            detalle.setProducto(producto);
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecioUnitario(precio);
            detalle.setSubtotal(subtotalLinea);

            detalleFacturaRepo.save(detalle);

            producto.setStock(producto.getStock() - det.getCantidad());
            productoRepo.save(producto);

            subtotalGlobal = subtotalGlobal.add(subtotalLinea);
        }
        //IVA del 15%
        BigDecimal impuesto = subtotalGlobal.multiply(new BigDecimal("0.15"));

        BigDecimal total = subtotalGlobal.add(impuesto);

        factura.setSubtotal(subtotalGlobal);
        factura.setImpuesto(impuesto);
        factura.setTotal(total);

        return facturaRepo.save(factura);
    }
}
