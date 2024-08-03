import { Component } from '@angular/core';
import { HeaderNavbarComponent } from './header-navbar/header-navbar.component';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [HeaderNavbarComponent, CommonModule, NgFor],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
