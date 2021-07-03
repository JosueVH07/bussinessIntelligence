import { Component, OnInit } from '@angular/core';
import { Prov } from 'src/app/models/prov';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-lista-prov',
  templateUrl: './lista-prov.component.html',
  styleUrls:['./lista-prov.component.css']
})
export class ListaProvComponent implements OnInit {
  prov: Prov[]=[];
  constructor(private productoService: ProductoService) { }

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

}
