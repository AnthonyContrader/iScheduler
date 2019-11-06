import { Component, OnInit } from '@angular/core';

  import { UserService } from 'src/service/user.service';
import { EventService } from 'src/service/event.service';
import { EventDTO } from 'src/dto/eventdto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css'],
  providers: [EventService, UserService]
})

export class EventsComponent implements OnInit {

  events: EventDTO[];
  users: UserDTO[];
  eventinsert: EventDTO = new EventDTO();
  user : UserDTO;

  constructor(private userService: UserService, private eventService: EventService) { }

  ngOnInit() {
    this.getUsers();
    this.getEvents();
   
  }

  getEvents(){
   this.eventService.getAll().subscribe(events => this.events = events);
  }

  getUsers(){
    this.userService.getAll().subscribe(users => this.users = users);
  }


  insert(event: EventDTO){
    this.user = this.eventinsert.userDTO;
    event.userDTO = this.user;
    this.eventService.insert(event).subscribe(() => this.getEvents());
  }


 delete(event:EventDTO){

    this.eventService.delete(event.id).subscribe(() => this.getEvents());
  }
  
  getEvent(event: EventDTO){
    localStorage.setItem('Event', JSON.stringify(event));
  }
  

  clear(){
    this.eventinsert = new EventDTO();
  }

}

