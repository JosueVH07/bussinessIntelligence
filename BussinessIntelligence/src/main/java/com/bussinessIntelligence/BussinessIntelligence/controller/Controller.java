package com.bussinessIntelligence.BussinessIntelligence.controller;

import com.bussinessIntelligence.BussinessIntelligence.dto.ClienteDto;
import com.bussinessIntelligence.BussinessIntelligence.dto.Mensaje;
import com.bussinessIntelligence.BussinessIntelligence.dto.VentaDto;
import com.bussinessIntelligence.BussinessIntelligence.entity.Cliente;
import com.bussinessIntelligence.BussinessIntelligence.entity.Venta;
import com.bussinessIntelligence.BussinessIntelligence.service.ClienteService;
import com.bussinessIntelligence.BussinessIntelligence.service.VentaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    ClienteService clienteService;
    @Autowired
    VentaService ventaService;

    @GetMapping("/listaclientes")
    public ResponseEntity<List<Cliente>> list(){
        List<Cliente> list = clienteService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detailcliente/{idcliente}")
    public  ResponseEntity<Cliente> getById(@PathVariable("idcliente") int idcliente){
        if(!clienteService.existById(idcliente))
            return new ResponseEntity(new Mensaje("No existe el cliente"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.getOne(idcliente).get();
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @GetMapping("/detailclientename/{nombre}")
    public  ResponseEntity<Cliente> getByNombre(@PathVariable("nombre") String nombre){
        if(!clienteService.existByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe el cliente"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.getByNombre(nombre).get();
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("/createcliente")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        if(StringUtils.isBlank(clienteDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clienteDto.getTelefono()))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clienteDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clienteDto.getDireccion()))
            return new ResponseEntity(new Mensaje("La direccion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (clienteService.existByCorreo(clienteDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El correo ya existe"), HttpStatus.BAD_REQUEST);
        if (clienteService.existByTelefono(clienteDto.getTelefono()))
            return new ResponseEntity(new Mensaje("El telefono ya existe"), HttpStatus.BAD_REQUEST);
        Cliente cliente = new Cliente(clienteDto.getNombre(), clienteDto.getTelefono(), clienteDto.getCorreo(), clienteDto.getDireccion());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("Cliente creado"), HttpStatus.OK);
    }

    @PutMapping("updatecliente/{idcliente}")
    public ResponseEntity<?> update(@PathVariable("idcliente")int idcliente, @RequestBody ClienteDto clienteDto){
        if(!clienteService.existById(idcliente))
            return new ResponseEntity(new Mensaje("No existe el cliente"), HttpStatus.NOT_FOUND);
        if (clienteService.existByCorreo(clienteDto.getCorreo()) && clienteService.getByCorreo(clienteDto.getCorreo()).get().getIdcliente() != idcliente)
            return new ResponseEntity(new Mensaje("El correo ya existe"), HttpStatus.BAD_REQUEST);
        if (clienteService.existByTelefono(clienteDto.getTelefono()) && clienteService.getByTelefono(clienteDto.getTelefono()).get().getIdcliente() != idcliente)
            return new ResponseEntity(new Mensaje("El telefono ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(clienteDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clienteDto.getTelefono()))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clienteDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El correo es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clienteDto.getDireccion()))
            return new ResponseEntity(new Mensaje("La direccion es obligatoria"), HttpStatus.BAD_REQUEST);
        Cliente cliente = clienteService.getOne(idcliente).get();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());
        cliente.setDireccion(clienteDto.getDireccion());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("Cliente actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/deletecliente/{idcliente}")
    public ResponseEntity<?> delete(@PathVariable("idcliente")int idcliente){
        if(!clienteService.existById(idcliente))
            return new ResponseEntity(new Mensaje("No existe el cliente"), HttpStatus.NOT_FOUND);
        clienteService.delete(idcliente);
        return new ResponseEntity(new Mensaje("Cliente eliminado"), HttpStatus.OK);
    }

    @GetMapping("/listaventas")
    public ResponseEntity<List<Venta>> listV(){
        List<Venta> listV = ventaService.list();
        return new ResponseEntity(listV, HttpStatus.OK);
    }

    @GetMapping("/detaiventa/{idventa}")
    public  ResponseEntity<Venta> getByIdV(@PathVariable("idventa") int idventa){
        if(!ventaService.existByIdV(idventa))
            return new ResponseEntity(new Mensaje("No existe la venta"), HttpStatus.NOT_FOUND);
        Venta venta = ventaService.getOneV(idventa).get();
        return new ResponseEntity(venta, HttpStatus.OK);
    }

    @PostMapping("/createventa")
    public ResponseEntity<?> create(@RequestBody VentaDto ventaDto){
        if (ventaDto.getIdcliente()<=0)
            return new ResponseEntity(new Mensaje("El id del cliente es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(ventaDto.getFecha()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if (ventaDto.getIdproducto()<=0)
            return new ResponseEntity(new Mensaje("El id del producto es obligatorio"), HttpStatus.BAD_REQUEST);
        if (ventaDto.getCantidad()<=0)
            return new ResponseEntity(new Mensaje("La cantidad es obligatoria"), HttpStatus.BAD_REQUEST);
        if (ventaDto.getPrecio()<=0 || ventaDto.getPrecio() == null)
            return new ResponseEntity(new Mensaje("El precio debe ser obligatorio"), HttpStatus.BAD_REQUEST);
        if (ventaDto.getTotal()<=0 || ventaDto.getPrecio() == null)
            return new ResponseEntity(new Mensaje("El total de la venta debe ser mayor a cero"), HttpStatus.BAD_REQUEST);
        if (!clienteService.existById(ventaDto.getIdcliente()))
            return new ResponseEntity(new Mensaje("El cliente no existe"), HttpStatus.BAD_REQUEST);
        /*if (!clienteService.existById(ventaDto.getIdproducto()))
            return new ResponseEntity(new Mensaje("El producto no existe"), HttpStatus.BAD_REQUEST);*/ //meter validacion de producto
        Venta venta = new Venta(ventaDto.getIdcliente(), ventaDto.getFecha(), ventaDto.getIdproducto(), ventaDto.getCantidad(), ventaDto.getPrecio(), ventaDto.getTotal());
        ventaService.save(venta);
        return new ResponseEntity(new Mensaje("Venta creada"), HttpStatus.OK);
    }


}
