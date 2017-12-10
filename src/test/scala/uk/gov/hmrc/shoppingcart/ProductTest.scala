package uk.gov.hmrc.shoppingcart

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Mohan Dolla on 10/12/2017.
  */
class ProductSpec extends FlatSpec with Matchers {

  "A Product List" should "compute its size correctly" in {
    List.empty[Product].size should be (0)
    List(Apple).size should be (1)
    List(Apple, Orange, Apple, Orange, Apple, Orange, Apple).size should be (7)
  }

  "A checkout system" should "return zero for an Empty List" in {
    val shoppingCart = ShoppingCart.buildfromItems(List.empty)
    RegularPricing.total(shoppingCart) should be (0)
  }

  "A checkout system" should "compute prices" in {
    val shoppingCart = ShoppingCart.buildfromItems(List(Apple, Orange))
    RegularPricing.total(shoppingCart) should be (85)
  }

  "A checkout system" should "compute prices correctly" in {
    val shoppingCart = ShoppingCart.buildfromItems(List(Apple, Apple, Orange, Apple))
    RegularPricing.total(shoppingCart) should be (205)
  }

}
