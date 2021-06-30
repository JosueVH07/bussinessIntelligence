package com.bussinessIntelligence.BussinessIntelligence.service;


import com.bussinessIntelligence.BussinessIntelligence.entity.Usuario;
import com.bussinessIntelligence.BussinessIntelligence.repository.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    Usuariorepository usuariorepository;

    public List<Usuario> list(){
        return usuariorepository.findAll();
    }
    public Optional<Usuario> getOneUsr(int idusuario){
        return usuariorepository.findById(idusuario);
    }

    public void save(Usuario usuario){
        usuariorepository.save(usuario);
    }

    public void delete(int idusuario){
        usuariorepository.deleteById(idusuario);
    }
    public Optional<Usuario> getByUsername(String username){
        return usuariorepository.findByUsername(username);
    }

    public boolean existByUsername(String username){
        return usuariorepository.existsByUsername(username);
    }
    public boolean existByIdUsr(int idusuario){
        return usuariorepository.existsById(idusuario);
    }
}
