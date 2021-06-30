package com.bussinessIntelligence.BussinessIntelligence.service;

import com.bussinessIntelligence.BussinessIntelligence.entity.Prov;
import com.bussinessIntelligence.BussinessIntelligence.repository.ProvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProvService {
    @Autowired
    ProvRepository provRepository;

    public List<Prov> list(){
        return provRepository.findAll();
    }

    public Optional<Prov> getOneProv(int idproveedor){
        return provRepository.findById(idproveedor);
    }
    public void save(Prov prov){
        provRepository.save(prov);
    }

    public void delete(int idproveedor){
        provRepository.deleteById(idproveedor);
    }
    public Optional<Prov> getByNombreProv(String nombre){
        return provRepository.findByNombre(nombre);
    }


    public boolean existByIdProv(int idproveedor){
        return provRepository.existsById(idproveedor);
    }
    public boolean existByIdNombreProv(String nombre) {
        return provRepository.existsByNombre(nombre);
    }

}
