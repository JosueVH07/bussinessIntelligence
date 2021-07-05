import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/models/usuario';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.components.css']
})
export class ListaUsuarioComponent implements OnInit {
  usuario: Usuario[]=[];
  constructor(private productoService: ProductoService, private toastr: ToastrService) { }

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
  borrarP(idusuario: number) {
    this.productoService.deleteuser(idusuario).subscribe(
      data => {
        this.toastr.success('Usuario Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarUsr();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
      }
    );
  }
}
