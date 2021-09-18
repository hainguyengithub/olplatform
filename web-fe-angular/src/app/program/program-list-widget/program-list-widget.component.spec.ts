import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramListWidgetComponent } from './program-list-widget.component';

describe('ProgramListWidgetComponent', () => {
  let component: ProgramListWidgetComponent;
  let fixture: ComponentFixture<ProgramListWidgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgramListWidgetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgramListWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
