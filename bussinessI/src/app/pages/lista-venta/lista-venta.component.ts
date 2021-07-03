import { Component, OnInit } from '@angular/core';
import { Venta } from 'src/app/models/venta';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-venta',
  templateUrl: './lista-venta.component.html',
  styleUrls: ['./lista-venta-component.css']
})
export class ListaVentaComponent implements OnInit {
  venta: Venta[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarVenta();
  }
  cargarVenta(): void{
    this.productoService.listaV().subscribe(
      data =>{
        this.venta=data;
      },
      err =>{
        console.log(err);
      }
    );
  }
}
