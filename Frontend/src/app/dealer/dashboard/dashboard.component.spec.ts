import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealerDashboardComponent } from './dashboard.component';

describe('DashboardComponent', () => {
  let component: DealerDashboardComponent;
  let fixture: ComponentFixture<DealerDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DealerDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DealerDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
