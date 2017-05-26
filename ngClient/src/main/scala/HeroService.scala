package com.lucidchart

import angulate2.std._
import rxjs.RxPromise

import scala.scalajs.js

@Injectable()
class HeroService {
  private val heroesPromise = RxPromise.resolve(Heroes.all)

  val heroesUrl = "app/heroes"

  def getHeroes(): RxPromise[js.Array[Hero]] = heroesPromise

  def getHero(id: Int): RxPromise[Hero] =
    heroesPromise.map( all => Heroes.all.find(_.id==id).get )

}

object Heroes {
  val all = @@@(
    Hero(11, "Mr. Nice"),
    Hero(12, "Narco"),
    Hero(13, "Bombasto"),
    Hero(14, "Celeritas"),
    Hero(15, "Magneta"),
    Hero(16, "RubberMan"),
    Hero(17, "Dynama"),
    Hero(18, "Dr IQ"),
    Hero(19, "Magma"),
    Hero(20, "Tornado")
  )
}
