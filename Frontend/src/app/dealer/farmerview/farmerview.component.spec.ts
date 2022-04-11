import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmerviewComponent } from './farmerview.component';

describe('FarmerviewComponent', () => {
  let component: FarmerviewComponent;
  let fixture: ComponentFixture<FarmerviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FarmerviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmerviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
