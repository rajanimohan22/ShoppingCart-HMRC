package uk.gov.hmrc.shoppingcart

/**
  * Created by Mohan Dolla on 10/12/2017.
  */
class Checkout(pricing: Pricing) {
  def calculate(cart: ShoppingCart): Long = {
    pricing.total(cart)
  }

  def calculate(products: List[Product]): Long = calculate(ShoppingCart.buildfromItems(products))
}
