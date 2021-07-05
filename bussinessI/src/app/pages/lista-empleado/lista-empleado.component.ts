import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Empleado } from 'src/app/models/empleado';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls:['./lista-empleado.component.css']
})
export class ListaEmpleadoComponent implements OnInit {
  empleado: Empleado[]=[];
  constructor( private productoService: ProductoService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cargarEmp();
  }

  cargarEmp(): void{
    this.productoService.listaempleado().subscribe(
      data =>{
        this.empleado=data;
      },
      err =>{
        console.log(err);
      }
    );
  }

  borrarP(idempleado: number) {
    this.productoService.deleteempleado(idempleado).subscribe(
      data => {
        this.toastr.success('Empleado Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarEmp();
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
