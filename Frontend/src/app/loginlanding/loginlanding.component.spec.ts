import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginlandingComponent } from './loginlanding.component';

describe('LoginlandingComponent', () => {
  let component: LoginlandingComponent;
  let fixture: ComponentFixture<LoginlandingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginlandingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginlandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
