import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { style, transition, animate, trigger, state } from '@angular/animations';
import { LoginService } from 'src/service/login.service';
import { UserDTO } from 'src/dto/userdto';

/*
@Author Federico Maglione.
*/

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService],
  animations: [
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
        opacity: 0,
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

  constructor(private service: LoginService, private router: Router) { }

  position: string;
  dimensionR: string;
  dimensionL: string;


  changePosition(newPosition: string) {
    this.position = newPosition;
  }

  changeDimensionL(newDimensionL: string, newDimensionR: string) {
    this.dimensionL = newDimensionL;
    this.dimensionR = newDimensionR;
  }
  changeDimensionR(newDimension: string) {
    this.dimensionR = newDimension;
  }



  ngOnInit() {

  }


  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);
    this.service.login(this.loginDTO).subscribe((response: any) => {
      localStorage.setItem('currentUser', JSON.stringify({ authorities: response.id_token }));

      this.service.getUserLogged(this.loginDTO.username).subscribe((response: UserDTO) => {
        localStorage.setItem('currentUserData', JSON.stringify(response));

        if (response.authorities.includes('ROLE_ADMIN')) {
          this.router.navigate(['/admin-dashboard']);
        } else  if (response.authorities.includes('ROLE_USER')){
          this.router.navigate(['/user-dashboard']);
        }
      });
    });
  }
}