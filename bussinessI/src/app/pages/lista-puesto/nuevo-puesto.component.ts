import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Puesto } from 'src/app/models/puesto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-puesto',
  templateUrl: './nuevo-puesto.component.html',
  styleUrls: ['./nuevo-puesto.component.css']
})
export class NuevoPuestoComponent implements OnInit {
  idpuesto:number=1;
  rolempleado:string='';
  descripcion='';
  constructor(    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const puesto = new Puesto(this.idpuesto ,this.rolempleado, this.descripcion);
    this.productoService.createpuesto(puesto).subscribe(
      data => {
        this.toastr.success('Puesto Registrado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-puesto']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-puesto']);
      } 
    );
  }

}
