export class Rol {
    idrol?: number;
    nombre: string;
    idusuario: number;

    constructor(nombre: string, idusuario: number){
        this.nombre=nombre;
        this.idusuario=idusuario;
    }
}
