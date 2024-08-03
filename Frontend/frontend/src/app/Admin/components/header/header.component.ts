import { Component } from '@angular/core';
import { MatSlideToggleModule } from '@angular/material/slide-toggle'
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [MatSlideToggleModule, MatButtonModule, MatInputModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
