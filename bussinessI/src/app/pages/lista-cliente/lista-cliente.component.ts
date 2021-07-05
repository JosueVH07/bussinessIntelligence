import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrls:['./lista-cliente.components.css']
})
export class ListaClienteComponent implements OnInit {

  cliente: Cliente[]=[];
  constructor(private productoService: ProductoService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cargarClientes();
  }

  cargarClientes(): void{
    this.productoService.listaclientes().subscribe(
      data =>{
        this.cliente=data;
      },
      err =>{
        console.log(err);
      }
    );
  }

  borrarP(idcliente: number) {
    this.productoService.deletecliente(idcliente).subscribe(
      data => {
        this.toastr.success('Cliente Eliminado', 'OK', {
          timeOut: 3000
        });
        this.cargarClientes();
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
