import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineSupplyComponent } from './medicine-supply.component';

describe('MedicineSupplyComponent', () => {
  let component: MedicineSupplyComponent;
  let fixture: ComponentFixture<MedicineSupplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedicineSupplyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineSupplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
