import { TestBed } from '@angular/core/testing';

import { PlaceorderService } from './placeorder.service';

describe('PlaceorderService', () => {
  let service: PlaceorderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlaceorderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
