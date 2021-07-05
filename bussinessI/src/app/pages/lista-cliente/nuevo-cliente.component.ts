import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-cliente',
  templateUrl: './nuevo-cliente.component.html',
  styleUrls: ['./nuevo-cliente.component.css']
})
export class NuevoClienteComponent implements OnInit {

  idcliente:number=1;
  nombre='';
  telefono='';
  correo='';
  direccion='';
  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const cliente = new Cliente(this.idcliente ,this.nombre, this.telefono, this.correo, this.direccion);
    this.productoService.createcliente(cliente).subscribe(
      data => {
        this.toastr.success('Cliente Creado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-cliente']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-cliente']);
      } 
    );
  }

}
