export class Detalleventa {
    iddetalleventa?: number;
    idventa: number;
    idproducto: number;
    detalle: string;
    idempleado: number;

    constructor(idventa:number,idproducto:number, detalle:string, idempleado:number){
        this.idventa=idventa;
        this.idproducto=idproducto;
        this.detalle=detalle;
        this.idempleado=idempleado;
    }

}
