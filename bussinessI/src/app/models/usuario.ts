export class Usuario {
    idusuario: number;
    username: string;
    password: string;

    constructor(idusuario:number, username: string, password: string){
        this.idusuario=idusuario;
        this.username=username;
        this.password=password;
    }
}
