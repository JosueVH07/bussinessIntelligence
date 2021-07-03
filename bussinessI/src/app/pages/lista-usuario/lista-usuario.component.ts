import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.components.css']
})
export class ListaUsuarioComponent implements OnInit {
  usuario: Usuario[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarUsr();
  }

  cargarUsr(): void{
    this.productoService.listausuarios().subscribe(
      data =>{
        this.usuario=data;
      },
      err =>{
        console.log(err);
      }
    );
  }
}
