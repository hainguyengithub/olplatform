import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

const MaterialComponents = [
  MatButtonModule,
  MatCardModule,
  MatMenuModule,
  MatIconModule,
  MatListModule,
  MatToolbarModule,
  // reactive forms
  MatInputModule,
  MatFormFieldModule,
];

@NgModule({
  declarations: [],
  imports: [CommonModule],
  exports: [...MaterialComponents],
})
export class MaterialComponentsModule {}
