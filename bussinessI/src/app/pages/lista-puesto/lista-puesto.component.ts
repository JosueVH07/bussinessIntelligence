import { Component, OnInit } from '@angular/core';
import { Puesto } from 'src/app/models/puesto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-puesto',
  templateUrl: './lista-puesto.component.html',
  styleUrls: ['./lista-puesto.component.css']
})
export class ListaPuestoComponent implements OnInit {
  puesto: Puesto[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarPuesto();
  }

  cargarPuesto(): void{
    this.productoService.listapuesto().subscribe(
      data =>{
        this.puesto=data;
      },
      err =>{
        console.log(err);
      }
    );
  }
}
