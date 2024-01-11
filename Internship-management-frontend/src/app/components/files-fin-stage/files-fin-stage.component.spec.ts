import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilesFinStageComponent } from './files-fin-stage.component';

describe('FilesFinStageComponent', () => {
  let component: FilesFinStageComponent;
  let fixture: ComponentFixture<FilesFinStageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FilesFinStageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FilesFinStageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
