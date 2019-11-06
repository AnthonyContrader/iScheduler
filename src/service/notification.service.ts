import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { NotificationDTO } from 'src/dto/notificationdto';
import { HttpClient } from '@angular/common/http';
import { EventDTO } from 'src/dto/eventdto';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class NotificationService extends AbstractService<NotificationDTO>{
    
    constructor(http: HttpClient){
      super(http);
      this.type = 'notification';
    }

    getNotificationByEvent(eventDTO: EventDTO): Observable<NotificationDTO[]>{
      return this.http.post<NotificationDTO[]>('http://localhost:8080/'+this.type+'/getnotificationbyevent', eventDTO);
    }

    getAllByEvent(eventDTO: EventDTO): Observable<NotificationDTO[]>{
      return this.http.post<any>('http://localhost:8080/'+ this.type + '/getallbyevent', eventDTO);
    }
}