import { Component } from '@angular/core';
import { HomeComponent } from '../../components/home/home.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HomeComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

}
