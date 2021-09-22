import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgramListWidgetComponent } from './program-list-widget/program-list-widget.component';
import { ProgramLandingPageComponent } from './program-landing-page/program-landing-page.component';
import { MaterialComponentsModule } from '../material-components/material-components.module';

@NgModule({
  declarations: [ProgramListWidgetComponent, ProgramLandingPageComponent],
  imports: [CommonModule, MaterialComponentsModule],
})
export class ProgramModule {}
