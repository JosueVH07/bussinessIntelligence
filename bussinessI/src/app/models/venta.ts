export class Venta {
    idventa?: number;
    idcliente:number;
    fecha:string;
    idproducto:number;
    cantidad:number;
    precio:number;
    total:number;

    constructor(idcliente:number, fecha:string, idproducto:number, cantidad:number, precio:number, total:number){
        this.idcliente=idcliente;
        this.fecha=fecha;
        this.idproducto=idproducto;
        this.cantidad=cantidad;
        this.precio=precio;
        this.total=total;
    }
}
