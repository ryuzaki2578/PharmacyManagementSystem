import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineDemandComponent } from './medicine-demand.component';

describe('MedicineDemandComponent', () => {
  let component: MedicineDemandComponent;
  let fixture: ComponentFixture<MedicineDemandComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedicineDemandComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineDemandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
