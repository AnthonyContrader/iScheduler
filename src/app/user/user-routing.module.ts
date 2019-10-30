import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

/**
 * Modulo di routing dello user. Qui ci sono i percosi
 * per indirizzare l'utente tramite il menu e le sue sezioni.
 * 
 * @author Federico Mag.
 * 
 */

const routes: Routes = [
  { 
    path: 'user-dashboard', component: UserLayoutComponent, children:[
      {
        path: '', component: UserDashboardComponent
      }
    ]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
