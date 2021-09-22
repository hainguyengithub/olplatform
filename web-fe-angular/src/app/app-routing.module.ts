import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProgramListWidgetComponent } from './program/program-list-widget/program-list-widget.component';

const routes: Routes = [
  {
    path: 'programs',
    component: ProgramListWidgetComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
