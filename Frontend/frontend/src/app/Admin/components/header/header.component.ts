import { Component, HostListener } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { MatIconModule } from '@angular/material/icon'


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, NgFor, MatIconModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  showDialog: boolean = true;

  navElements = [
    { img: 'https://cdn-icons-png.flaticon.com/128/1946/1946488.png', title: 'Home', active: true },
    { img: 'https://cdn-icons-png.flaticon.com/128/3503/3503827.png', title: 'About', active: false },
    { img: 'https://cdn-icons-png.flaticon.com/128/833/833593.png', title: 'Calendar', active: false },
    { img: 'https://cdn-icons-png.flaticon.com/128/1077/1077063.png', title: 'Profile', active: false },
    { img: 'https://cdn-icons-png.flaticon.com/128/1286/1286853.png', title: 'Log out', active: false }
  ];

  @HostListener('window:resize', ['$event'])
  onResize() {
    if (window.innerWidth > 500) {
      this.showDialog = true;
    }
    else{
      this.showDialog = false;
    }
  }

  setActive(index: number) {
    this.navElements.forEach((element, i) => element.active = i === index);
  }

}
