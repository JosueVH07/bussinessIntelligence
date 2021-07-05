import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Puesto } from 'src/app/models/puesto';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-puesto',
  templateUrl: './lista-puesto.component.html',
  styleUrls: ['./lista-puesto.component.css']
})
export class ListaPuestoComponent implements OnInit {
  puesto: Puesto[]=[];
  constructor(private productoService: ProductoService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cargarPuesto();
  }

  cargarPuesto(): void{
    this.productoService.listapuesto().subscribe(
      data =>{
        this.puesto=data;
      },
      err =>{
        console.log(err);
      }
    );
  }
  borrarP(idpuesto: number) {
    this.productoService.deletepuesto(idpuesto).subscribe(
      data => {
        this.toastr.success('Puesto Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarPuesto();
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
