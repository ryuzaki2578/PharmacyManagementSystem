import { TestBed } from '@angular/core/testing';

import { MrScheduleService } from './mrschedule.service';

describe('MrScheduleService', () => {
  let service: MrScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MrScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
