export class Cliente {
    idcliente: number;
    nombre: string;
    telefono: string;
    correo: string;
    direccion: string;

    constructor(idcliente:number, nombre: string, telefono: string, correo: string, direccion: string){
        this.idcliente=idcliente;
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;
        this.direccion=direccion;
    }
}


