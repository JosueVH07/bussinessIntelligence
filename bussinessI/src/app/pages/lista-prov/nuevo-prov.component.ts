import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Prov } from 'src/app/models/prov';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-prov',
  templateUrl: './nuevo-prov.component.html',
  styleUrls: ['./nuevo-prov.component.css']
})
export class NuevoProvComponent implements OnInit {
  idproveedor:number=1;
  nombre='';
  direccion='';
  telefono='';
    
  constructor(private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const prov = new Prov(this.idproveedor ,this.nombre, this.direccion, this.telefono);
    this.productoService.createproveedor(prov).subscribe(
      data => {
        this.toastr.success('Proveedor Registrado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-prov']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-prov']);
      } 
    );
  }

}
