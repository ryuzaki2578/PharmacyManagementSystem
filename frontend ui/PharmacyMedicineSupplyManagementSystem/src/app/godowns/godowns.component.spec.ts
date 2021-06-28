import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GodownsComponent } from './godowns.component';

describe('GodownsComponent', () => {
  let component: GodownsComponent;
  let fixture: ComponentFixture<GodownsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GodownsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GodownsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
