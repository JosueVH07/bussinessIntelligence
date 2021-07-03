export class Puesto {
    idpuesto?: number;
    rolempleado: string;
    descripcion: string;

    constructor(rolempleado: string, descripcion: string){
        this.rolempleado=rolempleado;
        this.descripcion=descripcion;
    }
}
