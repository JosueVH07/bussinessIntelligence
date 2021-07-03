import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/models/empleado';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls:['./lista-empleado.component.css']
})
export class ListaEmpleadoComponent implements OnInit {
  empleado: Empleado[]=[];
  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.cargarEmp();
  }

  cargarEmp(): void{
    this.productoService.listaempleado().subscribe(
      data =>{
        this.empleado=data;
      },
      err =>{
        console.log(err);
      }
    );
  }
}
