export class Empleado {
    idempleado: number;
    idpuesto:number;
    idusuario: number;
    idrol: number;
    nombre: string;
    telefono: string;
    direccion: string;
    correo: string;

    constructor(idempleado:number, idpuesto:number, idusuario: number,  idrol: number, nombre: string, telefono: string, direccion: string, correo: string){
        this.idempleado=idempleado;
        this.idpuesto=idpuesto;
        this.idusuario=idusuario;
        this.idrol=idrol;
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.correo=correo;
    }
}
