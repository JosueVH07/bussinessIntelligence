import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-producto',
  templateUrl: './lista-producto.component.html',
  styleUrls: ['./lista-producto.component.css']
})
export class ListaProductoComponent implements OnInit {
  producto: Producto[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarProd();
  }
  cargarProd(): void{
    this.productoService.listapproductos().subscribe(
      data =>{
        this.producto=data;
      },
      err =>{
        console.log(err);
      }
    );
  }

}
