package com.bussinessIntelligence.BussinessIntelligence.service;

import com.bussinessIntelligence.BussinessIntelligence.entity.Prov;
import com.bussinessIntelligence.BussinessIntelligence.entity.Rol;
import com.bussinessIntelligence.BussinessIntelligence.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public List<Rol> list(){
        return rolRepository.findAll();
    }

    public Optional<Rol> getOneRol(int idrol){
        return rolRepository.findById(idrol);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }

    public void delete(int idrol){
        rolRepository.deleteById(idrol);
    }
    public boolean existByIdRol(int idrol){
        return rolRepository.existsById(idrol);
    }
}
