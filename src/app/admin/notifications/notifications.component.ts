import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/service/event.service';
import { NotificationService } from 'src/service/notification.service';
import { NotificationDTO } from 'src/dto/notificationdto';
import { EventDTO } from 'src/dto/eventdto';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css'],
  providers: [NotificationService, EventService]
})
export class NotificationsComponent implements OnInit {

  notifications: NotificationDTO[];
  events: EventDTO[];
  notinsert: NotificationDTO = new NotificationDTO();
  event: EventDTO;
  constructor( private notService: NotificationService) { }

  ngOnInit() {
  this.event = JSON.parse(localStorage.getItem('Event'));
    this.getNotifications();
  }

  getNotifications(){
    this.notService.getAllByEvent(this.event).subscribe(notifications => this.notifications = notifications);
  }
  
  insert(notification: NotificationDTO){
    notification.eventDTO = this.event;
    this.notService.insert(notification).subscribe(() => this.getNotifications());
  }

  delete(notification: NotificationDTO){
    this.notService.delete(notification.id).subscribe(()=> this.getNotifications());
  }

  clear(){
   this.notinsert = new NotificationDTO();
  }

}
