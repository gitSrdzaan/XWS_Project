import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexCompComponent } from './index-comp/index-comp.component';
import { LoginCompComponent } from './login-comp/login-comp.component';
import { RegisterCompComponent } from './register-comp/register-comp.component';
import { PackageCompComponent } from './package-comp/package-comp.component';
import { ServicesCompComponent } from './services-comp/services-comp.component';
import { Index2CompComponent } from './index2-comp/index2-comp.component';
import { Index3CompComponent } from './index3-comp/index3-comp.component';
import { HelpDeskCompComponent } from './help-desk-comp/help-desk-comp.component';
import { GalleryCompComponent } from './gallery-comp/gallery-comp.component';
import { FaqCompComponent } from './faq-comp/faq-comp.component';
import { DriverCompComponent } from './driver-comp/driver-comp.component';
import { ContactCompComponent } from './contact-comp/contact-comp.component';
import { CarWithoutSidebarCompComponent } from './car-without-sidebar-comp/car-without-sidebar-comp.component';
import { CarRightSidebarCompComponent } from './car-right-sidebar-comp/car-right-sidebar-comp.component';
import { CarLeftSidebarComponent } from './car-left-sidebar/car-left-sidebar.component';
import { CarDetailsCompComponent } from './car-details-comp/car-details-comp.component';
import { ArticleDetailsCompComponent } from './article-details-comp/article-details-comp.component';
import { ArticleComponentComponent } from './article-component/article-component.component';
import { AboutCompComponent } from './about-comp/about-comp.component';
import { Comp404Component } from './comp404/comp404.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexCompComponent,
    LoginCompComponent,
    RegisterCompComponent,
    PackageCompComponent,
    ServicesCompComponent,
    Index2CompComponent,
    Index3CompComponent,
    HelpDeskCompComponent,
    GalleryCompComponent,
    FaqCompComponent,
    DriverCompComponent,
    ContactCompComponent,
    CarWithoutSidebarCompComponent,
    CarRightSidebarCompComponent,
    CarLeftSidebarComponent,
    CarDetailsCompComponent,
    ArticleDetailsCompComponent,
    ArticleComponentComponent,
    AboutCompComponent,
    Comp404Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
