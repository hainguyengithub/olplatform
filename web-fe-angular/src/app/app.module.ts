import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { MaterialComponentsModule } from './material-components/material-components.module';
import { ProgramModule } from './program/program.module';

@NgModule({
  declarations: [AppComponent, HomeComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialComponentsModule,
    HttpClientModule /* Not HttpClient; Otherwise, JIT compiler fails. */,
    //
    ProgramModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
