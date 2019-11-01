import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router'; 
import { style, transition, animate, trigger, state } from '@angular/animations';

/*
@Author Federico Maglione.
*/

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService],
  animations:[
    trigger('divState', [
      state('moveR', style({
        transform: 'translateX(-10%) translateY(-50%)', 
      })),
      state('moveL', style({
        transform: 'translateX(-90%) translateY(-50%)', 
      })),
      transition('* => *', animate('1000ms ease-out')),
      
    ]),

    trigger('imgStateL', [
      state('left', style({
        opacity: 1,
        transform: 'scale(1.0)',
      })),
      state('right', style({
        opacity: 0,
        transform: 'scale(0.0)',
      })),
      transition('* => right', animate('500ms ease')),
      transition('* => left', animate('1700ms ease')),
    ]),

    trigger('imgStateR', [
      state('left', style({
       
        transform: 'scale(0.0)',
      })),
      state('right', style({
        opacity: 1,
        transform: 'scale(1.0)',
      })),
      transition('* => right', animate('1700ms ease')),
      transition('* => left', animate('500ms ease')),
    ]),

    trigger('imgStateR', [
      state('left', style({
       
        transform: 'scale(0.0)',
      })),
      state('right', style({
        opacity: 1,
        transform: 'scale(1.0)',
      })),
      transition('* => right', animate('1700ms ease')),
      transition('* => left', animate('500ms ease')),
    ]),



  ]
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  showR: boolean = false;
  showL: boolean = false;
  
  constructor(private service: UserService, private router: Router) { }

  position: string;
  dimensionR: string;
  dimensionL: string;
  

  changePosition(newPosition: string){
    this.position = newPosition;
  }

  changeDimensionL(newDimensionL: string, newDimensionR: string){
    this.dimensionL = newDimensionL;
    this.dimensionR = newDimensionR;
  }
  changeDimensionR(newDimension: string){
    this.dimensionR = newDimension;
  }

  

  ngOnInit() {
    
    
  
  }


  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {

      if (user != null) {
        
        localStorage.setItem('currentUser', JSON.stringify(user));
        console.log(localStorage.getItem('currentUser'));
        switch (user.usertype.toString()) {
          case 'ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'USER': {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          default:
            this.router.navigate(['/login']);
        }
      }
    });
  }
}
