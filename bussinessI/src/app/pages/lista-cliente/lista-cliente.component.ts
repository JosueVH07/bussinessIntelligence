import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrls:['./lista-cliente.components.css']
})
export class ListaClienteComponent implements OnInit {

  cliente: Cliente[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarClientes();
  }

  cargarClientes(): void{
    this.productoService.listaclientes().subscribe(
      data =>{
        this.cliente=data;
      },
      err =>{
        console.log(err);
      }
    );
  }
  
 

}
