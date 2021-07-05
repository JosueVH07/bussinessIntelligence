export class Detalleventa {
    iddetalleventa: number;
    idventa: number;
    idproducto: number;
    detalle: string;
    idempleado: number;

    constructor(iddetalleventa:number, idventa:number,idproducto:number, detalle:string, idempleado:number){
        this.iddetalleventa=iddetalleventa;
        this.idventa=idventa;
        this.idproducto=idproducto;
        this.detalle=detalle;
        this.idempleado=idempleado;
    }

}
