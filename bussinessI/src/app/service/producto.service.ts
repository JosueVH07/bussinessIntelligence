import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';
import { Detalleventa } from '../models/detalleventa';
import { Empleado } from '../models/empleado';
import { Producto } from '../models/producto';
import { Prov } from '../models/prov';
import { Puesto } from '../models/puesto';
import { Rol } from '../models/rol';
import { Usuario } from '../models/usuario';
import { Venta } from '../models/venta';


@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  productoURl = 'http://localhost:8080/producto/';

  constructor(private httpClient: HttpClient) { }

  //clientes
  public listaclientes(): Observable<Cliente[]>{
    return this.httpClient.get<Cliente[]>(this.productoURl + 'listaclientes');
  }
  public detailcliente(idcliente: number): Observable<Cliente>{
    return this.httpClient.get<Cliente>(this.productoURl + `detailcliente/${idcliente}`);
  }
  public detailclientename(nombre: string): Observable<Cliente>{
    return this.httpClient.get<Cliente>(this.productoURl + `detailclientename/${nombre}`);
  }
  public createcliente(cliente: Cliente):Observable<any>{
    return this.httpClient.post<any>(this.productoURl + 'createcliente', cliente);
  }
  public updatecliente(idcliente: number,cliente: Cliente):Observable<any>{
    return this.httpClient.put<any>(this.productoURl + `updatecliente/${idcliente}`, cliente);
  }
  public deletecliente(idcliente: number):Observable<any>{
    return this.httpClient.delete<any>(this.productoURl + `deletecliente/${idcliente}`);
  }

  //ventas
  public listaV(): Observable<Venta[]>{
    return this.httpClient.get<Venta[]>(this.productoURl + 'listaventas');
  }
  public detaiventa(idventa: number): Observable<Venta>{
    return this.httpClient.get<Venta>(this.productoURl + `detaiventa/${idventa}`);
  }
  public createventa(venta: Venta):Observable<any>{
    return this.httpClient.post<any>(this.productoURl + 'createventa', venta);
  }

//proveedores = ok
public listaProv(): Observable<Prov[]>{
  return this.httpClient.get<Prov[]>(this.productoURl + 'listaproveedores');
}
public detailproveedor(idproveedor: number): Observable<Prov>{
  return this.httpClient.get<Prov>(this.productoURl + `detailproveedor/${idproveedor}`);
}
public createproveedor(prov: Prov):Observable<any>{
  return this.httpClient.post<any>(this.productoURl + 'createproveedor', prov);
}
public updateproveedor(idproveedor: number,prov: Prov):Observable<any>{
  return this.httpClient.put<any>(this.productoURl + `updateproveedor/${idproveedor}`, prov);
}
public deleteproveedor(idproveedor: number):Observable<any>{
  return this.httpClient.delete<any>(this.productoURl + `deleteproveedor/${idproveedor}`);
}

//productos
public listapproductos(): Observable<Producto[]>{
  return this.httpClient.get<Producto[]>(this.productoURl + 'listapproductos');
}
public detailproducto(idproducto: number): Observable<Producto>{
  return this.httpClient.get<Producto>(this.productoURl + `detailproducto/${idproducto}`);
}
public detailnombreproducto(nombre: string): Observable<Producto>{
  return this.httpClient.get<Producto>(this.productoURl + `detailnombreproducto/${nombre}`);
}
public createproducto(producto: Producto):Observable<any>{
  return this.httpClient.post<any>(this.productoURl + 'createproducto', producto);
}
public updateproducto(idproducto: number,producto: Producto):Observable<any>{
  return this.httpClient.put<any>(this.productoURl + `updateproducto/${idproducto}`, producto);
}
public deleteproducto(idproducto: number):Observable<any>{
  return this.httpClient.delete<any>(this.productoURl + `deleteproducto/${idproducto}`);
}

//usuarios
public listausuarios(): Observable<Usuario[]>{
  return this.httpClient.get<Usuario[]>(this.productoURl + 'listausuarios');
}
public detailusuario(idusuario: number): Observable<Usuario>{
  return this.httpClient.get<Usuario>(this.productoURl + `detailusuario/${idusuario}`);
}
public createusuario(usuario: Usuario):Observable<any>{
  return this.httpClient.post<any>(this.productoURl + 'createusuario', usuario);
}
public updateusuario(idusuario: number,usuario: Usuario):Observable<any>{
  return this.httpClient.put<any>(this.productoURl + `updateusuario/${idusuario}`, usuario);
}
public deleteuser(idusuario: number):Observable<any>{
  return this.httpClient.delete<any>(this.productoURl + `deleteuser/${idusuario}`);
}

//roles
public listaroles(): Observable<Rol[]>{
  return this.httpClient.get<Rol[]>(this.productoURl + 'listaroles');
}
public createrol(rol: Rol):Observable<any>{
  return this.httpClient.post<any>(this.productoURl + 'createrol', rol);
}
public updaterol(idrol: number,rol: Rol):Observable<any>{
  return this.httpClient.put<any>(this.productoURl + `updaterol/${idrol}`, rol);
}
public deleterol(idrol: number):Observable<any>{
  return this.httpClient.delete<any>(this.productoURl + `deleterol/${idrol}`);
}

//puesto
public listapuesto(): Observable<Puesto[]>{
  return this.httpClient.get<Puesto[]>(this.productoURl + 'listapuesto');
}
public createpuesto(puesto: Puesto):Observable<any>{
  return this.httpClient.post<any>(this.productoURl + 'createpuesto', puesto);
}
public updatepuesto(idpuesto: number,puesto: Puesto):Observable<any>{
  return this.httpClient.put<any>(this.productoURl + `updatepuesto/${idpuesto}`, puesto);
}
public deletepuesto(idpuesto: number):Observable<any>{
  return this.httpClient.delete<any>(this.productoURl + `deletepuesto/${idpuesto}`);
}

//Empleado
public listaempleado(): Observable<Empleado[]>{
  return this.httpClient.get<Empleado[]>(this.productoURl + 'listaempleado');
}
public detailempleado(idempleado: number): Observable<Empleado>{
  return this.httpClient.get<Empleado>(this.productoURl + `detailempleado/${idempleado}`);
}
public createempleado(empleado: Empleado):Observable<any>{
  return this.httpClient.post<any>(this.productoURl + 'createempleado', empleado);
}
public updateempleado(idempleado: number,empleado: Empleado):Observable<any>{
  return this.httpClient.put<any>(this.productoURl + `updateempleado/${idempleado}`, empleado);
}
public deleteempleado(idempleado: number):Observable<any>{
  return this.httpClient.delete<any>(this.productoURl + `deleteempleado/${idempleado}`);
}

  //Detalle-venta =ok
  public listaDV(): Observable<Detalleventa[]>{
    return this.httpClient.get<Detalleventa[]>(this.productoURl + 'detalleventa');
  }
  
  
  
}
