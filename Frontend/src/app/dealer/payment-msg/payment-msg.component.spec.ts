import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentMsgComponent } from './payment-msg.component';

describe('PaymentMsgComponent', () => {
  let component: PaymentMsgComponent;
  let fixture: ComponentFixture<PaymentMsgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentMsgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentMsgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
