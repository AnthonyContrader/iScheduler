import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router'; 
import { style, transition, animate, trigger, state } from '@angular/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService],
  animations:[
    trigger('divState', [
      state('moveR', style({
        transform: 'translateX(-90%) translateY(-50%)', 
      })),
      state('moveL', style({
        transform: 'translateX(-10%) translateY(-50%)', 
      })),
      transition('spin => move', animate('2000ms ease-out')),
      transition('*=>*', animate('1000ms ease')),
    ])
  ]
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) { }

  position: string;

  changePosition(newPosition: string){
    this.position = newPosition;
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
