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
    this.type = 'event';
   }

   getAllById(userDTO: UserDTO): Observable<EventDTO[]>{
     return this.http.post<EventDTO[]>('http://localhost:8080/'+ this.type + '/getallbyuser',userDTO);
   }
}
