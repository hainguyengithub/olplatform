import { Component, Input, OnInit } from '@angular/core';
import { Program } from '../Program';
import { ProgramService } from '../service/program.service';

@Component({
  selector: 'app-program-list-widget',
  templateUrl: './program-list-widget.component.html',
  styleUrls: ['./program-list-widget.component.scss'],
})
export class ProgramListWidgetComponent implements OnInit {
  // @Input() public programs: Program[] | null = [];
  public programs: Program[] | null = [];

  constructor(private programService: ProgramService) {}

  ngOnInit(): void {
    this.programService.load().subscribe((payload) => {
      console.log(payload);
      this.programs = payload;
    });
  }
}
