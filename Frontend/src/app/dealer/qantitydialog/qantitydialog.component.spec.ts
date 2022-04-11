import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QantitydialogComponent } from './qantitydialog.component';

describe('QantitydialogComponent', () => {
  let component: QantitydialogComponent;
  let fixture: ComponentFixture<QantitydialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QantitydialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QantitydialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
