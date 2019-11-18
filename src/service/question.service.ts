import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { QuestionDTO } from 'src/dto/questiondto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestionService extends AbstractService<QuestionDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'question';
  }
}
