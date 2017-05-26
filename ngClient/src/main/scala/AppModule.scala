package com.lucidchart

import angulate2.std._
import angulate2.forms.FormsModule
import angulate2.http.HttpModule
import angulate2.platformBrowser.BrowserModule

@NgModule(
  imports = @@[
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutes
  ],
  declarations = @@[
    AppComponent,
    HeroDetailComponent,
    HeroesComponent,
    DashboardComponent
  ],
  providers = @@[HeroService],
  bootstrap = @@[AppComponent]
)
class AppModule {

}