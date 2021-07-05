import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Rol } from 'src/app/models/rol';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-rol',
  templateUrl: './nuevo-rol.component.html',
  styleUrls: ['./nuevo-rol.component.css']
})
export class NuevoRolComponent implements OnInit {
  idrol:number=1;
  nombre='';
  idusuario:number=1;
  constructor(    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const rol = new Rol(this.idrol ,this.nombre, this.idusuario);
    this.productoService.createrol(rol).subscribe(
      data => {
        this.toastr.success('Rol registrado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-rol']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-rol']);
      } 
    );
  }

}
