package com.bussinessIntelligence.BussinessIntelligence.repository;

import com.bussinessIntelligence.BussinessIntelligence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    //nombre, idproveedor, idproducto, precio, stock
    Optional<Producto> findByNombre(String nombre);


    boolean existsByNombre(String nombre);
    boolean existsByPrecio(float precio);
    boolean existsByStock(int stock);
}
