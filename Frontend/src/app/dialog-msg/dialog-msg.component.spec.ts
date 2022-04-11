import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogMsgComponent } from './dialog-msg.component';

describe('DialogMsgComponent', () => {
  let component: DialogMsgComponent;
  let fixture: ComponentFixture<DialogMsgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogMsgComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogMsgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
