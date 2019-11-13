import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';
import { Observable, of } from 'rxjs';
import { LoginDTO } from 'src/dto/logindto';
import { RegisterDTO } from 'src/dto/registerdto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class LoginService{
  user: UserDTO;

  constructor(private http: HttpClient) { }

  auth() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    console.log("stampa user: "+localStorage.getItem('currentUser'))
    if(this.user) {
        return 'Bearer ' + this.user.authorities;
    } else {
        return '';
    }
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(result);
      console.error(error);
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }

  register(registerdto: RegisterDTO) {
    return this.http.post('http://localhost:8080/api/register', registerdto);
  }

  login(logindto: LoginDTO) {
    console.log(this.auth());
    return this.http.post('http://localhost:8080/api/authenticate', logindto);
    
  }

  getUserLogged(username: string){
      return this.http.get('http://localhost:8080/api/users/'+ username,
       {headers:{Authorization: this.auth()}
      });
}
}
