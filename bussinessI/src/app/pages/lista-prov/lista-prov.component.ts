import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Prov } from 'src/app/models/prov';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-prov',
  templateUrl: './lista-prov.component.html',
  styleUrls:['./lista-prov.component.css']
})
export class ListaProvComponent implements OnInit {
  prov: Prov[]=[];
  constructor(private productoService: ProductoService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cargarProv();
  }

  cargarProv(): void{
    this.productoService.listaProv().subscribe(
      data =>{
        this.prov=data;
      },
      err =>{
        console.log(err);
      }
    );
  }

  borrarP(idproveedor: number) {
    this.productoService.deleteproveedor(idproveedor).subscribe(
      data => {
        this.toastr.success('Proveedor Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarProv();
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
