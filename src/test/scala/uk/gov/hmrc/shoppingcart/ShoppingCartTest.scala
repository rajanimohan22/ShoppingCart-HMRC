package uk.gov.hmrc.shoppingcart

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Mohan Dolla on 10/12/2017.
  */
class CheckoutSpec extends FlatSpec with Matchers {

  "A checkout system" should "compute prices correctly" in {
    val checkout = new Checkout(RegularPricing)
    checkout.calculate(List.empty[Product]) should be (0)
    checkout.calculate(List( Apple)) should be (60)
    checkout.calculate(List( Orange)) should be (25)
    checkout.calculate(List( Apple, Apple,  Orange, Apple)) should be (205)
  }


  it should "compute prices for deals correctly" in {
    val checkout = new Checkout(OfferPricing)
    checkout.calculate(List.empty[Product]) should be (0)
    checkout.calculate(List(Apple)) should be (60)
    checkout.calculate(List(Apple, Apple)) should be (60)
    checkout.calculate(List(Apple, Apple, Apple)) should be (120)
    checkout.calculate(List(Apple, Apple, Apple, Apple)) should be (120)
    checkout.calculate(List(Orange)) should be (25)
    checkout.calculate(List(Orange, Orange)) should be (50)
    checkout.calculate(List(Orange, Orange, Orange)) should be (50)
    checkout.calculate(List(Orange, Orange, Orange, Orange)) should be (75)
    checkout.calculate(List(Orange, Orange, Orange, Orange, Orange)) should be (100)
    checkout.calculate(List(Orange, Orange, Orange, Orange, Orange, Orange)) should be (100)
  }

  it should "compute prices for deals correctly even when added out of order" in {
    val checkout = new Checkout(OfferPricing)
    checkout.calculate(List(Apple, Orange)) should be (85)
    checkout.calculate(List(Apple, Orange, Apple)) should be (85)
    checkout.calculate(List(Orange, Apple, Orange, Apple, Orange)) should be (110)
  }
}
