package com.bussinessIntelligence.BussinessIntelligence.service;


import com.bussinessIntelligence.BussinessIntelligence.entity.DetalleVenta;
import com.bussinessIntelligence.BussinessIntelligence.entity.Empleado;
import com.bussinessIntelligence.BussinessIntelligence.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetalleVentaService {
    @Autowired
    DetalleVentaRepository detalleVentaRepository;
    public List<DetalleVenta> list(){
        return detalleVentaRepository.findAll();
    }
    public Optional<DetalleVenta> getOneDV(int iddetalleventa){
        return detalleVentaRepository.findById(iddetalleventa);
    }
    public Optional<DetalleVenta> getByIdVenta(int iddetalleventa){
        return detalleVentaRepository.findByIdventa(iddetalleventa);
    }

    public void save(DetalleVenta detalleVenta){
        detalleVentaRepository.save(detalleVenta);
    }

    public boolean existByIdVenta(int idventa){
        return detalleVentaRepository.existsByIdventa(idventa);
    }


}
