import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { DetalleClienteComponent } from './pages/lista-cliente/detalle-cliente.component';
import { EditarClienteComponent } from './pages/lista-cliente/editar-cliente.component';
import { ListaClienteComponent } from './pages/lista-cliente/lista-cliente.component';
import { NuevoClienteComponent } from './pages/lista-cliente/nuevo-cliente.component';
import { ListaDetalleventaComponent } from './pages/lista-detalleventa/lista-detalleventa.component';
import { DetalleEmpleadoComponent } from './pages/lista-empleado/detalle-empleado.component';
import { EditarEmpleadoComponent } from './pages/lista-empleado/editar-empleado.component';
import { ListaEmpleadoComponent } from './pages/lista-empleado/lista-empleado.component';
import { NuevoEmpleadoComponent } from './pages/lista-empleado/nuevo-empleado.component';
import { DetalleProductoComponent } from './pages/lista-producto/detalle-producto.component';
import { EditarProductoComponent } from './pages/lista-producto/editar-producto.component';
import { ListaProductoComponent } from './pages/lista-producto/lista-producto.component';
import { NuevoProductoComponent } from './pages/lista-producto/nuevo-producto.component';
import { DetalleProvComponent } from './pages/lista-prov/detalle-prov.component';
import { EditarProvComponent } from './pages/lista-prov/editar-prov.component';
import { ListaProvComponent } from './pages/lista-prov/lista-prov.component';
import { NuevoProvComponent } from './pages/lista-prov/nuevo-prov.component';
import { EditarPuestoComponent } from './pages/lista-puesto/editar-puesto.component';
import { ListaPuestoComponent } from './pages/lista-puesto/lista-puesto.component';
import { NuevoPuestoComponent } from './pages/lista-puesto/nuevo-puesto.component';
import { EditarRolComponent } from './pages/lista-rol/editar-rol.component';
import { ListaRolComponent } from './pages/lista-rol/lista-rol.component';
import { NuevoRolComponent } from './pages/lista-rol/nuevo-rol.component';
import { DetalleUsuarioComponent } from './pages/lista-usuario/detalle-usuario.component';
import { EditarUsuarioComponent } from './pages/lista-usuario/editar-usuario.component';
import { ListaUsuarioComponent } from './pages/lista-usuario/lista-usuario.component';
import { NuevoUsuarioComponent } from './pages/lista-usuario/nuevo-usuario.component';
import { DetalleVentaComponent } from './pages/lista-venta/detalle-venta.component';
import { ListaVentaComponent } from './pages/lista-venta/lista-venta.component';
import { NuevoVentaComponent } from './pages/lista-venta/nuevo-venta.component';

const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'detalle-cliente/:nombre', component: DetalleClienteComponent},//cliente
  {path: 'detalle-cliente/:idcliente', component: DetalleClienteComponent},
  {path: 'nuevo-cliente', component: NuevoClienteComponent},
  {path: 'editar-cliente/:idcliente', component: EditarClienteComponent},
  {path: 'lista-cliente', component: ListaClienteComponent},

  {path: 'lista-empleado', component: ListaEmpleadoComponent},//empleado
  {path: 'detalle-empleado/idempleado:', component: DetalleEmpleadoComponent},
  {path: 'editar-empleado/:idempleado', component: EditarEmpleadoComponent},
  {path: 'nuevo-empleado', component: NuevoEmpleadoComponent},

  {path: 'lista-producto', component: ListaProductoComponent},//producto
  {path: 'nuevo-producto', component: NuevoProductoComponent},
  {path: 'editarproducto/:idproducto', component: EditarProductoComponent},
  {path: 'detail-producto/:idproducto', component: DetalleProductoComponent},
  {path: 'detail-producto/:nombre', component: DetalleProductoComponent},

  {path: 'lista-prov', component: ListaProvComponent},//proveedor
  {path: 'detalle-prov/:idproveedor', component: DetalleProvComponent},
  {path: 'editar-prov/:idproveedor', component: EditarProvComponent},
  {path: 'nuevo-prov', component: NuevoProvComponent},


  {path: 'editar-puesto/:idpuesto', component: EditarPuestoComponent},//puesto
  {path: 'lista-puesto', component: ListaPuestoComponent},
  {path: 'nuevo-puesto', component: NuevoPuestoComponent},


  {path: 'lista-rol', component: ListaRolComponent},//rol
  {path: 'editar-rol/:idrol', component: EditarRolComponent},
  {path: 'nuevo-rol', component: NuevoRolComponent},

  {path: 'lista-usuario', component: ListaUsuarioComponent},//usuario
  {path: 'detalle-usuario/:idusuario', component: DetalleUsuarioComponent},
  {path: 'editar-usuario/:idusuario', component: EditarUsuarioComponent},
  {path: 'nuevo-usuario', component: NuevoUsuarioComponent},

  {path: 'lista-venta', component: ListaVentaComponent},//venta
  {path: 'nuevo-venta', component: NuevoVentaComponent},
  {path: 'detalle-venta', component: DetalleVentaComponent},  

  {path: 'lista-detalleventa', component: ListaDetalleventaComponent},//detalleventa
  {path: '**', redirectTo: '', pathMatch: 'full'},
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
