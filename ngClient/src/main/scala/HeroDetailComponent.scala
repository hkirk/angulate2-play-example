package com.lucidchart

import org.scalajs.dom

import angulate2.std._
import angulate2.router.{ActivatedRoute, Router}
import scala.annotation.{Annotation, StaticAnnotation}
import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.JSName
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

@Component(
  selector = "my-hero-detail",
  templateUrl = "assets/hero-detail.component.html",
  styleUrls = js.Array("assets/hero-detail.component.css")
)
class HeroDetailComponent(
  heroService: HeroService,
  route: ActivatedRoute
) extends OnInit with OnDestroy {
  @Input()
  var hero: js.UndefOr[Hero] = js.undefined
  var sub: Future[Option[Unit]] = null

  def goBack(): Unit = {
    dom.window.history.back()
  }

  def ngOnInit(): Unit = {
    route.params
      .switchMap( (params,_) => heroService.getHero(params("id").toInt) )
      .subscribe( this.hero = _ )
//    sub = route.params.subscribe { (params: js.Dynamic) =>
//      val id = params.selectDynamic("id").asInstanceOf[String].toInt
//      heroService.getHero(id).map { hero =>
//        hero.map(this.hero = _)
//      }
//    }
  }

  def ngOnDestroy(): Unit = {
    //sub.map(_.unsubscribe())
  }
}
