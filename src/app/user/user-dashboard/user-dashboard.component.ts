import { Component, OnInit } from '@angular/core';
import { EventDTO } from 'src/dto/eventdto';
import { EventService } from 'src/service/event.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  events: EventDTO[];
  user: UserDTO;

  constructor(private service: EventService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getEvents();
  }

  getEvents(){
    console.log(localStorage.getItem('currentUser'));
    this.service.getAllById(this.user).subscribe(events => this.events = events);
  }

  

}
