package com.bussinessIntelligence.BussinessIntelligence.controller;

import com.bussinessIntelligence.BussinessIntelligence.dto.*;
import com.bussinessIntelligence.BussinessIntelligence.entity.*;
import com.bussinessIntelligence.BussinessIntelligence.service.*;
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
    @Autowired
    ProvService provService;
    @Autowired
    ProductoService productoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;

    //clientes
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
    //ventas

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
            return new ResponseEntity(new Mensaje("El cliente no existe"), HttpStatus.NOT_FOUND);
        /*if (!clienteService.existById(ventaDto.getIdproducto()))
            return new ResponseEntity(new Mensaje("El producto no existe"), HttpStatus.BAD_REQUEST);*/ //meter validacion de producto
        Venta venta = new Venta(ventaDto.getIdcliente(), ventaDto.getFecha(), ventaDto.getIdproducto(), ventaDto.getCantidad(), ventaDto.getPrecio(), ventaDto.getTotal());
        ventaService.save(venta);
        return new ResponseEntity(new Mensaje("Venta creada"), HttpStatus.OK);
    }

    //proveedores
   @GetMapping("/listaproveedores")
    public ResponseEntity<List<Prov>> listProv(){
        List<Prov> listProv = provService.list();
        return new ResponseEntity(listProv, HttpStatus.OK);
    }
    @GetMapping("/detailproveedor/{idproveedor}")
    public  ResponseEntity<Prov> getByIdProv(@PathVariable("idproveedor") int idproveedor){
        if(!provService.existByIdProv(idproveedor))
            return new ResponseEntity(new Mensaje("No existe el proveedor"), HttpStatus.NOT_FOUND);
        Prov prov = provService.getOneProv(idproveedor).get();
        return new ResponseEntity(prov, HttpStatus.OK);
    }
    @PostMapping("/createproveedor")
    public ResponseEntity<?> create(@RequestBody ProvDto provDto){
        if(StringUtils.isBlank(provDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(provDto.getDireccion()))
            return new ResponseEntity(new Mensaje("La direccion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(provDto.getTelefono()))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        if (provService.existByIdNombreProv(provDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Prov prov = new Prov(provDto.getNombre(), provDto.getDireccion(), provDto.getTelefono());
        provService.save(prov);
        return new ResponseEntity(new Mensaje("Proveedor creado"), HttpStatus.OK);
    }
    @PutMapping("updateproveedor/{idproveedor}")
    public ResponseEntity<?> update(@PathVariable("idproveedor")int idproveedor, @RequestBody ProvDto provDto){
        if(!provService.existByIdProv(idproveedor))
            return new ResponseEntity(new Mensaje("No existe el proveedor"), HttpStatus.NOT_FOUND);
        if (provService.existByIdNombreProv(provDto.getNombre()) && provService.getByNombreProv(provDto.getNombre()).get().getIdproveedor() != idproveedor)
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(provDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(provDto.getDireccion()))
            return new ResponseEntity(new Mensaje("La direccion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(provDto.getTelefono()))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        Prov prov = provService.getOneProv(idproveedor).get();
        prov.setNombre(provDto.getNombre());
        prov.setDireccion(provDto.getDireccion());
        prov.setTelefono(provDto.getTelefono());
        provService.save(prov);
        return new ResponseEntity(new Mensaje("Proveedor actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteproveedor/{idproveedor}")
    public ResponseEntity<?> deleteProv(@PathVariable("idproveedor")int idproveedor){
        if(!provService.existByIdProv(idproveedor))
            return new ResponseEntity(new Mensaje("No existe el proveedor"), HttpStatus.NOT_FOUND);
        provService.delete(idproveedor);
        return new ResponseEntity(new Mensaje("Proveedor eliminado"), HttpStatus.OK);
    }

    //productos
    @GetMapping("/listapproductos")
    public ResponseEntity<List<Producto>> listProd(){
        List<Producto> listProd = productoService.list();
        return new ResponseEntity(listProd, HttpStatus.OK);
    }
    @GetMapping("/detailproducto/{idproducto}")
    public  ResponseEntity<Producto> getByIdProd(@PathVariable("idproducto") int idproducto){
        if(!productoService.existByIdProd(idproducto))
            return new ResponseEntity(new Mensaje("No existe el producto"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getOneProd(idproducto).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    @GetMapping("/detailnombreproducto/{nombre}")
    public  ResponseEntity<Producto> getByNombreProd(@PathVariable("nombre") String nombre){
        if(!productoService.existByNombreProd(nombre))
            return new ResponseEntity(new Mensaje("No existe el nombre del producto"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getByNombreProd(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    @PostMapping("/createproducto")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto){
        if (!provService.existByIdProv(productoDto.getIdproveedor()))
            return new ResponseEntity(new Mensaje("El proveedor no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (productoDto.getPrecio()<=0 || productoDto.getPrecio() == null)
            return new ResponseEntity(new Mensaje("El precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productoDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (productoDto.getStock()<0)
            return new ResponseEntity(new Mensaje("El stock debe ser mayor o igual a 0"), HttpStatus.BAD_REQUEST);
        Producto producto = new Producto(productoDto.getIdproveedor(),productoDto.getNombre(), productoDto.getPrecio(), productoDto.getDescripcion(), productoDto.getStock());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto creado"), HttpStatus.OK);
    }
    @PutMapping("updateproducto/{idproducto}")
    public ResponseEntity<?> update(@PathVariable("idproducto")int idproducto, @RequestBody ProductoDto productoDto){
        if(!productoService.existByIdProd(idproducto))
            return new ResponseEntity(new Mensaje("No existe el producto"), HttpStatus.NOT_FOUND);
        if(!provService.existByIdProv(productoDto.getIdproveedor()))
            return new ResponseEntity(new Mensaje("No existe el proveedor"), HttpStatus.NOT_FOUND);
        if (productoDto.getIdproveedor()<=0)
            return new ResponseEntity(new Mensaje("El proveedor es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (productoDto.getPrecio()<=0 || productoDto.getPrecio() == null)
            return new ResponseEntity(new Mensaje("El precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productoDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if (productoDto.getStock()<0)
            return new ResponseEntity(new Mensaje("El stock debe ser mayor o igual a 0"), HttpStatus.BAD_REQUEST);
        Producto producto = productoService.getOneProd(idproducto).get();
        producto.setIdproveedor(productoDto.getIdproveedor());
        producto.setNombre(producto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setStock(productoDto.getStock());
        productoService.save(producto);
        return new ResponseEntity(new Mensaje("Producto actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/deleteproducto/{idproducto}")
    public ResponseEntity<?> deleteProd(@PathVariable("idproducto")int idproducto){
        if(!productoService.existByIdProd(idproducto))
            return new ResponseEntity(new Mensaje("No existe el producto"), HttpStatus.NOT_FOUND);
        productoService.delete(idproducto);
        return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
    }

    //Usuarios

    @GetMapping("/listausuarios")
    public ResponseEntity<List<Usuario>> listUsr(){
        List<Usuario> listUsr = usuarioService.list();
        return new ResponseEntity(listUsr, HttpStatus.OK);
    }
    @GetMapping("/detailusuario/{idusuario}")
    public  ResponseEntity<Usuario> getByIdUsr(@PathVariable("idusuario") int idusuario){
        if(!usuarioService.existByIdUsr(idusuario))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOneUsr(idusuario).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/createusuario")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){
        if (usuarioService.existByUsername(usuarioDto.getUsername()))
            return new ResponseEntity(new Mensaje("El usuario ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuarioDto.getUsername()))
            return new ResponseEntity(new Mensaje("El nombre de usuario es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(usuarioDto.getPassword()))
            return new ResponseEntity(new Mensaje("La contraseña es obligatoria"), HttpStatus.BAD_REQUEST);
        if (usuarioDto.getPassword().length()<8)
            return new ResponseEntity(new Mensaje("La contraseña debe tener al menos 8 caracteres"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(usuarioDto.getUsername(),usuarioDto.getPassword());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);
    }
    @PutMapping("updateusuario/{idusuario}")
    public ResponseEntity<?> update(@PathVariable("idusuario")int idusuario, @RequestBody UsuarioDto usuarioDto){
        if(!usuarioService.existByIdUsr(idusuario))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        if(usuarioService.existByUsername(usuarioDto.getUsername()))
            return new ResponseEntity(new Mensaje("EL usuario ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(usuarioDto.getUsername()))
            return new ResponseEntity(new Mensaje("El nombre de usuario es obligatorio"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(usuarioDto.getPassword()))
            return new ResponseEntity(new Mensaje("La contraseña es obligatoria"), HttpStatus.BAD_REQUEST);
        Usuario usuario = usuarioService.getOneUsr(idusuario).get();
        usuario.setUsername(usuarioDto.getUsername());
        usuario.setPassword(usuarioDto.getPassword());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/deleteuser/{idusuario}")
    public ResponseEntity<?> deleteUsr(@PathVariable("idusuario")int idusuario){
        if(!usuarioService.existByIdUsr(idusuario))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        usuarioService.delete(idusuario);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }

    //ROLES
    @GetMapping("/listaroles")
    public ResponseEntity<List<Rol>> listRol(){
        List<Rol> listRol = rolService.list();
        return new ResponseEntity(listRol, HttpStatus.OK);
    }
    @PostMapping("/createrol")
    public ResponseEntity<?> create(@RequestBody RolDto rolDto){
        if (!usuarioService.existByIdUsr(rolDto.getIdusuario()))
            return new ResponseEntity(new Mensaje("El usuario no existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(rolDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (rolDto.getIdusuario()<=0)
            return new ResponseEntity(new Mensaje("El usuario es obligatorio"), HttpStatus.BAD_REQUEST);
        Rol rol = new Rol(rolDto.getNombre(),rolDto.getIdusuario());
        rolService.save(rol);
        return new ResponseEntity(new Mensaje("Rol creado"), HttpStatus.OK);
    }
    @PutMapping("updaterol/{idrol}")
    public ResponseEntity<?> update(@PathVariable("idrol")int idrol, @RequestBody RolDto rolDto){
        if(!rolService.existByIdRol(rolDto.getIdusuario()))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(rolDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (rolDto.getIdusuario()<=0)
            return new ResponseEntity(new Mensaje("El usuario es obligatorio"), HttpStatus.BAD_REQUEST);
        Rol rol = rolService.getOneRol(idrol).get();
        rol.setNombre(rolDto.getNombre());
        rol.setIdusuario(rolDto.getIdusuario());
        rolService.save(rol);
        return new ResponseEntity(new Mensaje("Rol actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/deleterol/{idrol}")
    public ResponseEntity<?> deleteRol(@PathVariable("idrol")int idrol){
        if(!rolService.existByIdRol(idrol))
            return new ResponseEntity(new Mensaje("No existe el rol"), HttpStatus.NOT_FOUND);
        rolService.delete(idrol);
        return new ResponseEntity(new Mensaje("Rol eliminado"), HttpStatus.OK);
    }





}
