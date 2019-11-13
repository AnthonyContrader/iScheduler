import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EventDTO } from 'src/dto/eventdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
  providedIn: 'root'
})
export class EventService extends AbstractService<EventDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.micro = 'microservice1';
    this.type = 'event';
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

   getAllById(userDTO: UserDTO): Observable<EventDTO[]>{
     return this.http.post<EventDTO[]>('http://localhost:8080/'+ this.micro + '/api/' + this.type + '/getAllByUser',userDTO);
   }
}
