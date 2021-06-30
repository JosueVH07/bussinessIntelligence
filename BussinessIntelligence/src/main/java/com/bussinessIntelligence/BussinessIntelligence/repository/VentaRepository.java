package com.bussinessIntelligence.BussinessIntelligence.repository;


import com.bussinessIntelligence.BussinessIntelligence.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
