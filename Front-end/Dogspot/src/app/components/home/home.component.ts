import { Component, Input } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgOptimizedImage],
  providers: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  @Input() loginTitle: string = "";
  @Input() primaryBtnTxt: string = "";
  @Input() secondaryBtnTxt: string = "";
}
