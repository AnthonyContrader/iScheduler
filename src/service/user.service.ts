import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable()
export class UserService extends AbstractService<UserDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'user';
    this.micro = 'microservice1';
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

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }
  getAll(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>('http://localhost:8080/api/' + this.type + 's', {
      headers: {
        Authorization: this.auth()
      }
    });
  }

  read(login: string): Observable<UserDTO> {
    return this.http.get<UserDTO>('http://localhost:' + this.port + '/api/' + this.type + 's/' + login, {
      headers: {
        Authorization: this.auth()
      }
    });
  }

  delete(login: string): Observable<any> {
    return this.http.delete('http://localhost:' + this.port + '/api/' + this.type + 's/' + login, {
      headers: {
        Authorization: this.auth()
      }
    });
  }

  insert(dto: UserDTO): Observable<any> {
    return this.http.post('http://localhost:' + this.port + '/api/' + this.type + 's', dto, {
      headers: {
        Authorization: this.auth()
      }
    });
  }

  update(dto: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>('http://localhost:' + this.port + '/api/' + this.type + 's', dto, {
      headers: {
        Authorization: this.auth()
      }
    });

  }

}
