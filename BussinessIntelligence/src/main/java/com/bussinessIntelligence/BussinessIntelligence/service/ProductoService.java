package com.bussinessIntelligence.BussinessIntelligence.service;

import com.bussinessIntelligence.BussinessIntelligence.entity.Producto;
import com.bussinessIntelligence.BussinessIntelligence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> list(){
        return productoRepository.findAll();
    }
    public Optional<Producto> getOneProd(int idproducto){
        return productoRepository.findById(idproducto);
    }

    public Optional<Producto> getByNombreProd(String nombre){
        return productoRepository.findByNombre(nombre);
    }
    /*public Optional<Producto> getByPrecio(float precio){
        return productoRepository.findByPrecio(precio);
    }
    public Optional<Producto> getByStock(int stock){
        return productoRepository.findByStock(stock);
    }*/

    public void save(Producto producto){
        productoRepository.save(producto);
    }

    public void delete(int idproducto){
        productoRepository.deleteById(idproducto);
    }

    public boolean existByIdProd(int idproducto){
        return productoRepository.existsById(idproducto);
    }
    public boolean existByNombreProd(String nombre){
        return productoRepository.existsByNombre(nombre);
    }
   /*public boolean existByPrecioProd(float precio){
        return productoRepository.existsByPrecio(precio);
    }
    public boolean existByStock(int stock){
        return productoRepository.existsByStock(stock);
    }*/

}
