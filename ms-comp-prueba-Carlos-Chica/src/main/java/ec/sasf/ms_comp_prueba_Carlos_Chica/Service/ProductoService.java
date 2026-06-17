package ec.sasf.ms_comp_prueba_Carlos_Chica.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Producto;
import ec.sasf.ms_comp_prueba_Carlos_Chica.Repository.ProductoRepo;
import ec.sasf.ms_comp_prueba_Carlos_Chica.dto.ProductoDTO;

@Service

public class ProductoService {
    @Autowired
    private ProductoRepo prdrepo;

    public Producto creaProducto (ProductoDTO prod){
        Producto prodnuevo = Producto.builder()
            .nombre(prod.getNombre())
            .descripcion(prod.getDescripcion())
            .precioUnitario(prod.getPrecioUnitario())
            .stock(prod.getStock())
            .activo(true)
            .build();
        return prdrepo.save(prodnuevo);
    }


}
