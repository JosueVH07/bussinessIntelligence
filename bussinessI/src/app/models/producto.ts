export class Producto {
    idproducto?: number;
    idproveedor: number;
    nombre: string;
    precio: number;
    descripcion: string;
    stock: number;

    constructor(idproveedor: number, nombre: string, precio: number, descripcion: string, stock: number){
        this.idproveedor=idproveedor;
        this.nombre=nombre;
        this.precio=precio;
        this.descripcion=descripcion;
        this.stock=stock;
    }
}
