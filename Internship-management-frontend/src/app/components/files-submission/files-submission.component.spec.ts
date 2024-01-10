import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilesSubmissionComponent } from './files-submission.component';

describe('FilesSubmissionComponent', () => {
  let component: FilesSubmissionComponent;
  let fixture: ComponentFixture<FilesSubmissionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FilesSubmissionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FilesSubmissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
