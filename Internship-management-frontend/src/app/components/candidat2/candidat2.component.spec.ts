import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Candidat2Component } from './candidat2.component';

describe('Candidat2Component', () => {
  let component: Candidat2Component;
  let fixture: ComponentFixture<Candidat2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Candidat2Component]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(Candidat2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
