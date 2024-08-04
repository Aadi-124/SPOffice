import { NgClass, NgFor} from '@angular/common';
import { Component, NgModule } from '@angular/core';


@Component({
  selector: 'app-header-navbar',
  standalone: true,
  imports: [NgFor, NgClass],
  templateUrl: './header-navbar.component.html',
  styleUrl: './header-navbar.component.css',
})


export class HeaderNavbarComponent {
  navElements = [
    { img: 'https://cdn-icons-png.flaticon.com/128/1946/1946488.png', title: 'Home' , active: true},
    { img: 'https://cdn-icons-png.flaticon.com/128/3503/3503827.png', title: 'About', active: false },
    { img: 'https://cdn-icons-png.flaticon.com/128/833/833593.png', title: 'Calendar', active: false },
    { img: 'https://cdn-icons-png.flaticon.com/128/1077/1077063.png', title: 'Profile', active: false},
    { img: 'https://cdn-icons-png.flaticon.com/128/1286/1286853.png', title: 'Log out', active: false }
  ];

  setActive(index: number) {
    this.navElements.forEach((element, i) => element.active = i === index);
  }
}
