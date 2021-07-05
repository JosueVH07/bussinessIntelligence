import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-producto',
  templateUrl: './lista-producto.component.html',
  styleUrls: ['./lista-producto.component.css']
})
export class ListaProductoComponent implements OnInit {
  producto: Producto[] = [];
  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.cargarProd();
  }
  cargarProd(): void {
    this.productoService.listapproductos().subscribe(
      data => {
        this.producto = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrarP(idproducto: number) {
    this.productoService.deleteproducto(idproducto).subscribe(
      data => {
        this.toastr.success('Producto Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarProd();
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
