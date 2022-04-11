import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealerHomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: DealerHomeComponent;
  let fixture: ComponentFixture<DealerHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DealerHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DealerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
