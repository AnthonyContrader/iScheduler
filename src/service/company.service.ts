import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { CompanyDTO } from 'src/dto/companydto';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends AbstractService<CompanyDTO>{
  constructor(http: HttpClient) {
      super(http);
      this.type = 'company';
    }
}

