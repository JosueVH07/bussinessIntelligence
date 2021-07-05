import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Empleado } from 'src/app/models/empleado';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-empleado',
  templateUrl: './nuevo-empleado.component.html',
  styleUrls: ['./nuevo-empleado.component.css']
})
export class NuevoEmpleadoComponent implements OnInit {
  idempleado:number=1;
  idpuesto:number=1;
  idusuario:number=1;
  idrol:number=1;
  nombre='';
  telefono='';
  direccion='';
  correo='';

  constructor(private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const empleado = new Empleado(this.idempleado ,this.idpuesto, this.idusuario, this.idrol, this.nombre, this.telefono, this.direccion, this.correo);
    this.productoService.createempleado(empleado).subscribe(
      data => {
        this.toastr.success('Empleado Registrado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-empleado']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-empleado']);
      } 
    );
  }


}
