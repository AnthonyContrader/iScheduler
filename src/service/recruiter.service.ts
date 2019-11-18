import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { RecruiterDTO } from 'src/dto/recruiterdto';

@Injectable({
  providedIn: 'root'
})
export class RecruiterService extends AbstractService<RecruiterDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'recruiter';
  }
}
