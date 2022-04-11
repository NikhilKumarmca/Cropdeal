import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmerheaderComponent } from './farmerheader.component';

describe('FarmerheaderComponent', () => {
  let component: FarmerheaderComponent;
  let fixture: ComponentFixture<FarmerheaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FarmerheaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmerheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
