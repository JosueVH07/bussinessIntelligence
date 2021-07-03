import { Component, OnInit } from '@angular/core';
import { Detalleventa } from 'src/app/models/detalleventa';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-detalleventa',
  templateUrl: './lista-detalleventa.component.html',
  styleUrls:['./lista-detalleventa.components.css']
})
export class ListaDetalleventaComponent implements OnInit {
  
  detalleventas: Detalleventa[]=[];

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarDetalleventa();
  }
  cargarDetalleventa(): void{
    this.productoService.listaDV().subscribe(
      data => {
        this.detalleventas=data;
      },
      err =>{
        console.log(err)
      }
    );
  }

  

}
