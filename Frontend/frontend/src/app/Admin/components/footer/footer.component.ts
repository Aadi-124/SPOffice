import { NgFor } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [NgFor],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css',
})
export class FooterComponent {
  footerLinks = [
    {
      blockTitle: 'Explore',
      links: [
        { link: '#', title: 'explore1' },
        { link: '#', title: 'explore2' },
        { link: '#', title: 'explore3' },
        { link: '#', title: 'explore4' },
      ],
    },
    {
      blockTitle: 'Knowledge',
      links: [
        { link: '#', title: 'Knowledge1' },
        { link: '#', title: 'Knowledge2' },
        { link: '#', title: 'Knowledge3' },
        { link: '#', title: 'Knowledge4' },
      ],
    },
    {
      blockTitle: 'Contacts',
      links: [
        { link: '#', title: 'Contacts1' },
        { link: '#', title: 'Contacts2' },
        { link: '#', title: 'Contacts3' },
        { link: '#', title: 'Contacts4' },
      ],
    },
  ];
}
