import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { EventHistoryDTO } from 'src/dto/eventhistorydto';
import { HttpClient } from '@angular/common/http';
@Injectable({
    providedIn: 'root'
})
export class EventHistoryService extends AbstractService<EventHistoryDTO> {
    constructor(http: HttpClient) {
        super(http);
        this.type = 'eventhistory';
    }
}
