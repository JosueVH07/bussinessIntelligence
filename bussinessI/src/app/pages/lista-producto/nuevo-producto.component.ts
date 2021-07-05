import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-producto',
  templateUrl: './nuevo-producto.component.html',
  styleUrls: ['./nuevo-producto.component.css']
})
export class NuevoProductoComponent implements OnInit {
  idproducto: number = 1;
  idproveedor: number = 1;
  nombre = '';
  precio: number = 1;
  descripcion = '';
  stock: number = 1;


  constructor(
    private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const producto = new Producto(this.idproducto ,this.idproveedor, this.nombre, this.precio, this.descripcion, this.stock);
    this.productoService.createproducto(producto).subscribe(
      data => {
        this.toastr.success('Producto Creado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-producto']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-producto']);
      } 
    );
  }

}
