package uk.gov.hmrc.shoppingcart

/**
  * Created by Mohan Dolla on 10/12/2017.
  */
trait Pricing {
  def total(cart: ShoppingCart): Long
}

//This class defines basic rates for the products that are avilable in the ProductList
object RegularPricing extends Pricing {
  def price(product: Product): Long = product match {
    case Apple => 60
    case Orange => 25
  }

  //The KeySet of cart Map is iterated and the prices are computed at the base-rate.
  def total(cart: ShoppingCart): Long = {
    cart.items.keySet.map {
      key => price(key) * cart.items.get(key).getOrElse(0L)
    }.sum
  }
}

object OfferPricing extends Pricing {
  private val regularPricing = RegularPricing

  def total(cart: ShoppingCart): Long = {
    cart.items.keySet.map {
      key => val n = cart.items.get(key).getOrElse(0L)
        val noItemsAfterDiscount = key match {
          case Apple=> (n / 2) + (n % 2)
          case Orange=> (n / 3) * 2 + (n % 3)
          case _ => n
        }
        regularPricing.price(key) * noItemsAfterDiscount
    }.sum
  }
}

