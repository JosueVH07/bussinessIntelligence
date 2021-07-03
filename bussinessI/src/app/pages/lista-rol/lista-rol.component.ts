import { Component, OnInit } from '@angular/core';
import { Rol } from 'src/app/models/rol';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-rol',
  templateUrl: './lista-rol.component.html',
  styleUrls: ['./lista-rol.component.css']
})
export class ListaRolComponent implements OnInit {
  rol: Rol[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarRol();
  }
  cargarRol(): void{
    this.productoService.listaroles().subscribe(
      data =>{
        this.rol=data;
      },
      err =>{
        console.log(err);
      }
    );
  }

}
