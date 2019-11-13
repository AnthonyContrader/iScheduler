export class RegisterDTO {

    email: string;
    langKey: string;
    login: string;
    password: string;


    constructor(email: string,   login: string, password: string) {
        this.email = email;
        this.langKey = 'it';
        this.login= login;
        this.password= password;
    }
 
 }