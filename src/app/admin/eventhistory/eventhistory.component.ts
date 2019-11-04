import { Component, OnInit } from '@angular/core';
import { EventHistoryService } from "src/service/eventhistory.service";
import { EventHistoryDTO } from 'src/dto/eventhistorydto';



@Component({
    selector: 'app-eventhistory',
    templateUrl: './eventhistory.component.html',
    styleUrls: ['./eventhistory.component.css']
})

export class EventHistoryComponent implements OnInit{

    eventhistorys: EventHistoryDTO[];
    eventhistoryins: EventHistoryDTO = new EventHistoryDTO();
    
    constructor(private historyService: EventHistoryService){}

    ngOnInit(){
        this.getEventHistory();
      
    }



    getEventHistory(){
        this.historyService.getAll().subscribe(eventhistorys => this.eventhistorys = eventhistorys );
    }

    delete(eventhistory: EventHistoryDTO){
        this.historyService.delete(eventhistory.id).subscribe(()=> this.getEventHistory());

    }
    
    update(eventhistory: EventHistoryDTO){
        this.historyService.update(eventhistory).subscribe(()=> this.getEventHistory());
    }
    
    insert(eventhistory: EventHistoryDTO){
        this.historyService.insert(eventhistory).subscribe(()=> this.getEventHistory());
    }


    clear(){
        this.eventhistoryins = new EventHistoryDTO();
    }
}