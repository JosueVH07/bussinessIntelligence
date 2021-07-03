import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaClienteComponent } from './pages/lista-cliente/lista-cliente.component';
import { ListaVentaComponent } from './pages/lista-venta/lista-venta.component';
import { ListaDetalleventaComponent } from './pages/lista-detalleventa/lista-detalleventa.component';
import { ListaProductoComponent } from './pages/lista-producto/lista-producto.component';
import { ListaProvComponent } from './pages/lista-prov/lista-prov.component';
import { ListaPuestoComponent } from './pages/lista-puesto/lista-puesto.component';
import { ListaEmpleadoComponent } from './pages/lista-empleado/lista-empleado.component';
import { ListaUsuarioComponent } from './pages/lista-usuario/lista-usuario.component';
import { ListaRolComponent } from './pages/lista-rol/lista-rol.component';
import { DetalleClienteComponent } from './pages/lista-cliente/detalle-cliente.component';
import { NuevoClienteComponent } from './pages/lista-cliente/nuevo-cliente.component';
import { EditarClienteComponent } from './pages/lista-cliente/editar-cliente.component';
import { DetalleVentaComponent } from './pages/lista-venta/detalle-venta.component';
import { NuevoVentaComponent } from './pages/lista-venta/nuevo-venta.component';
import { DetalleProvComponent } from './pages/lista-prov/detalle-prov.component';
import { NuevoProvComponent } from './pages/lista-prov/nuevo-prov.component';
import { EditarProvComponent } from './pages/lista-prov/editar-prov.component';
import { DetalleProductoComponent } from './pages/lista-producto/detalle-producto.component';
import { NuevoProductoComponent } from './pages/lista-producto/nuevo-producto.component';
import { EditarProductoComponent } from './pages/lista-producto/editar-producto.component';
import { DetalleUsuarioComponent } from './pages/lista-usuario/detalle-usuario.component';
import { NuevoUsuarioComponent } from './pages/lista-usuario/nuevo-usuario.component';
import { EditarUsuarioComponent } from './pages/lista-usuario/editar-usuario.component';
import { NuevoRolComponent } from './pages/lista-rol/nuevo-rol.component';
import { EditarRolComponent } from './pages/lista-rol/editar-rol.component';
import { NuevoPuestoComponent } from './pages/lista-puesto/nuevo-puesto.component';
import { EditarPuestoComponent } from './pages/lista-puesto/editar-puesto.component';
import { DetalleEmpleadoComponent } from './pages/lista-empleado/detalle-empleado.component';
import { NuevoEmpleadoComponent } from './pages/lista-empleado/nuevo-empleado.component';
import { EditarEmpleadoComponent } from './pages/lista-empleado/editar-empleado.component';

import {HttpClientModule} from '@angular/common/http'
import {FormsModule} from '@angular/forms'
//external
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { FooterComponent } from './pages/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NavbarProductoComponent } from './components/navbar-producto/navbar-producto.component';
import { NavbarClientesComponent } from './components/navbar-clientes/navbar-clientes.component';
import { NavbarEmpleadoComponent } from './components/navbar-empleado/navbar-empleado.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaClienteComponent,
    ListaVentaComponent,
    ListaDetalleventaComponent,
    ListaProductoComponent,
    ListaProvComponent,
    ListaPuestoComponent,
    ListaEmpleadoComponent,
    ListaUsuarioComponent,
    ListaRolComponent,
    DetalleClienteComponent,
    NuevoClienteComponent,
    EditarClienteComponent,
    DetalleVentaComponent,
    NuevoVentaComponent,
    DetalleProvComponent,
    NuevoProvComponent,
    EditarProvComponent,
    DetalleProductoComponent,
    NuevoProductoComponent,
    EditarProductoComponent,
    DetalleUsuarioComponent,
    NuevoUsuarioComponent,
    EditarUsuarioComponent,
    NuevoRolComponent,
    EditarRolComponent,
    NuevoPuestoComponent,
    EditarPuestoComponent,
    DetalleEmpleadoComponent,
    NuevoEmpleadoComponent,
    EditarEmpleadoComponent,
    DashboardComponent,
    NavbarComponent,
    FooterComponent,
    NavbarProductoComponent,
    NavbarClientesComponent,
    NavbarEmpleadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
