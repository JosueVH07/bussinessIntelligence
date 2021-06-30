package com.bussinessIntelligence.BussinessIntelligence.service;

import com.bussinessIntelligence.BussinessIntelligence.entity.Cliente;
import com.bussinessIntelligence.BussinessIntelligence.entity.Puesto;
import com.bussinessIntelligence.BussinessIntelligence.repository.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PuestoService {
    @Autowired
    PuestoRepository puestoRepository;

    public List<Puesto> list(){
        return puestoRepository.findAll();
    }
    public Optional<Puesto> getOnePu(int idpuesto){
        return puestoRepository.findById(idpuesto);
    }
    public Optional<Puesto> getByRolempleado(String rolempleado){
        return puestoRepository.findByRolempleado(rolempleado);
    }

    public void save(Puesto puesto){
        puestoRepository.save(puesto);
    }

    public void delete(int idpuesto){
        puestoRepository.deleteById(idpuesto);
    }
    public boolean existByIdPu(int idpuesto){
        return puestoRepository.existsById(idpuesto);
    }

    public boolean existByRolempleado(String rolempleado){
        return puestoRepository.existsByRolempleado(rolempleado);
    }
}
