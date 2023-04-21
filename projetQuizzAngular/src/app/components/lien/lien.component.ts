import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-lien',
  templateUrl: './lien.component.html',
  styleUrls: ['./lien.component.css']
})
export class LienComponent {
  @Input()
  lien!: string;
  @Input()
  etiquetteLien!: string;

}
