package com.bussinessIntelligence.BussinessIntelligence.repository;

import com.bussinessIntelligence.BussinessIntelligence.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
