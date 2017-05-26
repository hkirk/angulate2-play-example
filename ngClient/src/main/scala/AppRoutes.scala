package com.lucidchart

import angulate2.std._

@Routes(
  root = false,
  Route(path = "", component = %%[HeroesComponent]),
  Route(path = "heroes", component = %%[HeroesComponent]),
  Route(path = "dashboard", component = %%[DashboardComponent]),
  Route(path = "detail/:id", component = %%[HeroDetailComponent])
)
class AppRoutes { }