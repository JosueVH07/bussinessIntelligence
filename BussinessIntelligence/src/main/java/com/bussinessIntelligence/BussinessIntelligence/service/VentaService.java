package com.bussinessIntelligence.BussinessIntelligence.service;




import com.bussinessIntelligence.BussinessIntelligence.entity.Venta;
import com.bussinessIntelligence.BussinessIntelligence.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VentaService {
    @Autowired
    VentaRepository ventaRepository;

    public List<Venta> list(){
        return ventaRepository.findAll();
    }
    public Optional<Venta> getOneV(int idventa){
        return ventaRepository.findById(idventa);
    }





    public void save(Venta venta){
        ventaRepository.save(venta);
    }

   /* public void delete(int idventa){
        ventaRepository.deleteById(idventa);
    }*/

    public boolean existByIdV(int idventa){
        return ventaRepository.existsById(idventa);
    }

}
