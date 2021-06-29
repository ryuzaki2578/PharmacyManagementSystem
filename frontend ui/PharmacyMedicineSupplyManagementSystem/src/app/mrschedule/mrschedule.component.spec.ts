import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MRScheduleComponent } from './mrschedule.component';

describe('MRScheduleComponent', () => {
  let component: MRScheduleComponent;
  let fixture: ComponentFixture<MRScheduleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MRScheduleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MRScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
