import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-farmerview',
  templateUrl: './farmerview.component.html',
  styleUrls: ['./farmerview.component.css']
})
export class FarmerviewComponent implements OnInit {
  farmer;
  constructor(@Inject(MAT_DIALOG_DATA) public data) { 
    this.farmer = this.data.farmer
  }

  ngOnInit(): void {
  }

}
