import { TestBed } from '@angular/core/testing';
import { SenhaAdmService } from './senha-adm.service';

describe('SenhaAdmService', () => {
  let service: SenhaAdmService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SenhaAdmService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
