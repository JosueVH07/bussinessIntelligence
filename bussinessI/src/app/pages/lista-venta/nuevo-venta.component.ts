import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Venta } from 'src/app/models/venta';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-venta',
  templateUrl: './nuevo-venta.component.html',
  styleUrls: ['./nuevo-venta.component.css']
})
export class NuevoVentaComponent implements OnInit {
  idventa: number=1;
  idcliente:number=1;
  fecha='';
  idproducto:number=1;
  cantidad:number=1;
  precio: number=1;
  total: number=1;
  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const venta = new Venta(this.idventa ,this.idcliente, this.fecha, this.idproducto, this.cantidad, this.precio, this.total);
    this.productoService.createventa(venta).subscribe(
      data => {
        this.toastr.success('Venta Realizada', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-venta']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-venta']);
      } 
    );
  }

}
