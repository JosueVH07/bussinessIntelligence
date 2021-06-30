package com.bussinessIntelligence.BussinessIntelligence.repository;

import com.bussinessIntelligence.BussinessIntelligence.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Integer> {
    Optional<Puesto> findByRolempleado(String rolempleado);

    boolean existsByRolempleado(String rolempleado);
}
