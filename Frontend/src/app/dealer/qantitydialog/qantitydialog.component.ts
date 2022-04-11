import { Component, Inject, OnInit } from '@angular/core';
import {  MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
// import { DialogData } from '../home/home.component';


@Component({
  selector: 'app-qantitydialog',
  templateUrl: './qantitydialog.component.html',
  styleUrls: ['./qantitydialog.component.css']
})
export class QantitydialogComponent implements OnInit {
  order:any={
    dealerId:"",
    productName:"",
    productPrice:"",
    productQnt:""    
  };
  constructor(public dialogRef: MatDialogRef<QantitydialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit(): void {
    // console.log(this.data);
    
  }

  //  onNoClick(): void {
  //   this.dialogRef.close();
  // }

}
