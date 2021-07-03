export class Prov {
    idproveedor?: number;
    nombre: string;
    direccion: string;
    telefono: string;

    constructor(nombre: string, direccion: string, telefono: string) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
