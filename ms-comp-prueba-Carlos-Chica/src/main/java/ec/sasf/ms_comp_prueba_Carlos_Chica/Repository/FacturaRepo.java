package ec.sasf.ms_comp_prueba_Carlos_Chica.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Factura;

public interface FacturaRepo extends JpaRepository<Factura, Long>{
    
}
