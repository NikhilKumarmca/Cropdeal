import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DealerheaderComponent } from './dealerheader.component';

describe('DealerheaderComponent', () => {
  let component: DealerheaderComponent;
  let fixture: ComponentFixture<DealerheaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DealerheaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DealerheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
