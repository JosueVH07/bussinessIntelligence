package com.bussinessIntelligence.BussinessIntelligence.repository;

import com.bussinessIntelligence.BussinessIntelligence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Usuariorepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
}
