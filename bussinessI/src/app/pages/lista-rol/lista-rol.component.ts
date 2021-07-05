import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Rol } from 'src/app/models/rol';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-rol',
  templateUrl: './lista-rol.component.html',
  styleUrls: ['./lista-rol.component.css']
})
export class ListaRolComponent implements OnInit {
  rol: Rol[]=[];
  constructor(private productoService: ProductoService, private toastr: ToastrService) { }

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
  borrarP(idrol: number) {
    this.productoService.deleterol(idrol).subscribe(
      data => {
        this.toastr.success('Rol Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarRol();
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
