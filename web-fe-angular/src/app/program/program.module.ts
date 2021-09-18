import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgramListWidgetComponent } from './program-list-widget/program-list-widget.component';
import { ProgramLandingPageComponent } from './program-landing-page/program-landing-page.component';



@NgModule({
  declarations: [
    ProgramListWidgetComponent,
    ProgramLandingPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ProgramModule { }
