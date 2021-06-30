package com.bussinessIntelligence.BussinessIntelligence.repository;

import com.bussinessIntelligence.BussinessIntelligence.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    Optional<DetalleVenta> findByIdventa(int idventa);
    boolean existsByIdventa(int idventa);
}
