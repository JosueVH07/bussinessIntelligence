export class Prov {
    idproveedor: number;
    nombre: string;
    direccion: string;
    telefono: string;

    constructor(idproveedor:number, nombre: string, direccion: string, telefono: string) {
        this.idproveedor=idproveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
