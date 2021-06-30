package com.bussinessIntelligence.BussinessIntelligence.service;

import com.bussinessIntelligence.BussinessIntelligence.entity.Empleado;
import com.bussinessIntelligence.BussinessIntelligence.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    public List<Empleado> list(){
        return empleadoRepository.findAll();
    }
    public Optional<Empleado> getOneEm(int idempleado){
        return empleadoRepository.findById(idempleado);
    }
    public Optional<Empleado> getByNombre(String nombre){
        return empleadoRepository.findByNombre(nombre);
    }
    public void save(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    public void delete(int idempleado){
        empleadoRepository.deleteById(idempleado);
    }

    public boolean existByIdEm(int idempleado){
        return empleadoRepository.existsById(idempleado);
    }

    public boolean existByNombre(String nombre){
        return empleadoRepository.existsByNombre(nombre);
    }

}
