package uk.gov.hmrc.shoppingcart

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Mohan Dolla on 10/12/2017.
  */
class CheckoutSpec extends FlatSpec with Matchers {

  "A Product List" should "compute its size correctly" in {
    List.empty[Product].size should be (0)
    List(Apple).size should be (1)
    List(Apple, Orange, Apple, Orange, Apple, Orange, Apple).size should be (7)

  }

}
