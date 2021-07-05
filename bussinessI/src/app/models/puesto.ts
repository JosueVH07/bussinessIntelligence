export class Puesto {
    idpuesto: number;
    rolempleado: string;
    descripcion: string;

    constructor(idpuesto:number ,rolempleado: string, descripcion: string){
        this.idpuesto=idpuesto;
        this.rolempleado=rolempleado;
        this.descripcion=descripcion;
    }
}
