import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';

/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */
export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;
    port: string = '8080';
    micro: string;
    user: UserDTO;

    constructor(protected http: HttpClient) {
    }
    auth() {
        this.user = JSON.parse(localStorage.getItem('currentUser'));
        console.log("stampa user: "+localStorage.getItem('currentUser'))
        if(this.user) {
            return 'Bearer ' + this.user.authorities;
        } else {
            return '';
        }
      }

    getAll(): Observable<DTO[]> {
        return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + 's');
    }

    read(login: string): Observable<DTO> {
        return this.http.get<DTO>('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + 's/' + login);
    }

    delete(login: string): Observable<any> {
        return this.http.delete('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + 's/' + login);
    }

    insert(dto: DTO): Observable<any> {
        return this.http.post('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + 's', dto);
    }

    update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + 's', dto);

    }

}