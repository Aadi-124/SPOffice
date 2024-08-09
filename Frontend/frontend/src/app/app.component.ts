import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './Admin/components/header/header.component';
import { CommonModule, NgFor } from '@angular/common';
import { FooterComponent } from './Admin/components/footer/footer.component';
import { PoliceSignupComponent } from './pages/police-signup/police-signup.component';
import { SubAdminSignupComponent } from './pages/sub-admin-signup/sub-admin-signup.component';
import { AdminSignupComponent } from './pages/admin-signup/admin-signup.component';
import { LoginComponent } from './pages/login/login.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HeaderComponent, FooterComponent,NgFor, PoliceSignupComponent, SubAdminSignupComponent, AdminSignupComponent, LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
