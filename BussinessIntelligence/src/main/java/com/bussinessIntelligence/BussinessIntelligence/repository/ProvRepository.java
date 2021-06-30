package com.bussinessIntelligence.BussinessIntelligence.repository;

import com.bussinessIntelligence.BussinessIntelligence.entity.Prov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvRepository extends JpaRepository<Prov, Integer> {

    Optional<Prov> findByNombre(String nombre);

    boolean existsByNombre(String nombre);



}
