import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmerprofileComponent } from './farmerprofile.component';

describe('FarmerprofileComponent', () => {
  let component: FarmerprofileComponent;
  let fixture: ComponentFixture<FarmerprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FarmerprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmerprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
