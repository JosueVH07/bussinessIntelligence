import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/models/usuario';
import { ProductoService } from 'src/app/service/producto.service';

@Component({
  selector: 'app-nuevo-usuario',
  templateUrl: './nuevo-usuario.component.html',
  styleUrls: ['./nuevo-usuario.component.css']
})
export class NuevoUsuarioComponent implements OnInit {

  idusuario:number=1;
  username='';
  password=';'
  constructor(   private productoService: ProductoService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const usuario = new Usuario(this.idusuario ,this.username, this.password);
    this.productoService.createusuario(usuario).subscribe(
      data => {
        this.toastr.success('Usuario Registrado', 'OK', {
          timeOut: 3000
        });
        this.router.navigate(['/lista-usuario']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'FAIL', {
          timeOut: 3000,
          positionClass: 'toast-top-right'
        });
        this.router.navigate(['/lista-usuario']);
      } 
    );
  }
}
