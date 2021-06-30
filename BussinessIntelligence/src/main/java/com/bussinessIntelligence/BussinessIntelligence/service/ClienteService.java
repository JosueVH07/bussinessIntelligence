package com.bussinessIntelligence.BussinessIntelligence.service;

import com.bussinessIntelligence.BussinessIntelligence.entity.Cliente;
import com.bussinessIntelligence.BussinessIntelligence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getOne(int idcliente){
        return clienteRepository.findById(idcliente);
    }

    public Optional<Cliente> getByNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }
    public Optional<Cliente> getByCorreo(String correo){
        return clienteRepository.findByCorreo(correo);
    }
    public Optional<Cliente> getByTelefono(String telefono){
        return clienteRepository.findByTelefono(telefono);
    }

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void delete(int idcliente){
        clienteRepository.deleteById(idcliente);
    }

    public boolean existById(int idcliente){
        return clienteRepository.existsById(idcliente);
    }

    public boolean existByNombre(String nombre){
        return clienteRepository.existsByNombre(nombre);
    }

    public boolean existByCorreo(String correo){
        return clienteRepository.existsByCorreo(correo);
    }

    public boolean existByTelefono(String telefono){
        return clienteRepository.existsByTelefono(telefono);
    }

}
