import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from "../environments/environment";


interface Task{
  title:string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  title = 'angular';
  private http:HttpClient = inject(HttpClient);

   baseUrl =  environment.API_URL;

  tasks$ =  this.http.get<Task[]>(`${this.baseUrl}/api/v1/tasks`);


}
